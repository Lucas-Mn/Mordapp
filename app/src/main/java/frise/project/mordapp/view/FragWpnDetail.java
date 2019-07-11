package frise.project.mordapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.view.custom.AttackTypeToggler;
import frise.project.mordapp.view.custom.DamageTable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragWpnDetail extends Fragment
implements AttackTypeToggler.Listener {

    public static final String TAG_WEAPON = "weapon";

    private Item item;

    private TextView lblName;
    private DamageTable table;
    private AttackTypeToggler togglerAtk;

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

        //find views
        lblName = view.findViewById(R.id.frag_wpn_detail_name);
        table = new DamageTable(view.findViewById(R.id.frag_wpn_detail_table_layout));
        togglerAtk = new AttackTypeToggler(
                view.findViewById(R.id.frag_wpn_detail_btn_strike),
                view.findViewById(R.id.frag_wpn_detail_btn_stab),
                        this);

        //update views
        lblName.setText(item.getName());
        table.setValues(item.getStrike());

        return view;
    }

    @Override
    public void strike() {
        table.setValues(item.getStrike());
    }

    @Override
    public void stab() {
        table.setValues(item.getStab());
    }
}
