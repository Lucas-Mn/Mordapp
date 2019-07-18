package frise.project.mordapp.model;

import android.view.View;

import frise.project.mordapp.view.custom.LowerDetailView;
import frise.project.mordapp.view.custom.LowerDetailViewThrown;

public class ThrownAttack extends Attack {

    private int wood, stone;
    private boolean flinch;
    private int projectile_speed;
    private float gravity_scale;

    //region getters
    public int getWoodDamage(){return wood;}
    public int getStoneDamage(){return stone;}
    public boolean getFlinch(){return flinch;}
    public int getProjectileSpeed(){return projectile_speed;}
    public float getGravityScale(){return gravity_scale;}
    //endregion

    public ThrownAttack(int[] dmg_head, int[] dmg_chest, int[] dmg_leg,
                        int wood, int stone, String flinch, int projectile_speed, float gravity_scale) {
        this.dmg_head = dmg_head;
        this.dmg_chest = dmg_chest;
        this.dmg_leg = dmg_leg;
        this.wood = wood;
        this.stone = stone;
        this.flinch = (flinch == "Yes");
        this.projectile_speed = projectile_speed;
        this.gravity_scale = gravity_scale;
    }

    public static final String TYPE = "Thrown";
    @Override
    public String getType() {
        return TYPE; }

    @Override
    public LowerDetailView getDetailView(View parentView) {
        return new LowerDetailViewThrown(parentView, this); }
}
