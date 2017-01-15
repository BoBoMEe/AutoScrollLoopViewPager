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

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bobomee.android.autoscrollloopviewpager.R;
import com.bobomee.android.autoscrollloopviewpager.adapter.BasePagerAdapter;
import com.bobomee.android.drawableindicator.widget.BaseIndicator;
import com.bobomee.android.scrollloopviewpager.autoscrollviewpager.AutoScrollViewPager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created on 2017/1/14.下午9:46.
 *
 * @author bobomee.
 */

public class BannerView extends RelativeLayout {

  private AutoScrollViewPager mAutoScrollViewPager;
  private BaseIndicator mBaseIndicator;

  private List<Object> mObjects;

  public BannerView(Context context) {
    super(context);
    init();
  }

  public BannerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public BannerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    LayoutInflater layoutInflater = LayoutInflater.from(getContext());
    layoutInflater.inflate(R.layout.banner_view_layout, this, true);
  }

  @Override protected void onFinishInflate() {
    if (!isInEditMode()) {
      mAutoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.picslooper_in_vp);
      mBaseIndicator = (BaseIndicator) findViewById(R.id.pageIndexor_in_vp);

      mAutoScrollViewPager.setFocusable(true);
    }
    super.onFinishInflate();
  }

  public void prepareData(List<Object> datas) {
    mObjects = new ArrayList<>();
    if (null != datas && !datas.isEmpty()) {
      mObjects.addAll(datas);
    }
  }

  public void prepareUI() {

    mAutoScrollViewPager.setAdapter(new InnerAdapter(getContext(), mObjects));
    mAutoScrollViewPager.setDirection(AutoScrollViewPager.RIGHT);

    mBaseIndicator.setViewPager(mAutoScrollViewPager);
  }

  public void scroll() {

    mAutoScrollViewPager.setInterval(3 * 1000);
    mAutoScrollViewPager.startAutoScroll();
  }

  class InnerAdapter extends BasePagerAdapter {

    public InnerAdapter(Context _context, List<Object> _objects) {
      super(_context, _objects);
    }

    @Override public Object instantiateItem(ViewGroup container, int position) {
      //position = (getCount() + position % getCount()) % getCount();
      //Object object = objects.get(position);
      ImageView imageView = new ImageView(getContext());
      imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

      Random random = new Random();
      imageView.setBackgroundColor(0xff00ff00 | random.nextInt(0x00ff00ff));

      ViewGroup.LayoutParams layoutParams =
          new ViewGroup.LayoutParams(getMeasuredWidth(), getMeasuredHeight());
      imageView.setLayoutParams(layoutParams);
      container.addView(imageView);
      return imageView;
    }
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
  }

  @Override public boolean dispatchTouchEvent(MotionEvent ev) {
    return super.dispatchTouchEvent(ev);
  }
}
