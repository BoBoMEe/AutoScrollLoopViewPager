package com.bobomee.android.autoscrollloopviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.bobomee.android.autoscrollloopviewpager.fragment.SimpleFragment;

/**
 * Created on 2016/3/28.下午2:58.
 * @author bobomee.
 */
public class FragmentStateAdapter extends FragmentPagerAdapter {

    public FragmentStateAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return SimpleFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 5;
    }

}
