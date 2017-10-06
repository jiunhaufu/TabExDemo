package fu.alfie.com.tabexdemo.fragment_main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fu.alfie.com.tabexdemo.Data;
import fu.alfie.com.tabexdemo.Item;
import fu.alfie.com.tabexdemo.R;
import fu.alfie.com.tabexdemo.fragment_child.ChildOneFragment;

public class OneFragment extends Fragment{
    private View view;
    private ChildOneFragment childOneFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //Data
        List<Item> itemList = Data.getItemList();
        //ListView
        ListView listView = (ListView) view.findViewById(R.id.listView_f);
        listView.setAdapter(new ListViewItemAdapter(getContext(),itemList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                //點按ListItem時再開啟一層fragment
                childOneFragment = new ChildOneFragment();
                Bundle bundle = new Bundle();
                bundle.putString("position", String.valueOf(position));
                childOneFragment.setArguments(bundle); //傳入Fragment的參數
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction
                        .addToBackStack(null)
                        .replace(R.id.oneFragment, childOneFragment)
                        .commit();
            }
        });
    }

    //ListView
    private class ListViewItemAdapter extends BaseAdapter{

        Context context;
        List<Item> itemList;
        public ListViewItemAdapter(Context context, List<Item> itemList) {
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
                itemView = layoutInflater.inflate(R.layout.item_listview,viewGroup,false);
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
