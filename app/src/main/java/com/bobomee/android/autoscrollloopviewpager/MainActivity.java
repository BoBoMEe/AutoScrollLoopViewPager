package com.bobomee.android.autoscrollloopviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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

}
