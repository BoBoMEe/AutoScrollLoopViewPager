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

package com.bobomee.android.autoscrollloopviewpager.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bobomee.android.autoscrollloopviewpager.R;
import com.bobomee.android.autoscrollloopviewpager.view.ViewFindUtils;
import com.bobomee.android.autoscrollloopviewpager.view.ViewParser;
import com.bobomee.android.scrollloopviewpager.autoscrollviewpager.BannerConfig;
import com.bobomee.android.scrollloopviewpager.autoscrollviewpager.BannerController;

/**
 * Created on 2017/1/14.下午4:00.
 *
 * @author bobomee.
 */

public class TabViewPagerAdapter extends FragmentStatePagerAdapter {

  public TabViewPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public CharSequence getPageTitle(int position) {
    return "outPosition: " + String.valueOf(position);
  }

  @Override public int getCount() {
    return 2;
  }

  @Override public Fragment getItem(int position) {
    Fragment fragment;
    switch (position) {
      case 0:
        fragment = ViewPagerFragment.newInstance();
        break;
      case 1:
        fragment = ViewPagerFragment.newInstance();
        break;
      default:
        fragment = new Fragment();
        break;
    }
    return fragment;
  }

  public static class ViewPagerFragment extends Fragment {

    public static ViewPagerFragment newInstance() {
      Bundle args = new Bundle();
      ViewPagerFragment fragment = new ViewPagerFragment();
      fragment.setArguments(args);
      return fragment;
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
      return inflater.inflate(R.layout.layout_vp, container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      FragmentManager childFragmentManager = getChildFragmentManager();
      ViewParser.scrollRightVp(childFragmentManager, view, R.id.picslooper1, R.id.pageIndexor1);
      ViewParser.scroll3D(childFragmentManager, view, R.id.picslooper3, R.id.pageIndexor3,
          R.id.vp_container);
      ViewParser.scrollRightVp(childFragmentManager, view, R.id.banner);

      initViewPager(view);
      initViewPager1(view);
    }

    private void initViewPager1(View pView) {
      final ViewPager lViewPager = ViewFindUtils.find(pView, R.id.viewpager1);
      lViewPager.setAdapter(new FragmentStateAdapter(getChildFragmentManager()));

      final BannerConfig lBannerConfig = BannerConfig.sConfig(getContext())
          .autoScrollFactor(0.8f)
          .swipeScrollFactor(1.2f)
          .interval(800);

      final BannerController lBannerController = new BannerController(lBannerConfig);
      lBannerController.viewPager(lViewPager);

      lViewPager.setOnTouchListener(new View.OnTouchListener() {
        @Override public boolean onTouch(View v, MotionEvent event) {
          lBannerController.dispatchTouchEvent(event);
          return false;
        }
      });

      lViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        @Override public void onPageSelected(int position) {
          super.onPageSelected(position);
          if (lBannerController.isFirst() || lBannerController.isLast()) {
            lBannerConfig.toggleDirection();
          }
        }
      });

      lBannerController.startAutoScroll();
    }

    private void initViewPager(View pView) {
      ViewPager lViewPager = ViewFindUtils.find(pView, R.id.viewpager);
      lViewPager.setAdapter(new FragmentStateAdapter(getChildFragmentManager()));

      final BannerController lBannerController = new BannerController(getActivity());
      lBannerController.viewPager(lViewPager);

      lViewPager.setOnTouchListener(new View.OnTouchListener() {
        @Override public boolean onTouch(View v, MotionEvent event) {
          lBannerController.dispatchTouchEvent(event);
          return false;
        }
      });

      lViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        @Override public void onPageSelected(int position) {
          super.onPageSelected(position);
          if (lBannerController.isFirst() || lBannerController.isLast()) {
            BannerConfig lBannerConfig = lBannerController.getConfing();
            lBannerConfig.toggleDirection();
          }
        }
      });

      lBannerController.startAutoScroll();
    }
  }
}
