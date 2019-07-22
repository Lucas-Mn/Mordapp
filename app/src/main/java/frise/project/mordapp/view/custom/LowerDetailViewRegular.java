package frise.project.mordapp.view.custom;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.RegularAttack;
import frise.project.mordapp.retrofit.HELPER;

public class LowerDetailViewRegular extends LowerDetailView {

    //region views
    private TextView lblBlockviewUp, lblBlockviewHorizontal, lblBlockviewDown,
            lblLength, lblTurncapH, lblTurncapV,
            lblMiss, lblFeint, lblMorph,
            lblDrain, lblNegation, lblSOH, lblCombo,
            lblKnockback, lblWood, lblStone,
            lblBlockHeld, lblBMR, lblFlinch;
    private RegularAttack attack;
    private View subView;
    //endregion

    public LowerDetailViewRegular(View parentView, Item item) {
        super(parentView, item);
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
        lblMiss = view.findViewById(R.id.stats_default_miss);
        lblFeint = view.findViewById(R.id.stats_default_feint);
        lblMorph = view.findViewById(R.id.stats_default_morph);
        lblDrain = view.findViewById(R.id.stats_default_drain);
        lblNegation = view.findViewById(R.id.stats_default_negation);
        lblSOH = view.findViewById(R.id.stats_default_soh);
        lblCombo = view.findViewById(R.id.stats_default_combo);
        lblKnockback = view.findViewById(R.id.stats_default_knockback);
        lblWood = view.findViewById(R.id.stats_default_wood);
        lblStone = view.findViewById(R.id.stats_default_stone);
        lblBlockHeld = view.findViewById(R.id.stats_default_block_held);
        lblBMR = view.findViewById(R.id.stats_default_bmr);
        lblFlinch = view.findViewById(R.id.stats_default_flinch);
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
        lblBlockviewUp.setText(String.valueOf(item.getBlockViewToleranceUp()));
        lblBlockviewHorizontal.setText(String.valueOf(attack.getBlockviewHorizontal()));
        lblBlockviewDown.setText(String.valueOf(attack.getBlockviewDown()));
        lblTurncapH.setText(String.valueOf(attack.getTurncapHorizontal()));
        lblTurncapV.setText(String.valueOf(attack.getTurncapVertical()));
        lblMiss.setText(String.valueOf(attack.getMissCost()));
        lblFeint.setText(String.valueOf(10));
        lblMorph.setText(String.valueOf(7));
        lblDrain.setText(String.valueOf(attack.getDrain()));
        lblNegation.setText(String.valueOf(attack.getNegation()));
        lblSOH.setText(HELPER.boolToYN(attack.isStop_on_hit()));
        lblCombo.setText(HELPER.boolToYN(attack.canCombo()));
        lblWood.setText(String.valueOf(attack.getWoodDamage()));
        lblStone.setText(String.valueOf(attack.getStoneDamage()));
        lblBlockHeld.setText("No");
        lblBMR.setText("No");
        lblFlinch.setText(HELPER.boolToYN(attack.canFlinch()));
    }
}
