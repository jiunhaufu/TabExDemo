package fu.alfie.com.tabexdemo.parentpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fu.alfie.com.tabexdemo.R;
import fu.alfie.com.tabexdemo.fragment_main.OneFragment;
import fu.alfie.com.tabexdemo.fragment_main.ThreeFragment;
import fu.alfie.com.tabexdemo.fragment_main.TwoFragment;
import goldzweigapps.tabs.Builder.EasyTabsBuilder;
import goldzweigapps.tabs.Colors.EasyTabsColors;
import goldzweigapps.tabs.Interface.TabsListener;
import goldzweigapps.tabs.Items.TabItem;
import goldzweigapps.tabs.View.EasyTabs;
import goldzweigapps.tabs.transforms.EasyRotateUpTransformer;


/***********************************************************
 *******https://github.com/gilgoldzweig/EasyTabs************
 ***********************************************************
        build.gradle加上這個
        repositories {
        maven {url "https://jitpack.io" }
        }

        dependencies {
        compile 'com.github.gilgoldzweig:EasyTab:1.1.2'
        }
************************************************************/

public class EasyTabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_tabs);

        EasyTabs tabs = (EasyTabs) findViewById(R.id.easyTabs);
        EasyTabsBuilder.with(tabs)
                .addTabs(
                        new TabItem(new OneFragment(),"ListView"),
                        new TabItem(new TwoFragment(), "GridView"),
                        new TabItem(new ThreeFragment(),"CardView"))
                .setTabsBackgroundColor(EasyTabsColors.Cornsilk)
                .setIndicatorColor(EasyTabsColors.Aqua)
                .setTextColors(EasyTabsColors.Moccasin,EasyTabsColors.Gray)
                .hideAllTitles(false)
                .addIcons(
                        R.mipmap.ic_launcher,
                        R.drawable.ic_bug_report,
                        R.mipmap.ic_launcher_round)
                .setIconFading(false)
                .withListener(new TabsListener() {
                    @Override
                    public void onScreenPosition(int position) {
                        Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                    }
                })
                .addTransformation(true,new EasyRotateUpTransformer())
                .Build();

    }
}
