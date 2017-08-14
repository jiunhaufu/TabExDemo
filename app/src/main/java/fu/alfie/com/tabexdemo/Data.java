package fu.alfie.com.tabexdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiunhau.Fu on 2017/8/9.
 */

public class Data {
    public static List<Item> getItemList() {
        List<Item> item = new ArrayList<>();
        item.add(new Item(R.mipmap.ic_launcher,"One","1"));
        item.add(new Item(R.drawable.ic_bug_report,"Two","2"));
        item.add(new Item(R.mipmap.ic_launcher,"Three","3"));
        item.add(new Item(R.drawable.ic_bug_report,"Four","4"));
        item.add(new Item(R.mipmap.ic_launcher,"Five","5"));
        item.add(new Item(R.drawable.ic_bug_report,"Six","6"));
        item.add(new Item(R.mipmap.ic_launcher,"Seven","7"));
        item.add(new Item(R.mipmap.ic_launcher,"One","1"));
        item.add(new Item(R.drawable.ic_bug_report,"Two","2"));
        item.add(new Item(R.mipmap.ic_launcher,"Three","3"));
        item.add(new Item(R.drawable.ic_bug_report,"Four","4"));
        item.add(new Item(R.mipmap.ic_launcher,"Five","5"));
        item.add(new Item(R.drawable.ic_bug_report,"Six","6"));
        item.add(new Item(R.mipmap.ic_launcher,"Seven","7"));
        return item;
    }
}
