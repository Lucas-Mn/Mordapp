package frise.project.mordapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragWpnDetail extends Fragment {

    public static final String TAG_WEAPON = "weapon";

    private Item item;

    private TextView lblName;

    public FragWpnDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_wpn_detail, container, false);

        Bundle bundle = getArguments();
        item = (Item) bundle.getSerializable(TAG_WEAPON);

        lblName = view.findViewById(R.id.frag_wpn_detail_name);

        lblName.setText(item.getName());

        return view;
    }

}
