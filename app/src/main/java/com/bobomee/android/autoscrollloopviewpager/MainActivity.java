package com.bobomee.android.autoscrollloopviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bobomee.android.autoscrollloopviewpager.adapter.FragmentStateAdapter;
import com.bobomee.android.autoscrollloopviewpager.transformer.RotateTransformer;
import com.bobomee.android.drawableindicator.widget.BaseIndicator;
import com.bobomee.android.scrollloopviewpager.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        right();
        left();
        vp3d();
    }

    private void vp3d() {
        PagerAdapter adapter;
        final AutoScrollViewPager viewPager = (AutoScrollViewPager) findViewById(R.id.picslooper3);
        viewPager.setAdapter(adapter = new FragmentStateAdapter(getSupportFragmentManager()));
        viewPager.setDirection(AutoScrollViewPager.LEFT);
        viewPager.setPageTransformer(true, new RotateTransformer());

        BaseIndicator pageIndex = (BaseIndicator) findViewById(R.id.pageIndexor3);
        pageIndex.setViewPager(viewPager);

        viewPager.startAutoScroll();

        //设置幕后item的缓存数目
        viewPager.setOffscreenPageLimit(adapter.getCount());

        //设置页与页之间的间距
        int margin = ((ViewGroup.MarginLayoutParams) viewPager.getLayoutParams()).leftMargin;
        viewPager.setPageMargin(-(px2dip(this, margin)) / 2);

        //将父类的touch事件分发至viewPgaer，否则只能滑动中间的一个view对象
        RelativeLayout vpContainer = (RelativeLayout) findViewById(R.id.vp_container);
        vpContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });

    }

    private void left() {
        AutoScrollViewPager viewPager = (AutoScrollViewPager) findViewById(R.id.picslooper2);
        viewPager.setFocusable(true);
        viewPager.setAdapter(new FragmentStateAdapter(getSupportFragmentManager()));
        viewPager.setDirection(AutoScrollViewPager.LEFT);

        BaseIndicator pageIndex = (BaseIndicator) findViewById(R.id.pageIndexor2);
        pageIndex.setViewPager(viewPager);

        viewPager.startAutoScroll();
    }

    private void right() {
        AutoScrollViewPager viewPager = (AutoScrollViewPager) findViewById(R.id.picslooper1);
        viewPager.setFocusable(true);
        viewPager.setAdapter(new FragmentStateAdapter(getSupportFragmentManager()));

        BaseIndicator pageIndex = (BaseIndicator) findViewById(R.id.pageIndexor1);
        pageIndex.setViewPager(viewPager);

        viewPager.startAutoScroll();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    int px2dip(Context context, int pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
