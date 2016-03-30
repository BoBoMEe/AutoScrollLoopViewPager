package com.bobomee.android.autoscrollloopviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by bobomee on 16/3/29.
 */
public class SimpleFragment extends Fragment {

    int i = 0;

    public static SimpleFragment newInstance(int i) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("p", i);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        i = getArguments().getInt("p");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv);

        Random random = new Random();
        view.setBackgroundColor(0xff00ff00 | random.nextInt(0x00ff00ff));
        textView.setText(i + "");

        return view;

    }
}
