# ScrollLoopViewPager

Android auto scroll loop viewpager


## ScreenShot

![AutoScrollLoopViewPager](screenshot/shot.gif "AutoScrollLoopViewPager")

## Import
- `maven`

```xml
<dependency>
  <groupId>com.bobomee.android</groupId>
  <artifactId>scrollloopviewpager</artifactId>
  <version>2.1</version>
  <type>aar</type>
</dependency>
```

- `gradle`

```groovy
compile 'com.bobomee.android:scrollloopviewpager:2.1'
```

## Usage


- Simple

```java
private void initViewPager(View view) {
      ViewPager viewPager = ViewFindUtils.find(view, R.id.viewpager);
      viewPager.setAdapter(new FragmentStateAdapter(getChildFragmentManager()));

      final BannerController bannerController = new BannerController(getActivity());
      bannerController.viewPager(viewPager);

      viewPager.setOnTouchListener(new View.OnTouchListener() {
        @Override public boolean onTouch(View v, MotionEvent event) {
          bannerController.dispatchTouchEvent(event);
          return false;
        }
      });

      bannerController.startAutoScroll();
}
```


-  [BannerConfig](https://github.com/BoBoMEe/AutoScrollLoopViewPager/blob/master/scrollloopviewpager/src/main/java/com/bobomee/android/scrollloopviewpager/autoscrollviewpager/BannerConfig.java)

```java
  final BannerConfig bannerConfig = BannerConfig.sConfig(getContext())
           .autoScrollFactor(0.8f)
           .swipeScrollFactor(1.2f)
           .interval(800);

  final BannerController bannerController = new BannerController(bannerConfig);
  bannerController.viewPager(viewPager);
```

- [BannerController](https://github.com/BoBoMEe/AutoScrollLoopViewPager/blob/master/scrollloopviewpager/src/main/java/com/bobomee/android/scrollloopviewpager/autoscrollviewpager/BannerController.java)

```java
 final BannerController lBannerController = new BannerScroll(lBannerConfig);//use custom config
 lBannerController.viewPager(lViewPager); // attach viewpager

      lViewPager.setOnTouchListener(new View.OnTouchListener() {
        @Override public boolean onTouch(View v, MotionEvent event) {
          lBannerController.dispatchTouchEvent(event);// dispatchTouchEvent,stop scroll when touch
          return false;
        }
      });
```

- Advance

```java
 viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        @Override public void onPageSelected(int position) {
          super.onPageSelected(position);
          if (bannerController.isFirst() || bannerController.isLast()) {
            bannerController.toggleDirection();
          }
        }
      });
```
## Extends

However, you can also customize Viewpager

```java
public class InfiniteBanner extends LoopViewPager {

  private BannerScroll mBannerScroll;

  public InfiniteBanner(Context context) {
    super(context);
    init();
  }

  public InfiniteBanner(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    mBannerScroll = new BannerScroll(getContext());
    mBannerScroll.viewPager(this);
    mBannerScroll.startAutoScroll();
  }

  @Override public boolean dispatchTouchEvent(MotionEvent ev) {
    mBannerScroll.dispatchTouchEvent(ev);
    return super.dispatchTouchEvent(ev);
  }

  @Override protected void onDetachedFromWindow() {
    mBannerScroll.onDetachedFromWindow();
    super.onDetachedFromWindow();
  }
}
```

```java
 ViewPager viewPager = ViewFindUtils.find(view, viewpager);
 FragmentStateAdapter fragmentStateAdapter = new FragmentStateAdapter(fragmentManager);
 viewPager.setAdapter(fragmentStateAdapter);
```

- see more: [FiniteBanner](https://github.com/BoBoMEe/AutoScrollLoopViewPager/blob/master/app/src/main/java/com/bobomee/android/autoscrollloopviewpager/view/FiniteBanner.java)

## Config Setting

- `interval(long)` set auto scroll time in milliseconds, default is `DEFAULT_INTERVAL`.
- `direction(int)` set auto scroll direction, default is `RIGHT`.
- `autoScrollFactor(double)` set the factor by which the duration of sliding animation will change.
- `stopScrollWhenTouch(boolean)` set whether stop auto scroll when touching, default is true.
- You may need [JakeWharton/ViewPagerIndicator](https://github.com/JakeWharton/Android-ViewPagerIndicator) to implement indicator. 
- Also you can see [DrawableIndicator](https://github.com/BoBoMEe/DrawableIndicator)

## Thanks

*   [imbryk/LoopingViewPager](https://github.com/imbryk/LoopingViewPager)
*   [Trinea/android-auto-scroll-view-pager](https://github.com/Trinea/android-auto-scroll-view-pager)
