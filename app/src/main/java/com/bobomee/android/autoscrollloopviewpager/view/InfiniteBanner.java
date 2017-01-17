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

package com.bobomee.android.autoscrollloopviewpager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bobomee.android.scrollloopviewpager.autoscrollviewpager.BannerScroll;
import com.bobomee.android.scrollloopviewpager.loopingviewpager.LoopViewPager;

/**
 * Created on 2017/1/17.下午2:56.
 *
 * @author bobomee.
 */

public class InfiniteBanner extends LoopViewPager {

  private BannerScroll mBannerScroll;

  public InfiniteBanner(Context context) {
    super(context);
    init();
  }

  public InfiniteBanner(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    mBannerScroll = new BannerScroll(getContext());
    mBannerScroll.viewPager(this);
    mBannerScroll.startAutoScroll();
  }

  @Override public boolean dispatchTouchEvent(MotionEvent ev) {
    mBannerScroll.dispatchTouchEvent(ev);
    return super.dispatchTouchEvent(ev);
  }
}
