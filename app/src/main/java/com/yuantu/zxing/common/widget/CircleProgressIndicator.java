package com.yuantu.zxing.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yuantu.zxing.R;
import com.yuantu.zxing.utils.DisplayUtils;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午10:26
 * -----------------------------------------
 * Description:
 */
public class CircleProgressIndicator extends View {

    private int mWidth;
    private int mHeight;
    private Paint picPaint;
    private Paint wordPaint;
    private int padding;
    private float sweepAngle;
    private int picColor = R.color.color_429FFF;
    private int currentIndex;
    private String title = "";

    public CircleProgressIndicator(Context context) {
        this(context, null);
    }

    public CircleProgressIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        picPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        picPaint.setStrokeWidth(DisplayUtils.dp2px(context, 4));
        picPaint.setStyle(Paint.Style.STROKE);

        wordPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        wordPaint.setStyle(Paint.Style.FILL);
        wordPaint.setTextAlign(Paint.Align.CENTER);

        padding = DisplayUtils.dp2px(context, 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBg(canvas);
        drawFront(canvas);
        drawIndex(canvas);
        drawTitle(canvas);

    }

    private void drawTitle(Canvas canvas) {
        wordPaint.setColor(getResources().getColor(R.color.black_666666));
        wordPaint.setTextSize(DisplayUtils.dp2px(getContext(), 12));
        canvas.drawText(title, mWidth / 2, mWidth + wordPaint.getTextSize() / 2 + DisplayUtils.dp2px(getContext(),2), wordPaint);
    }

    private void drawIndex(Canvas canvas) {
        wordPaint.setColor(getResources().getColor(R.color.black_333333));
        wordPaint.setTextSize(DisplayUtils.dp2px(getContext(), 17));
        canvas.drawText(currentIndex+"", mWidth / 2, mWidth/2 + wordPaint.getTextSize() / 2 - DisplayUtils.dp2px(getContext(),2), wordPaint);
    }

    private void drawFront(Canvas canvas) {
        picPaint.setColor(getResources().getColor(picColor));
        RectF rectF = new RectF(padding, padding, mWidth - padding, mWidth - padding);
        float startAngle = 135;
        sweepAngle = 150;
        canvas.drawArc(rectF, startAngle, sweepAngle, false, picPaint);
    }

    private void drawBg(Canvas canvas) {
        picPaint.setColor(getResources().getColor(R.color.color_F4F4F4));
        RectF rectF = new RectF(padding, padding, mWidth - padding, mWidth - padding);
        float startAngle = 135;
        float sweepAngle = 270;
        canvas.drawArc(rectF, startAngle, sweepAngle, false, picPaint);
    }

    public void setData(int max, int current,int color,String title) {
        this.currentIndex = current;
        sweepAngle = (float) (Math.PI * 270f/180 * (current*1.0f/max));
        this.picColor = color;
        this.title = title;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

    }
}
