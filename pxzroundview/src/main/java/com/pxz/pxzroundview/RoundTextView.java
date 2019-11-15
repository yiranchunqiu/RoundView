package com.pxz.pxzroundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

/**
 * 类说明：自定义圆角TextView
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/10/23 9:07
 */
public class RoundTextView extends AppCompatTextView {
    /**
     * 默认样式
     */
    private GradientDrawable noGd = new GradientDrawable();
    /**
     * 点击样式
     */
    private GradientDrawable yesGd = new GradientDrawable();
    /**
     * 不可点击状态
     */
    private GradientDrawable enabledGd = new GradientDrawable();
    /**
     * 选择
     */
    private StateListDrawable selector = new StateListDrawable();
    /**
     * 是否有按压状态
     */
    private boolean isSelector = false;
    /**
     * 左上圆角
     */
    private int leftTopRadius = 0;
    /**
     * 左下圆角
     */
    private int leftBottomRadius = 0;
    /**
     * 右上圆角
     */
    private int rightTopRadius = 0;
    /**
     * 右下圆角
     */
    private int rightBottomRadius = 0;
    /**
     * 圆角
     */
    private int radius = 0;
    /**
     * 默认背景颜色
     */
    private int noColor = R.color.white;
    /**
     * 默认边框颜色
     */
    private int noStrokeColor = R.color.transparent;
    /**
     * 点击背景颜色
     */
    private int yesColor = R.color.white;
    /**
     * 点击边框颜色
     */
    private int yesStrokeColor = R.color.transparent;
    /**
     * 不可点击背景颜色
     */
    private int enabledColor = R.color.white;
    /**
     * 不可点击边框颜色
     */
    private int enabledStrokeColor = R.color.transparent;
    /**
     * 边框宽度
     */
    private int lineStrokeWidth = 0;

    public RoundTextView(Context context) {
        this(context, null);
    }

    public RoundTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initStyles(context, attrs, defStyleAttr);
        initType(context);
    }

    private void initStyles(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundTextView, defStyleAttr, 0);
        isSelector = typedArray.getBoolean(R.styleable.RoundTextView_is_selector, false);
        leftTopRadius = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_left_top_radius, 0);
        leftBottomRadius = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_left_bottom_radius, 0);
        rightTopRadius = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_right_top_radius, 0);
        rightBottomRadius = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_right_bottom_radius, 0);
        radius = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_radius, 0);
        noColor = typedArray.getResourceId(R.styleable.RoundTextView_no_color, R.color.white);
        noStrokeColor = typedArray.getResourceId(R.styleable.RoundTextView_no_stroke_color, R.color.transparent);
        yesColor = typedArray.getResourceId(R.styleable.RoundTextView_yes_color, R.color.white);
        yesStrokeColor = typedArray.getResourceId(R.styleable.RoundTextView_yes_stroke_color, R.color.transparent);
        enabledColor = typedArray.getResourceId(R.styleable.RoundTextView_enabled_color, R.color.white);
        enabledStrokeColor = typedArray.getResourceId(R.styleable.RoundTextView_enabled_stroke_color, R.color.transparent);
        lineStrokeWidth = typedArray.getDimensionPixelSize(R.styleable.RoundTextView_stroke_line_width, 0);
        typedArray.recycle();
    }

    private void initType(Context context) {
        if (isSelector) {
            //有按压模式
            setYesState(context);
            setNoState(context);
            setEnabledState(context);
            setClickable(true);
            //设置按压状态下的drawable
            selector.addState(new int[]{android.R.attr.state_pressed}, yesGd);
            //设置不可点击状态下的drawable
            selector.addState(new int[]{-android.R.attr.state_enabled}, enabledGd);
            //设置正常状态下的drawable
            selector.addState(new int[]{}, noGd);
            //设置selector
            setBackgroundDrawable(selector);
        } else {
            //没有按压模式
            setNoState(context);
            setEnabledState(context);
            //设置不可点击状态下的drawable
            selector.addState(new int[]{-android.R.attr.state_enabled}, enabledGd);
            //设置正常状态下的drawable
            selector.addState(new int[]{}, noGd);
            //设置selector
            setBackgroundDrawable(selector);
        }
    }

    /**
     * 设置按压模式样式
     *
     * @param context 上下文
     */
    private void setYesState(Context context) {
        //设置填充色
        yesGd.setColor(ContextCompat.getColor(context, yesColor));
        //设置描边边距和颜色
        yesGd.setStroke(lineStrokeWidth, ContextCompat.getColor(context, yesStrokeColor));
        //设置圆角
        setRadius(yesGd, leftTopRadius, leftBottomRadius, rightBottomRadius, rightTopRadius);
    }

    /**
     * 设置默认模式样式
     *
     * @param context 上下文
     */
    private void setNoState(Context context) {
        //设置填充色
        noGd.setColor(ContextCompat.getColor(context, noColor));
        //设置描边边距和颜色
        noGd.setStroke(lineStrokeWidth, ContextCompat.getColor(context, noStrokeColor));
        //设置圆角
        setRadius(noGd, leftTopRadius, leftBottomRadius, rightBottomRadius, rightTopRadius);
    }

    /**
     * 设置不可点击样式
     *
     * @param context 上下文
     */
    private void setEnabledState(Context context) {
        //设置填充色
        enabledGd.setColor(ContextCompat.getColor(context, enabledColor));
        //设置描边边距和颜色
        enabledGd.setStroke(lineStrokeWidth, ContextCompat.getColor(context, enabledStrokeColor));
        //设置圆角
        setRadius(enabledGd, leftTopRadius, leftBottomRadius, rightBottomRadius, rightTopRadius);
    }

    /**
     * 设置角度
     *
     * @param drawable          drawable
     * @param leftTopRadius     左上角角度
     * @param leftBottomRadius  左下角角度
     * @param rightBottomRadius 右下角角度
     * @param rightTopRadius    右上角角度
     */
    private void setRadius(GradientDrawable drawable, int leftTopRadius, int leftBottomRadius, int rightBottomRadius, int rightTopRadius) {
        if (radius != 0) {
            drawable.setCornerRadius(radius);
        } else if (leftTopRadius != 0 || leftBottomRadius != 0 || rightTopRadius != 0 || rightBottomRadius != 0) {
            drawable.setCornerRadii(new float[]{leftTopRadius, leftTopRadius, rightTopRadius, rightTopRadius,
                    rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius});
        }
    }
}