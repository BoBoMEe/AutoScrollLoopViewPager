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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.bobomee.android.autoscrollloopviewpager.fragment.RecyclerViewFragment;
import com.bobomee.android.autoscrollloopviewpager.fragment.ViewPagerFragment;

/**
 * Created on 2017/1/14.下午4:00.
 *
 * @author bobomee.
 */

public class TabViewPagerAdapter extends FragmentStateAdapter {
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
        fragment = RecyclerViewFragment.newInstance(position);
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
}
