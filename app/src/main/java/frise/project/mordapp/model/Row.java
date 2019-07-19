package frise.project.mordapp.model;

import com.google.gson.annotations.SerializedName;

public class Row {

    private int listposition;
    private String name;
    private int cost;
    private String handed;
    private String mode;
    private String attacktype;
    private int head, chest, legs,
                head_2, chest_2, legs_2,
                head_3, chest_3, legs_3,
                head_4, chest_4, legs_4;
    private int windup, release, recovery, combo;
    private int drain, negation;
    private float miss;
    //turncap horizontal and vertical
    private float tch, tcv;
    private int length, kb, wood, stone;
    private String soh, comboes, flinch;
    private int bvtu, bvth, bvtd;
    private String held_block;
    private String bmr;
    private int projectile_speed;
    private float gravity_scale;
    private int max_ammo;

    public String getName(){return name;}
    public int getPos(){return listposition;}
    public int getCost(){return cost;}
    public String getHanded(){return handed;}
    public String getMode(){return mode;}
    public String getAttackType(){return attacktype;}
    //windup to negation
    public float getTurncapHorizontal(){return tch;}
    public float getTurncapVertical(){return tcv;}
    public int getLength(){return length;}
    public int getKnockback(){return kb;}
    public int getWoodDamage(){return wood;}
    public int getStoneDamage(){return stone;}
    public boolean getStopOnHit(){return soh=="Yes";}
    public boolean getCanCombo(){return comboes=="Yes";}
    public boolean getCanFlinch(){return flinch=="Yes";}
    public int getBlockViewUp(){return bvtu;}
    public int getBlockViewHorizontal(){return bvth;}
    public int getBlockViewDown(){return bvtd;}
    public boolean getHeldBlock(){return held_block=="Yes";}
    //bmr?
    public int getProjectileSpeed(){return projectile_speed;}
    public float getGravityScale(){return gravity_scale;}
    public int getMaxAmmo(){return max_ammo;}


    public Attack getAttack()
    {
        int[] dmg_head = new int[4];
        dmg_head[0] = head;
        dmg_head[1] = head_2;
        dmg_head[2] = head_3;
        dmg_head[3] = head_4;
        int[] dmg_chest = new int[4];
        dmg_chest[0] = chest;
        dmg_chest[1] = chest_2;
        dmg_chest[2] = chest_3;
        dmg_chest[3] = chest_4;
        int[] dmg_legs = new int[4];
        dmg_legs[0] = legs;
        dmg_legs[1] = legs_2;
        dmg_legs[2] = legs_3;
        dmg_legs[3] = legs_4;

        Attack atk;

        if(!attacktype.equals(ThrownAttack.TYPE))
            atk = new RegularAttack(dmg_head, dmg_chest, dmg_legs
                                    ,windup, release, recovery, combo,
                                    drain, negation, miss,
                                    tch, tcv,
                                    getStopOnHit(), length,
                                    kb, wood, stone);
        else
            atk = new ThrownAttack(dmg_head, dmg_chest, dmg_legs,
                                    wood, stone, flinch,
                                    projectile_speed, gravity_scale);

        return atk;
    }

    @Override
    public String toString()
    { return name; }

    public static final String MODES_REGULAR = "Regular";
    public static final String MODES_ALT = "Alt";

}
