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
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bobomee.android.autoscrollloopviewpager.R;
import com.bobomee.android.autoscrollloopviewpager.view.ViewParser;

/**
 * Created on 2017/1/15.上午11:04.
 *
 * @author bobomee.
 */

public class ViewPagerFragment extends Fragment {

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
    ViewParser.scrollLeftVp(childFragmentManager, view, R.id.picslooper2, R.id.pageIndexor2);
    ViewParser.scroll3D(childFragmentManager, view, R.id.picslooper3, R.id.pageIndexor3,
        R.id.vp_container);
  }
}
