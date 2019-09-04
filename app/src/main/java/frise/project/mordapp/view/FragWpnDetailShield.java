package frise.project.mordapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.ShieldAttack;
import frise.project.mordapp.retrofit.HELPER;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragWpnDetailShield extends Fragment {

    private Item item;

    private ViewGroup detailContainer;
    private TextView lblTitle;
    private TextView lblBvtUp, lblBvtHorizontal, lblBvtDown,
        lblTurncapVertical, lblTurncapHorizontal,
        lblNegation, lblBlockHeld, lblBmr;

    public FragWpnDetailShield() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_wpn_detail_shield, container, false);

        Bundle bundle = getArguments();
        item = (Item) bundle.getSerializable(FragWpnDetail.TAG_WEAPON);

        //region find views
        detailContainer = view.findViewById(R.id.frag_wpn_shield_container);
        LayoutInflater.from(getContext()).inflate(R.layout.lower_stats_shield, detailContainer);
        lblTitle = view.findViewById(R.id.frag_wpn_detail_name);
        lblBvtUp = detailContainer.findViewById(R.id.stats_shield_blockview_up);
        lblBvtHorizontal = detailContainer.findViewById(R.id.stats_shield_blockview_horizontal);
        lblBvtDown = detailContainer.findViewById(R.id.stats_shield_blockview_down);
        lblTurncapVertical = detailContainer.findViewById(R.id.stats_shield_turncap_vertical);
        lblTurncapHorizontal = detailContainer.findViewById(R.id.stats_shield_turncap_horizontal);
        lblNegation = detailContainer.findViewById(R.id.stats_shield_negation);
        lblBlockHeld = detailContainer.findViewById(R.id.stats_shield_block_held);
        lblBmr = detailContainer.findViewById(R.id.stats_shield_bmr);
        //endregion

        //region set views
        lblTitle.setText(item.getName());
        lblBvtUp.setText(String.valueOf(item.getBlockViewToleranceUp()));
        lblBvtHorizontal.setText(String.valueOf(item.getBlockViewToleranceHorizontal()));
        lblBvtDown.setText(String.valueOf(item.getBlockViewToleranceDown()));
        ShieldAttack atk = (ShieldAttack) item.getAttack();
        lblTurncapVertical.setText(String.valueOf(atk.getTurncapVertical()));
        lblTurncapHorizontal.setText(String.valueOf(atk.getTurncapHorizontal()));
        lblNegation.setText(String.valueOf(atk.getNegation()));
        lblBlockHeld.setText(HELPER.boolToYN(item.isBlockHeld()));
        lblBmr.setText(item.getBmr());
        //endregion

        return view;

    }

}
