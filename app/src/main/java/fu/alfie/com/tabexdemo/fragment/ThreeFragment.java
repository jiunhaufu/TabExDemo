package fu.alfie.com.tabexdemo.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fu.alfie.com.tabexdemo.Data;
import fu.alfie.com.tabexdemo.Item;
import fu.alfie.com.tabexdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_three, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //Data
        List<Item> itemList = Data.getItemList();

        //RecyclerCardView
        RecyclerView recyclerCardView = (RecyclerView) view.findViewById(R.id.recyclerCardView_f);
        recyclerCardView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        recyclerCardView.setAdapter(new RecyclerCardViewItemAdapter(getContext(),itemList));
    }


    //CardView
    private class RecyclerCardViewItemAdapter extends RecyclerView.Adapter<RecyclerCardViewItemAdapter.RecyclerCardViewHolder>{

        private Context context;
        private List<Item> itemList;

        public RecyclerCardViewItemAdapter(Context context, List<Item> itemList) {
            this.context = context;
            this.itemList = itemList;
        }

        public class RecyclerCardViewHolder extends RecyclerView.ViewHolder{

            private final ImageView imageView2;
            private final TextView textView4;
            private final TextView textView5;

            public RecyclerCardViewHolder(View itemView) {
                super(itemView);
                imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
                textView4 = (TextView) itemView.findViewById(R.id.textView4);
                textView5 = (TextView) itemView.findViewById(R.id.textView5);
            }
        }

        @Override
        public RecyclerCardViewItemAdapter.RecyclerCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View itemView = layoutInflater.inflate(R.layout.item_cardview,parent,false);
            return new RecyclerCardViewItemAdapter.RecyclerCardViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RecyclerCardViewItemAdapter.RecyclerCardViewHolder holder, int position) {
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
