package com.bobomee.android.scrollloopviewpager.autoscrollviewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class FixedSpeedScroller extends Scroller {
    private int mDuration = 250;

    public FixedSpeedScroller(Context context) {
        super(context);
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator, int scrollSpeed) {
        super(context, interpolator);
        mDuration *= scrollSpeed;
    }

    /**
     * Set the factor by which the duration will change
     */
    public void setScrollDurationFactor(float scrollFactor) {
        mDuration *= scrollFactor;
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}
