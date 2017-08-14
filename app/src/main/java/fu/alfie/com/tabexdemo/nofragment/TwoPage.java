package fu.alfie.com.tabexdemo.nofragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fu.alfie.com.tabexdemo.Data;
import fu.alfie.com.tabexdemo.Item;
import fu.alfie.com.tabexdemo.R;

/**
 * Created by Jiunhau.Fu on 2017/8/8.
 */

public class TwoPage extends RelativeLayout {
    public TwoPage(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.page_two, null);
        addView(view);

        //Data
        List<Item> itemList = Data.getItemList();
        //GridView
        GridView gridView = (GridView) view.findViewById(R.id.gridView_p);
        gridView.setAdapter(new GridViewItemAdapter(getContext(),itemList));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
    //GridView
    private class GridViewItemAdapter extends BaseAdapter {
        Context context;
        List<Item> itemList;

        public GridViewItemAdapter(Context context, List<Item> itemList) {
            this.context = context;
            this.itemList = itemList;
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int position) {
            return itemList.get(position);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View itemView, ViewGroup viewGroup) {
            if (itemView == null){
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                itemView = layoutInflater.inflate(R.layout.item_gridview,viewGroup,false);
            }
            Item item = itemList.get(i);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(item.getImage());
            TextView textView2 = (TextView) itemView.findViewById(R.id.textView2);
            textView2.setText(item.getTitle());
            TextView textView3 = (TextView) itemView.findViewById(R.id.textView3);
            textView3.setText(item.getSubtitle());
            return itemView;
        }
    }
}
