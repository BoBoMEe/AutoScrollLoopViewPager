package com.bobomee.android.autoscrollloopviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by bobomee on 2016/3/28.
 */
public class FragmentStateAdapter extends FragmentStatePagerAdapter {

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

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
