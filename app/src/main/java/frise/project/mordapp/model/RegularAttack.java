package frise.project.mordapp.model;

import android.view.View;

import frise.project.mordapp.view.custom.LowerDetailView;
import frise.project.mordapp.view.custom.LowerDetailViewRegular;

public class RegularAttack extends Attack
{

    private int windup, release, recovery, combo;
    private int drain, negation;
    private float miss;
    private float turncapHorizontal, turncapVertical;
    private boolean stop_on_hit;
    private int length;
    private int knockback, wood, stone;
    private int blockviewUp, blockviewHorizontal, blockviewDown;

    public static final String TYPE = "regular";
    @Override
    public String getType() {
        return TYPE; }

    @Override
    public LowerDetailView getDetailView(View parentView) {
        return new LowerDetailViewRegular(parentView); }

    //region constructor
    public RegularAttack(
            int[] dmg_head, int[] dmg_chest, int[] dmg_leg,
            int windup, int release, int recovery, int combo,
            int drain, int negation, float miss,
            float turncapHorizontal, float turncapVertical,
            boolean stop_on_hit, int length,
            int knockback, int wood, int stone) {

        this.dmg_head = dmg_head;
        this.dmg_chest = dmg_chest;
        this.dmg_leg = dmg_leg;
        this.windup = windup;
        this.release = release;
        this.recovery = recovery;
        this.combo = combo;
        this.drain = drain;
        this.negation = negation;
        this.miss = miss;
        this.turncapHorizontal = turncapHorizontal;
        this.turncapVertical = turncapVertical;
        this.stop_on_hit = stop_on_hit;
        this.length = length;
        blockviewUp = 40;
        blockviewHorizontal = 55;
        blockviewDown = 55;
    }
    //endregion

    //region gets
    public int getWindup(){return windup;}
    public int getRelease(){return release;}
    public int getRecovery(){return recovery;}
    public int getCombo(){return combo;}
    public int getDrain(){return drain;}
    public int getNegation(){return negation;}
    public float getMissCost(){return miss;}
    public float getTurncapHorizontal(){return turncapHorizontal;}
    public float getTurncapVertical(){return turncapVertical;}
    public boolean isStop_on_hit(){return stop_on_hit;}
    public int getLenght(){return length;}
    public int getKnockback(){return knockback;}
    public int getWoodDamage(){return wood;}
    public int getStoneDamage(){return stone;}
    public int getBlockviewUp(){return blockviewUp;}
    public int getBlockviewHorizontal(){return blockviewHorizontal;}
    public int getBlockviewDown(){return blockviewDown;}
    //endregion
}
