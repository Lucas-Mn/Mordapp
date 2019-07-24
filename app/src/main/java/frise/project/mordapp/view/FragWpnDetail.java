package frise.project.mordapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.controller.WpnDetailManager;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.RegularAttack;
import frise.project.mordapp.view.custom.AttackTypeToggler;
import frise.project.mordapp.view.custom.DamageTable;
import frise.project.mordapp.view.custom.LowerDetailView;
import frise.project.mordapp.view.custom.LowerDetailViewRegular;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragWpnDetail extends Fragment {

    public static final String TAG_WEAPON = "weapon";

    private Item item;

    private TextView lblName;
    private DamageTable table;
    private AttackTypeToggler togglerAtk;
    private Button btnAlt;

    private WpnDetailManager wpnManager;

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

        //region find views
        lblName = view.findViewById(R.id.frag_wpn_detail_name);
        table = new DamageTable(view.findViewById(R.id.frag_wpn_detail_table_layout));
        btnAlt = view.findViewById(R.id.frag_wpn_detail_btn_alt);
        //endregion

        //region update views
        lblName.setText(item.getName());
        btnAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAlt(); }});
        //endregion

        wpnManager = new WpnDetailManager(view, item);

        return view;
    }

    private void toggleAlt() {
        wpnManager.toggleMode();
    }
}
