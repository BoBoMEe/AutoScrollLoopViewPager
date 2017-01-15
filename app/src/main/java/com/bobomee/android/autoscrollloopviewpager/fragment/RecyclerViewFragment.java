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

package com.bobomee.android.autoscrollloopviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bobomee.android.autoscrollloopviewpager.R;
import com.bobomee.android.autoscrollloopviewpager.adapter.RecyclerAdapter;
import com.bobomee.android.autoscrollloopviewpager.model.PagerItem;
import com.bobomee.android.autoscrollloopviewpager.view.ViewParser;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16/3/29.下午2:58.
 *
 * @author bobomee.
 */
public class RecyclerViewFragment extends Fragment {

  private RecyclerAdapter mRecyclerAdapter;
  private FragmentActivity mFragmentActivity;
  public static final String POSITION = "POSITION";
  private int position;

  public static RecyclerViewFragment newInstance(int position) {
    RecyclerViewFragment fragment = new RecyclerViewFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(POSITION, position);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mFragmentActivity = getActivity();
    position = getArguments().getInt(POSITION);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return ViewParser.parseView(inflater, R.layout.layout_recycler_in_vp, container);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(mFragmentActivity));

    mRecyclerAdapter = new RecyclerAdapter();
    recyclerView.setAdapter(mRecyclerAdapter);

    prepareData();
  }

  private void prepareData() {

    List<PagerItem> pagerItems = new ArrayList<>();

    for (int i = 0; i < 5; ++i) {
      PagerItem card = PagerItem.createCard(i);
      PagerItem banner = PagerItem.createBanner(position);
      pagerItems.add(card);
      pagerItems.add(banner);
    }

    mRecyclerAdapter.addData(pagerItems);
  }
}
