package frise.project.mordapp.view.custom;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.RegularAttack;

public class LowerDetailViewRegular extends LowerDetailView {

    private TextView lblBlockviewUp, lblBlockviewHorizontal, lblBlockviewDown,
            lblLength, lblTurncapH, lblTurncapV;
    private RegularAttack attack;
    private View subView;

    public LowerDetailViewRegular(View parentView) {
        super(parentView);
        inflate(R.layout.lower_stats_default);
        subView = view.findViewById(R.id.lower_stats_regular_container);
        this.attack = attack;

        //region find views
        lblLength = view.findViewById(R.id.stats_default_length);
        lblBlockviewUp = view.findViewById(R.id.stats_default_blockview_up);
        lblBlockviewHorizontal = view.findViewById(R.id.stats_default_blockview_horizontal);
        lblBlockviewDown = view.findViewById(R.id.stats_default_blockview_down);
        lblTurncapH = view.findViewById(R.id.stats_default_turncap_horizontal);
        lblTurncapV = view.findViewById(R.id.stats_default_turncap_vertical);
        //endregion

        setViews();
    }

    private void setViews() {

    }

    @Override
    public String getType() {
        return RegularAttack.TYPE; }

    @Override
    public View getSubView() {
        return subView;
    }

    @Override
    public void setAttack(Attack newAttack) {
        this.attack = (RegularAttack) newAttack;
        lblLength.setText(String.valueOf(attack.getLenght()));
        lblBlockviewUp.setText(String.valueOf(attack.getBlockviewUp()));
        lblBlockviewHorizontal.setText(String.valueOf(attack.getBlockviewHorizontal()));
        lblBlockviewDown.setText(String.valueOf(attack.getBlockviewDown()));
        lblTurncapH.setText(String.valueOf(attack.getTurncapHorizontal()));
        lblTurncapV.setText(String.valueOf(attack.getTurncapVertical()));
    }
}
