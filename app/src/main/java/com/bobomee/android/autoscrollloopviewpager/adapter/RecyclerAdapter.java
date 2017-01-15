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

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.bobomee.android.autoscrollloopviewpager.R;
import com.bobomee.android.autoscrollloopviewpager.model.PagerItem;
import com.bobomee.android.autoscrollloopviewpager.view.BannerView;
import com.bobomee.android.common.adapter.CommonRcvAdapter;
import com.bobomee.android.common.adapter.interfaces.AdapterItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created on 2017/1/14.下午11:12.
 *
 * @author bobomee.
 */

public class RecyclerAdapter extends CommonRcvAdapter<PagerItem> {
  public RecyclerAdapter() {
    super();
  }

  @NonNull @Override public AdapterItem<PagerItem> createItem(int type) {

    AdapterItemAdapter<PagerItem> adapterItemAdapter;
    switch (type) {
      case PagerItem.BANNWE:
        adapterItemAdapter = new BannerItem();
        break;
      case PagerItem.CARD:
        adapterItemAdapter = new CardItem();
        break;
      default:
        adapterItemAdapter = new SpaceItem();
        break;
    }
    return adapterItemAdapter;
  }

  @Override public int getItemType(PagerItem _o) {
    return _o.getType();
  }

  abstract class AdapterItemAdapter<T> implements AdapterItem<T> {

    @Override public void bindViews(View root) {
    }

    @Override public void setViews(T _t) {

    }

    @Override public void handleData(T _t, int position) {

    }
  }

  private class SpaceItem extends AdapterItemAdapter<PagerItem> {

    @Override public int getLayoutResId() {
      return R.layout.item_space_in_vp;
    }
  }

  private class BannerItem extends AdapterItemAdapter<PagerItem> {

    private BannerView mBannerView;

    @Override public int getLayoutResId() {
      return R.layout.item_banner_in_vp;
    }

    @Override public void bindViews(View root) {
      super.bindViews(root);
      mBannerView = (BannerView) root.findViewById(R.id.banner);
    }

    @Override public void handleData(PagerItem _o, int position) {
      super.handleData(_o, position);
      List<Object> list = new ArrayList<>(Arrays.asList(new Object[] {
          0, 1, 2, 3
      }));
      mBannerView.prepareData(list);
      mBannerView.prepareUI();
      mBannerView.scroll();
    }
  }

  private class CardItem extends AdapterItemAdapter<PagerItem> {

    private TextView mTextView;

    @Override public int getLayoutResId() {
      return R.layout.item_card_in_vp;
    }

    @Override public void bindViews(View root) {
      super.bindViews(root);
      mTextView = (TextView) root.findViewById(R.id.tv_in_card);
    }

    @Override public void handleData(PagerItem _o, int position) {
      super.handleData(_o, position);
      Random random = new Random();
      mTextView.setBackgroundColor(0xff00ff00 | random.nextInt(0x00ff00ff));
      mTextView.setText(String.valueOf(_o.getPosition()));
    }
  }
}
