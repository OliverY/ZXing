package com.yuantu.zxing.ui.latest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yuantu.zxing.Constants;
import com.yuantu.zxing.R;
import com.yuantu.zxing.adapter.CheckListAdapter;
import com.yuantu.zxing.bean.SchedulerBean;
import com.yuantu.zxing.net.ApiFactory;
import com.yuantu.zxing.utils.ToastUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午10:19
 * -----------------------------------------
 * Description:
 */
public class CheckFragment extends Fragment {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private CheckListAdapter adapter;

    private int planStatus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check,container,false);

        planStatus = getArguments().getInt(Constants.ActivityExtra.PLAN_STATUS);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        refreshLayout = view.findViewById(R.id.refresh_layout);
        recyclerView = view.findViewById(R.id.recycler_view);

        adapter = new CheckListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),));
        recyclerView.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData();
            }
        });
        initData();
    }

    private void initData() {
        refreshLayout.setRefreshing(true);

        requestData();
    }

    private void requestData() {
        ApiFactory.getProducePlanProcess(planStatus)
                .subscribe(new Observer<List<SchedulerBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<SchedulerBean> schedulerBeans) {
                        refreshLayout.setRefreshing(false);
                        adapter.setNewData(schedulerBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        refreshLayout.setRefreshing(false);
                        ToastUtils.showShort(getContext(),"获取数据失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
