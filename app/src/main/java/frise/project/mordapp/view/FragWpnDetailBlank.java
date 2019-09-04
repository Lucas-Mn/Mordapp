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
public class FragWpnDetailBlank extends Fragment {

    private Item item;

    private TextView lblTitle, lblDescription;

    public FragWpnDetailBlank() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_wpn_detail_blank, container, false);

        Bundle bundle = getArguments();
        item = (Item) bundle.getSerializable(FragWpnDetail.TAG_WEAPON);

        //region find views
        lblTitle = view.findViewById(R.id.frag_wpn_detail_name);
        lblDescription = view.findViewById(R.id.frag_wpn_detail_blank_description);
        //endregion

        //region set views
        if(item.getDescription()!=null)
            if(item.getDescription().equals("0"))
                lblDescription.setText("No description available for this item.");
            else
                lblDescription.setText(item.getDescription());
        //endregion

        return view;
    }

}
