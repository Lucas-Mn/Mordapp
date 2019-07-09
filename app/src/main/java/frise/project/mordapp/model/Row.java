package frise.project.mordapp.model;

import com.google.gson.annotations.SerializedName;

public class Row {

    private int listposition;
    private String name;
    private int cost;
    private String handed;
    private String mode;
    private String attacktype;
    private int head, chest, legs, head_2, chest_2, legs_2, head_3, chest_3, legs_3,
                head_4, chest_4, legs_4;
    private int windup, release, recovery, combo;

    public String getName(){return name;}
    public int getPos(){return listposition;}
    public int getCost(){return cost;}
    public String getHanded(){return handed;}
    public String getMode(){return mode;}
    public String getAttackType(){return attacktype;}

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
        Attack atk = new Attack(dmg_head, dmg_chest, dmg_legs
                                ,windup, release, recovery, combo, false);
        return atk;
    }

    @Override
    public String toString()
    { return name; }

    public static final String MODES_REGULAR = "Regular";
    public static final String MODES_ALT = "Alt";

}
