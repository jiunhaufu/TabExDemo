package fu.alfie.com.tabexdemo.parentpage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fu.alfie.com.tabexdemo.R;
import fu.alfie.com.tabexdemo.fragment.OneFragment;
import fu.alfie.com.tabexdemo.fragment.ThreeFragment;
import fu.alfie.com.tabexdemo.fragment.TwoFragment;

public class WithFragmentActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fragment);
        setFragment();
    }

    private void setFragment() {
        mViewPager = (ViewPager) findViewById(R.id.withFragmentViewpager);
        mTabLayout = (TabLayout) findViewById(R.id.withFragmentTabLayout);

        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return 3;
            }
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new OneFragment();
                    case 1:
                        return new TwoFragment();
                    case 2:
                        return new ThreeFragment();
                    default:  return null;
                }
            }
        });
        mTabLayout.addTab(mTabLayout.newTab().setText("ListView").setIcon(R.mipmap.ic_launcher));
        mTabLayout.addTab(mTabLayout.newTab().setText("GridView").setIcon(R.mipmap.ic_launcher));
        mTabLayout.addTab(mTabLayout.newTab().setText("CardView").setIcon(R.mipmap.ic_launcher));
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
    }


}
