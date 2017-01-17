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
  private long interval = DEFAULT_INTERVAL;

  /**
   * set auto scroll time in milliseconds, default is {@link #DEFAULT_INTERVAL}
   *
   * @param interval the interval to set
   * @return this
   */
  public BannerConfig interval(int interval) {
    this.interval = interval;
    return this;
  }

  @IntDef({ LEFT, RIGHT }) @Retention(RetentionPolicy.SOURCE) public @interface Direction {
  }

  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  /**
   * auto scroll direction, default is {@link #RIGHT}
   */
  private int direction = RIGHT;

  /**
   * set auto scroll direction
   *
   * @param direction {@link #LEFT} or {@link #RIGHT}, default is {@link #RIGHT}
   * @return this
   */
  public BannerConfig direction(@Direction int direction) {
    this.direction = direction;
    return this;
  }

  /**
   * toggle the auto scroll direction
   *
   * @return this
   */
  public BannerConfig toggleDirection() {
    if (direction == LEFT) {
      direction(RIGHT);
    } else {
      direction(LEFT);
    }
    return this;
  }

  /**
   * whether stop auto scroll when touching, default is true
   */
  private boolean stopScrollWhenTouch = true;

  /**
   * whether stop auto scroll when touching, default is true
   *
   * @param stopScrollWhenTouch whether stop or not
   * @return this
   */
  public BannerConfig stopScrollWhenTouch(boolean stopScrollWhenTouch) {
    this.stopScrollWhenTouch = stopScrollWhenTouch;
    return this;
  }

  /**
   * scroll factor for auto scroll animation, default is 450
   */
  private int autoScrollFactor = 450;

  /**
   * set the factor by which the duration of sliding animation will change while auto scrolling
   */
  public BannerConfig autoScrollFactor(int autoScrollFactor) {
    this.autoScrollFactor = autoScrollFactor;
    return this;
  }

  /**
   * scroll factor for swipe scroll animation, default is 450
   **/
  private int swipeScrollFactor = 450;

  /**
   * set the factor by which the duration of sliding animation will change while swiping
   */
  public BannerConfig swipeScrollFactor(int swipeScrollFactor) {
    this.swipeScrollFactor = swipeScrollFactor;
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

  public int getAutoScrollFactor() {
    return autoScrollFactor;
  }

  public void setAutoScrollFactor(int pAutoScrollFactor) {
    autoScrollFactor = pAutoScrollFactor;
  }

  public int getDirection() {
    return direction;
  }

  public void setDirection(int pDirection) {
    direction = pDirection;
  }

  public long getInterval() {
    return interval;
  }

  public void setInterval(long pInterval) {
    interval = pInterval;
  }

  public FixedSpeedScroller getScroller() {
    return mScroller;
  }

  public void setScroller(FixedSpeedScroller pScroller) {
    mScroller = pScroller;
  }

  public int getSwipeScrollFactor() {
    return swipeScrollFactor;
  }

  public void setSwipeScrollFactor(int pSwipeScrollFactor) {
    swipeScrollFactor = pSwipeScrollFactor;
  }

  public boolean isStopScrollWhenTouch() {
    return stopScrollWhenTouch;
  }

  public void setStopScrollWhenTouch(boolean pStopScrollWhenTouch) {
    stopScrollWhenTouch = pStopScrollWhenTouch;
  }
}
