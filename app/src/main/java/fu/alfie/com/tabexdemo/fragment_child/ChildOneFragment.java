package fu.alfie.com.tabexdemo.fragment_child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fu.alfie.com.tabexdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildOneFragment extends Fragment {

    private View view;
    private String position;

    public ChildOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        position = getArguments().getString("position");

        view = inflater.inflate(R.layout.fragment_child_one, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        TextView textView = (TextView) view.findViewById(R.id.child_one_fragment_textview);
        textView.setText(position);

    }
}
