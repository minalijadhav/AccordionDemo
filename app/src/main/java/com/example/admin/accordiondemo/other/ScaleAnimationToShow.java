package com.example.admin.accordiondemo.other;

import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

/**
 * Created by Admin on 26/02/2018.
 */

public class ScaleAnimationToShow extends ScaleAnimation
{
    private View view;
    private LinearLayout.LayoutParams layoutParams;
    private int marginBottomFromY, marginBottomToY;
    private boolean vanishAfter = false;
    public static View openLayout;

    public ScaleAnimationToShow(float fromX, float toX, float fromY, float toY, int duration, View view, boolean vanishAfter)
    {
        super(fromX, toX, fromY, toY);

        openLayout = view;
        setDuration(duration);

        this.view = view;
        layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        this.vanishAfter = vanishAfter;

        view.setVisibility(View.VISIBLE);

        int height = this.view.getHeight();

        marginBottomFromY = 0;
        marginBottomToY = height;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation)
    {
        super.applyTransformation(interpolatedTime, transformation);

        if(interpolatedTime < 1.0f)
        {
            int newMarginBottom = (int) ((marginBottomToY - marginBottomFromY) * interpolatedTime) - marginBottomToY + 20;
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, newMarginBottom);
            view.getParent().requestLayout();
        }
    }
}
