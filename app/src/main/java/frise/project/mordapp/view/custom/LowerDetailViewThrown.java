package frise.project.mordapp.view.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.ThrownAttack;
import frise.project.mordapp.retrofit.HELPER;

public class LowerDetailViewThrown extends LowerDetailView {

    private ThrownAttack attack;
    private View subView;

    //region views
    private TextView lblWood, lblStone, lblFlinch, lblProjectileSpeed, lblGravity;
    //endregion

    public LowerDetailViewThrown(View parentView, Item item) {
        super(parentView, item);
        inflate(R.layout.lower_stats_throwable);
        subView = view.findViewById(R.id.lower_stats_thrown_container);

        //region find views
        lblWood = view.findViewById(R.id.stats_throwable_wood_damage);
        lblStone = view.findViewById(R.id.stats_throwable_stone_damage);
        lblFlinch = view.findViewById(R.id.stats_throwable_can_flinch);
        lblProjectileSpeed = view.findViewById(R.id.stats_throwable_projectile_speed);
        lblGravity = view.findViewById(R.id.stats_throwable_gravity_scale);
        //endregion
    }

    @Override
    public String getType() {
        return ThrownAttack.TYPE; }

    @Override
    public View getSubView() {
        return subView;
    }

    @Override
    public void setAttack(Attack attack) {
        this.attack = (ThrownAttack) attack;
        lblWood.setText(String.valueOf(this.attack.getWoodDamage()));
        lblStone.setText(String.valueOf(this.attack.getStoneDamage()));
        lblFlinch.setText(HELPER.boolToYN(this.attack.getFlinch()));
        lblProjectileSpeed.setText(String.valueOf(this.attack.getProjectileSpeed()));
        lblGravity.setText(String.valueOf(this.attack.getGravityScale()));
    }
}
