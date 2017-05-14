/*
 * Copyright (C) 2017.  BoBoMEe(wbwjx115@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.bobomee.android.scrollloopviewpager.autoscrollviewpager;

import android.content.Context;
import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created on 2017/1/17.上午10:27.
 *
 * @author bobomee.
 */

public class BannerConfig {

  public BannerConfig(Context context) {
    mScroller = new FixedSpeedScroller(context);
  }

  private static final int DEFAULT_INTERVAL = 1500;
  /**
   * auto scroll time in milliseconds, default is {@link #DEFAULT_INTERVAL}
   */
  private long mInterval = DEFAULT_INTERVAL;

  /**
   * set auto scroll time in milliseconds, default is {@link #DEFAULT_INTERVAL}
   *
   * @param interval the mInterval to set
   * @return this
   */
  public BannerConfig interval(int interval) {
    this.mInterval = interval;
    return this;
  }

  @IntDef({ LEFT, RIGHT }) @Retention(RetentionPolicy.SOURCE) public @interface Direction {
  }

  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  /**
   * auto scroll mDirection, default is {@link #RIGHT}
   */
  private int mDirection = RIGHT;

  /**
   * set auto scroll mDirection
   *
   * @param direction {@link #LEFT} or {@link #RIGHT}, default is {@link #RIGHT}
   * @return this
   */
  public BannerConfig direction(@Direction int direction) {
    this.mDirection = direction;
    return this;
  }

  /**
   * toggle the auto scroll mDirection
   *
   * @return this
   */
  public void toggleDirection() {
    if (mDirection == LEFT) {
      direction(RIGHT);
    } else {
      direction(LEFT);
    }
  }

  /**
   * whether stop auto scroll when touching, default is true
   */
  private boolean mStopScrollWhenTouch = true;

  /**
   * whether stop auto scroll when touching, default is true
   *
   * @param stopScrollWhenTouch whether stop or not
   * @return this
   */
  public BannerConfig stopScrollWhenTouch(boolean stopScrollWhenTouch) {
    this.mStopScrollWhenTouch = stopScrollWhenTouch;
    return this;
  }

  /**
   * scroll factor for auto scroll animation, default is 1.0
   */
  private float mAutoScrollFactor = 1.0f;

  /**
   * set the factor by which the duration of sliding animation will change while auto scrolling
   */
  public BannerConfig autoScrollFactor(float autoScrollFactor) {
    this.mAutoScrollFactor = autoScrollFactor;
    return this;
  }

  /**
   * scroll factor for swipe scroll animation, default is 1.0
   **/
  private float mSwipeScrollFactor = 1.0f;

  /**
   * set the factor by which the duration of sliding animation will change while swiping
   */
  public BannerConfig swipeScrollFactor(float swipeScrollFactor) {
    this.mSwipeScrollFactor = swipeScrollFactor;
    return this;
  }

  /**
   * fixed the sliding speed of viewpager
   */
  private FixedSpeedScroller mScroller;

  public BannerConfig scroller(FixedSpeedScroller pScroller) {
    this.mScroller = pScroller;
    return this;
  }

  public static BannerConfig sConfig(Context pContext) {
    return new BannerConfig(pContext);
  }

  public float getmAutoScrollFactor() {
    return mAutoScrollFactor;
  }

  public int getmDirection() {
    return mDirection;
  }

  public long getmInterval() {
    return mInterval;
  }

  public FixedSpeedScroller getScroller() {
    return mScroller;
  }

  public float getmSwipeScrollFactor() {
    return mSwipeScrollFactor;
  }

  public boolean ismStopScrollWhenTouch() {
    return mStopScrollWhenTouch;
  }
}
