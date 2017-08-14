package fu.alfie.com.tabexdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import fu.alfie.com.tabexdemo.parentpage.EasyTabsActivity;
import fu.alfie.com.tabexdemo.parentpage.WithFragment2Activity;
import fu.alfie.com.tabexdemo.parentpage.WithFragmentActivity;
import fu.alfie.com.tabexdemo.parentpage.WithoutFragmentActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    }

    public void onButton1Click(View view) {
        startActivity(new Intent(this, WithoutFragmentActivity.class));
    }

    public void onButton2Click(View view) {
        startActivity(new Intent(this, WithFragmentActivity.class));
    }

    public void onButton3Click(View view) {
        startActivity(new Intent(this, EasyTabsActivity.class));
    }

    public void onButton4Click(View view) {
        startActivity(new Intent(this, WithFragment2Activity.class));
    }
}
