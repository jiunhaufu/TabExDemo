package fu.alfie.com.tabexdemo.parentpage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import fu.alfie.com.tabexdemo.R;
import fu.alfie.com.tabexdemo.fragment_main.OneFragment;
import fu.alfie.com.tabexdemo.fragment_main.ThreeFragment;
import fu.alfie.com.tabexdemo.fragment_main.TwoFragment;

public class WithFragment2Activity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    //標題,頁面,圖示
    private int[] tabIcons = {
            R.mipmap.ic_launcher_round,
            R.drawable.ic_bug_report,
            R.mipmap.ic_launcher
    };
    private Fragment[] mFragmentList = {
            new OneFragment(),new TwoFragment(),new ThreeFragment()
    };
    private String [] mFragmentTitleList = {
            "ListVIew","GridView","CardView"
    };
    //標題,頁面,圖示


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//回前頁
        setContentView(R.layout.activity_with_fragment2);
        //回前頁
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //回前頁

        setTabPager();
    }

    private void setTabPager() {
        viewPager = (ViewPager) findViewById(R.id.withFragmentViewpager2);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList[position];
            }

            @Override
            public int getCount() {
                return mFragmentList.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentTitleList[position];
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.withFragmentTabLayout2);
        tabLayout.setupWithViewPager(viewPager);
        for (int position = 0 ; position<tabIcons.length; position++){
            //寫法一 預設icon位置
//            tabLayout.getTabAt(position).setIcon(tabIcons[position]);
            //寫法二 自訂icon位置
            TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_form, null);
            tabOne.setText(mFragmentTitleList[position]);
            tabOne.setCompoundDrawablesRelativeWithIntrinsicBounds(tabIcons[position],0, 0, 0); //左上右下
            tabLayout.getTabAt(position).setCustomView(tabOne);
        }
    }
}
