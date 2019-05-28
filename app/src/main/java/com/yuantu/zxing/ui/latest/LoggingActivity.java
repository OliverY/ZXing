package com.yuantu.zxing.ui.latest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yuantu.zxing.config.AppConfig;
import com.yuantu.zxing.BaseActivity;
import com.yuantu.zxing.Constants;
import com.yuantu.zxing.R;
import com.yuantu.zxing.bean.ConfigBean;
import com.yuantu.zxing.bean.EquipmentBean;
import com.yuantu.zxing.bean.SubmitBean;
import com.yuantu.zxing.net.ApiFactory;
import com.yuantu.zxing.net.bean.ApiResponse;
import com.yuantu.zxing.utils.BottomDialog;
import com.yuantu.zxing.utils.ProgressUtils;
import com.yuantu.zxing.utils.ToastUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午2:36
 * -----------------------------------------
 * Description:
 */
public class LoggingActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvType;
    private TextView tvTypeCode;
    private TextView tvBarCode;
    private TextView tvStages;
    private TextView tvHospital;
    private Button btnSure;
    private EquipmentBean equipmentBean;
    private BottomDialog bottomDialog;
    private List<ConfigBean.Config> stageList;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_logging);

        setTitle("登记进度");

        equipmentBean = (EquipmentBean) getIntent().getSerializableExtra(Constants.ActivityExtra.EQUIPMENT);
        stageList = AppConfig.getInstance().getConfigBean().getTypeId_123();

        tvType = findViewById(R.id.tv_type_value);
        tvTypeCode = findViewById(R.id.tv_type_code_value);
        tvBarCode = findViewById(R.id.tv_bar_code_value);
        tvStages = findViewById(R.id.tv_stages_value);
        tvHospital = findViewById(R.id.tv_hospital_value);
        btnSure = findViewById(R.id.btn_sure);

        tvStages.setOnClickListener(this);
        btnSure.setOnClickListener(this);

        tvType.setText(equipmentBean.getDeviceTypeDesc());
        tvTypeCode.setText(equipmentBean.getDeviceTypeName());
        tvBarCode.setText(equipmentBean.getBarcode());
        tvHospital.setText(equipmentBean.getHospitalName());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_stages_value:
                // 唤起选择器
                showBottomDialog();
                break;
            case R.id.btn_sure:
                // 提交
                SubmitBean submitBean = new SubmitBean();
                submitBean.setBarCode(equipmentBean.getBarcode());
                submitBean.setDeviceId(equipmentBean.getId());
                submitBean.setProjectId(equipmentBean.getHospitalId());
                if(getStage(tvStages.getText().toString())==0){
                    ToastUtils.showShort(LoggingActivity.this,"请选择阶段");
                    return;
                }

                submitBean.setPlanOnwardStatus(getStage(tvStages.getText().toString()));

                progressDialog = ProgressUtils.show(this);
                ApiFactory.loggingScheduler(submitBean)
                        .subscribe(new Observer<ApiResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ApiResponse apiResponse) {
                                progressDialog.dismiss();
                                if(apiResponse.isSuccess()){
                                    ToastUtils.showShort(LoggingActivity.this,"提交成功");
                                    finish();
                                }else{
                                    ToastUtils.showShort(LoggingActivity.this,"提交失败");
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                progressDialog.dismiss();
                                ToastUtils.showShort(LoggingActivity.this,"提交失败");
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
        }
    }

    private void showBottomDialog() {
        View view = View.inflate(this,R.layout.bottom_dialog_submit,null);
        TextView stage1 = view.findViewById(R.id.tv_stage_1);
        TextView stage2 = view.findViewById(R.id.tv_stage_2);
        TextView stage3 = view.findViewById(R.id.tv_stage_3);

        stage1.setText(stageList.get(0).getDescribe());
        stage2.setText(stageList.get(1).getDescribe());
        stage3.setText(stageList.get(2).getDescribe());

        int selectIndex = -1;

        for (int i = 0; i < stageList.size(); i++) {
            if(stageList.get(i).getDescribe().equals(tvStages.getText().toString())){
                selectIndex = i;
                break;
            }
        }

        switch (selectIndex){
            case 0:
                stage1.setTextColor(getResources().getColor(R.color.color_429FFF));
                stage2.setTextColor(getResources().getColor(R.color.black_333333));
                stage3.setTextColor(getResources().getColor(R.color.black_333333));
                break;
            case 1:
                stage1.setTextColor(getResources().getColor(R.color.black_333333));
                stage2.setTextColor(getResources().getColor(R.color.color_429FFF));
                stage3.setTextColor(getResources().getColor(R.color.black_333333));
                break;
            case 2:
                stage1.setTextColor(getResources().getColor(R.color.black_333333));
                stage2.setTextColor(getResources().getColor(R.color.black_333333));
                stage3.setTextColor(getResources().getColor(R.color.color_429FFF));
                break;
            default:
                stage1.setTextColor(getResources().getColor(R.color.black_333333));
                stage2.setTextColor(getResources().getColor(R.color.black_333333));
                stage3.setTextColor(getResources().getColor(R.color.black_333333));
        }

        stage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                tvStages.setText(stageList.get(0).getDescribe());
            }
        });
        stage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                tvStages.setText(stageList.get(1).getDescribe());
            }
        });
        stage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                tvStages.setText(stageList.get(2).getDescribe());
            }
        });

        bottomDialog = new BottomDialog(this,view);
        bottomDialog.show();

    }

    private int getStage(String str){
        for (ConfigBean.Config config:stageList){
            if(config.getDescribe().equals(str)){
                return config.getId();
            }
        }
        return 0;
    }

}
