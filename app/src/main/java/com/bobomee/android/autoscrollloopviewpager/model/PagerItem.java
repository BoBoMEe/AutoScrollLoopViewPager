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

package com.bobomee.android.autoscrollloopviewpager.model;

/**
 * Created on 2017/1/14.下午11:27.
 *
 * @author bobomee.
 */

public class PagerItem {

  public static final int BANNWE = 0;
  public static final int CARD = 1;

  private int type = BANNWE;
  private int position = 0;

  public static PagerItem createBanner(int _position) {
    PagerItem pagerItem = new PagerItem();
    pagerItem.position = _position;
    pagerItem.type = BANNWE;
    return pagerItem;
  }

  public static PagerItem createCard(int _position) {
    PagerItem pagerItem = new PagerItem();
    pagerItem.position = _position;
    pagerItem.type = CARD;
    return pagerItem;
  }

  public int getPosition() {
    return position;
  }

  public int getType() {
    return type;
  }
}
