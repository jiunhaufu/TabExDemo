package fu.alfie.com.tabexdemo.nofragment;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class ThreePage extends RelativeLayout {

    public ThreePage(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.page_three, null);
        addView(view);
        //Data
        List<Item> itemList = Data.getItemList();

        //RecyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_p);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,true));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        recyclerView.setAdapter(new RecyclerViewItemAdapter(getContext(),itemList));
    }


    //RecyclerView
    private class RecyclerViewItemAdapter extends RecyclerView.Adapter<RecyclerViewItemAdapter.RecyclerViewHolder>{

        private Context context;
        private List<Item> itemList;

        public RecyclerViewItemAdapter(Context context, List<Item> itemList) {
            this.context = context;
            this.itemList = itemList;
        }

        public class RecyclerViewHolder extends RecyclerView.ViewHolder{

            private final ImageView imageView2;
            private final TextView textView4;
            private final TextView textView5;

            public RecyclerViewHolder(View itemView) {
                super(itemView);
                imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
                textView4 = (TextView) itemView.findViewById(R.id.textView4);
                textView5 = (TextView) itemView.findViewById(R.id.textView5);
            }
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View itemView = layoutInflater.inflate(R.layout.item_recyclerview,parent,false);
            return new RecyclerViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            final Item item = itemList.get(position);
            holder.imageView2.setImageResource(item.getImage());
            holder.textView4.setText(item.getTitle());
            holder.textView5.setText(item.getSubtitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView imageView = new ImageView(context);
                    imageView.setImageResource(item.getImage());
                    Toast toast = new Toast(context);
                    toast.setView(imageView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
