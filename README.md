[![Android Gems](http://www.android-gems.com/badge/BoBoMEe/AutoScrollLoopViewPager.svg?branch=master)](http://www.android-gems.com/lib/BoBoMEe/AutoScrollLoopViewPager)

# ScrollLoopViewPager

Android auto scroll viewpager or viewpager in viewpager

####1.Trinea/[AutoScrollViewPager](https://github.com/Trinea/android-auto-scroll-view-pager)

- ViewPager which can auto scroll, cycle.

- ViewPager which can be slided normal in parent ViewPager.

![android-auto-scroll-view-pager](http://farm3.staticflickr.com/2843/12805132475_e595664a81_o.gif)


####2.imbryk/[LoopingViewPager](https://github.com/imbryk/LoopingViewPager)

- The original adapter creates 4 items: [0,1,2,3]
- The modified adapter will have to create 6 items [0,1,2,3,4,5]
- with mapping realPosition=(position-1)%count
[0->3, 1->0, 2->1, 3->2, 4->3, 5->0]


## ScreenShot

![AutoScrollLoopViewPager](screenshot/shot.gif "AutoScrollLoopViewPager")

## Include
- `maven`

``` xml
<dependency>
  <groupId>com.bobomee.android</groupId>
  <artifactId>scrollloopviewpager</artifactId>
  <version>1.3</version>
  <type>aar</type>
</dependency>
```

- `gradle`

``` java
    compile 'com.bobomee.android:scrollloopviewpager:1.3'
```

## Usage

- include this library, use

``` xml
<com.bobomee.android.scrollloopviewpager.autoscrollviewpager.AutoScrollViewPager
        android:id="@+id/vp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

replace

``` xml
<android.support.v4.view.ViewPager
	android:id="@+id/vp"
	android:layout_width="match_parent"
	android:layout_height="wrap_content" />
```

- `startAutoScroll()` start auto scroll, delay time is `getInterval()`.
- `startAutoScroll(int)` start auto scroll delayed.
- `stopAutoScroll()` stop auto scroll.

See:
[MainActivity.java](https://github.com/BoBoMEe/AutoScrollLoopViewPager/blob/master/app/src/main/java/com/bobomee/android/autoscrollloopviewpager_master/MainActivity.java)


## Setting

- `setInterval(long)` set auto scroll time in milliseconds, default is `DEFAULT_INTERVAL`.
- `setDirection(int)` set auto scroll direction, default is `RIGHT`.
- `setScrollDurationFactor(double)` set the factor by which the duration of sliding animation will change.
- `setStopScrollWhenTouch(boolean)` set whether stop auto scroll when touching, default is true.
- You may need [JakeWharton/ViewPagerIndicator](https://github.com/JakeWharton/Android-ViewPagerIndicator) to implement indicator. 
- Also you can see [DrawableIndicator](https://github.com/BoBoMEe/DrawableIndicator)

## Thanks

*   [imbryk/LoopingViewPager](https://github.com/imbryk/LoopingViewPager)
*   [Trinea/android-auto-scroll-view-pager](https://github.com/Trinea/android-auto-scroll-view-pager)