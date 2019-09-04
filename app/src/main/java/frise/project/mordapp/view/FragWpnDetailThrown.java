package frise.project.mordapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.view.custom.DamageTable;
import frise.project.mordapp.view.custom.LowerDetailViewThrown;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragWpnDetailThrown extends Fragment {

    LowerDetailViewThrown lowerView;
    DamageTable table;

    TextView lblTitle;

    Item item;

    public FragWpnDetailThrown() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_wpn_detail_thrown, container, false);

        item = (Item) getArguments().getSerializable(FragWpnDetail.TAG_WEAPON);

        lblTitle = view.findViewById(R.id.frag_wpn_detail_name);

        lblTitle.setText(item.getName());
        table = new DamageTable(view.findViewById(R.id.frag_wpn_detail_table_layout));
        lowerView = new LowerDetailViewThrown(view, item);

        table.setValues(item.getAttack());
        lowerView.setAttack(item.getAttack());

        return view;
    }

}
