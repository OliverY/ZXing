package com.yuantu.zxing.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yuantu.zxing.R;
import com.yuantu.zxing.utils.DisplayUtils;

/**
 * Author:  Yxj
 * Time:    2019/5/27 上午11:06
 * -----------------------------------------
 * Description:
 */
public class LinearProgressIndicator extends View {

    private Paint picPaint;
    private Paint wordPaint;
    private int frontColor = R.color.color_FBDA59;
    private int mWidth;
    private int mHeight;
    private int padding;
    private int index;
    private int frontRight = 10;

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }

    public LinearProgressIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearProgressIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        picPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        picPaint.setStrokeWidth(DisplayUtils.dp2px(context, 24));
        picPaint.setStrokeCap(Paint.Cap.ROUND);
        picPaint.setStyle(Paint.Style.STROKE);

        wordPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        wordPaint.setStyle(Paint.Style.FILL);
        wordPaint.setTextAlign(Paint.Align.CENTER);
        wordPaint.setTextSize(DisplayUtils.dp2px(context, 13));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBg(canvas);
        drawFront(canvas);
        drawIndex(canvas);

    }

    public void setIndex(int index) {
        this.index = index;

        if (index < 10) {
            frontRight = (int) (10 * 1.0f / 100 * (mWidth - 2 * padding) + padding);
        } else {
            frontRight = (int) (index * 1.0f / 100 * (mWidth - 2 * padding) + padding);
        }

        if (index >= 90) {
            frontColor = R.color.color_40CE94;
        } else {
            frontColor = R.color.color_FBDA59;
        }

        invalidate();
    }

    private void drawBg(Canvas canvas) {
        picPaint.setColor(getResources().getColor(R.color.color_F4F4F4));
        canvas.drawLine(padding, mHeight / 2, mWidth - padding, mHeight / 2, picPaint);
    }

    private void drawFront(Canvas canvas) {
        picPaint.setColor(getResources().getColor(frontColor));
        canvas.drawLine(padding, mHeight / 2, frontRight, mHeight / 2, picPaint);
    }

    private void drawIndex(Canvas canvas) {
        wordPaint.setColor(getResources().getColor(R.color.white));
        canvas.drawText(index + "%", (frontRight - padding)/2+padding, mHeight / 2 + wordPaint.getTextSize() / 2 - DisplayUtils.dp2px(getContext(), 2), wordPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(widthMeasureSpec, DisplayUtils.dp2px(getContext(), 24));
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        padding = mHeight / 2;
    }
}
