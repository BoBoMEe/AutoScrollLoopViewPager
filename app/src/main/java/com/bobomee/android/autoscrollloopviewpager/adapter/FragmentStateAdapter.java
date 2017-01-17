package com.bobomee.android.autoscrollloopviewpager.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bobomee.android.autoscrollloopviewpager.R;
import java.util.Random;

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

    public static class SimpleFragment extends Fragment {

        public static final String POSITION = "POSITION";
        private int position = 0;

        public static SimpleFragment newInstance(int pPosition) {
            SimpleFragment fragment = new SimpleFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(POSITION, pPosition);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            position = getArguments().getInt(POSITION);
        }

        @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.item, container, false);
            TextView textView = (TextView) view.findViewById(R.id.tv);

            Random random = new Random();
            view.setBackgroundColor(0xff00ff00 | random.nextInt(0x00ff00ff));
            textView.setText(String.valueOf(position));

            return view;
        }
    }
}
