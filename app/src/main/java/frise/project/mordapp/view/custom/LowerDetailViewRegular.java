package frise.project.mordapp.view.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.RegularAttack;

public class LowerDetailViewRegular extends LowerDetailView {

    private TextView lblBlockviewUp, lblBlockviewHorizontal, lblBlockviewDown;
    private RegularAttack attack;

    public LowerDetailViewRegular(View parentView, RegularAttack attack) {
        super(parentView, attack);
        view = LayoutInflater.from(parentView.getContext())
                      .inflate(R.layout.lower_stats_default,
                        (ViewGroup)parentView.findViewById(R.id.frag_wpn_detail_lower_container));
        this.attack = attack;
        //region find views
        lblBlockviewUp = view.findViewById(R.id.stats_default_blockview_up);
        lblBlockviewHorizontal = view.findViewById(R.id.stats_default_blockview_horizontal);
        lblBlockviewDown = view.findViewById(R.id.stats_default_blockview_down);
        //endregion

        setViews();
    }

    private void setViews() {

    }

    @Override
    public String getType() {
        return RegularAttack.TYPE; }

    @Override
    public void setAttack(Attack newAttack) {
        this.attack = (RegularAttack) newAttack;
        lblBlockviewUp.setText(String.valueOf(attack.getBlockviewUp()));
        lblBlockviewHorizontal.setText(String.valueOf(attack.getBlockviewHorizontal()));
        lblBlockviewDown.setText(String.valueOf(attack.getBlockviewDown()));
    }
}
