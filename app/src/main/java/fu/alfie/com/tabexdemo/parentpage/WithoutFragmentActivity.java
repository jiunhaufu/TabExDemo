package fu.alfie.com.tabexdemo.parentpage;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fu.alfie.com.tabexdemo.R;
import fu.alfie.com.tabexdemo.nofragment.OnePage;
import fu.alfie.com.tabexdemo.nofragment.ThreePage;
import fu.alfie.com.tabexdemo.nofragment.TwoPage;

public class WithoutFragmentActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArrayList pageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_fragment);
        setPage();
    }

    private void setPage() {
        mViewPager = (ViewPager) findViewById(R.id.withoutFragmentViewPager);
        mTabLayout = (TabLayout) findViewById(R.id.withoutFragmentTabLayout);

        pageList = new ArrayList<>();
        pageList.add(new OnePage(this));
        pageList.add(new TwoPage(this));
        pageList.add(new ThreePage(this));

        mTabLayout.addTab(mTabLayout.newTab().setText("ListView").setIcon(R.mipmap.ic_launcher));
        mTabLayout.addTab(mTabLayout.newTab().setText("GridView").setIcon(R.mipmap.ic_launcher));
        mTabLayout.addTab(mTabLayout.newTab().setText("RecyclerView").setIcon(R.mipmap.ic_launcher));

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return pageList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return o == view;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView((View) pageList.get(position));
                return pageList.get(position);
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mViewPager.setCurrentItem(1); //預設頁面
    }
}
