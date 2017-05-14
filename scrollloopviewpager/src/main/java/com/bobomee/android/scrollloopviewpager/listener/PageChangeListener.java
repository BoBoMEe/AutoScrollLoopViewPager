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

package com.bobomee.android.scrollloopviewpager.listener;

import android.support.v4.view.ViewPager;
import java.util.List;

/**
 * Created on 2017/1/17.下午9:52.
 *
 * @author bobomee.
 */

public class PageChangeListener extends ListenerImpl<ViewPager.SimpleOnPageChangeListener> {
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    notifyOnPageScrolled(position, positionOffset, positionOffsetPixels);
  }

  public void onPageSelected(int position) {
    notifyOnPageSelected(position);
  }

  public void onPageScrollStateChanged(int state) {
    notifyOnPageScrollStateChanged(state);
  }

  private void notifyOnPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    List<ViewPager.SimpleOnPageChangeListener> simpleOnPageChangeListeners = from();
    if (null != simpleOnPageChangeListeners && !simpleOnPageChangeListeners.isEmpty()) {
      for (ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener : simpleOnPageChangeListeners) {
        if (null != simpleOnPageChangeListener) {
          simpleOnPageChangeListener.onPageScrolled(position, positionOffset,
              positionOffsetPixels);
        }
      }
    }
  }

  private void notifyOnPageSelected(int position) {
    List<ViewPager.SimpleOnPageChangeListener> simpleOnPageChangeListeners = from();
    if (null != simpleOnPageChangeListeners && !simpleOnPageChangeListeners.isEmpty()) {
      for (ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener : simpleOnPageChangeListeners) {
        if (null != simpleOnPageChangeListener) {
          simpleOnPageChangeListener.onPageSelected(position);
        }
      }
    }
  }

  private void notifyOnPageScrollStateChanged(int state) {
    List<ViewPager.SimpleOnPageChangeListener> simpleOnPageChangeListeners = from();
    if (null != simpleOnPageChangeListeners && !simpleOnPageChangeListeners.isEmpty()) {
      for (ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener : simpleOnPageChangeListeners) {
        if (null != simpleOnPageChangeListener) {
          simpleOnPageChangeListener.onPageScrollStateChanged(state);
        }
      }
    }
  }
}
