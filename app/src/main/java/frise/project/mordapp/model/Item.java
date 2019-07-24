package frise.project.mordapp.model;

import java.io.Serializable;

public class Item implements Serializable {

    //region helpers
    public static final String TYPE_WEAPON = "weapon";
    public static final String TYPE_USEABLE = "useable";
    public static final String TYPE_SHIELD = "Shield";
    public static final String HANDED_ONE = "One-Handed";
    public static final String HANDED_TWO = "Two-Handed";
    public static final String HANDED_HYBRID = "One/Two-Handed";
    public static final String HANDED_SHIELD = "Shield";
    //endregion

    //region attributes
    private String name;
    private int pos;
    private String type; //weapon or item
    private int cost;
    private String handed;
    private Attack stab, strike;
    private Attack alt_stab, alt_strike;
    private float bvth, bvtu, bvtd;
    private boolean heldBlock;
    private String bmr;
    private String description;
    //endregion

    //region gets
    public String getName(){return name;}
    public int getPos(){return pos;}
    public String getType(){return type;}
    public int getCost(){return cost;}
    public String getHanded(){return handed;}
    public float getBlockViewToleranceHorizontal(){return bvth;}
    public float getBlockViewToleranceUp(){return bvtu;}
    public float getBlockViewToleranceDown(){return bvtd;}
    public boolean isBlockHeld(){return heldBlock;}
    public String getBmr(){return bmr;}
    public String getDescription(){return description;}
    //endregion

    //region constructors
    public Item(String name, String type, int cost, String handed, RegularAttack stab, RegularAttack strike, RegularAttack alt_stab, RegularAttack alt_strike,
                int range, int alt_range, float bvth, float bvtu, float bvtd) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.stab = stab;
        this.strike = strike;
        this.alt_stab = alt_stab;
        this.alt_strike = alt_strike;
        this.bvth = bvth;
        this.bvtu = bvtu;
        this.bvtd = bvtd;
    }

    public Item(Row row)
    {
        name = row.getName();
        pos = row.getPos();
        cost = row.getCost();
        handed = row.getHanded();
        bvth = row.getBlockViewHorizontal();
        bvtu = row.getBlockViewUp();
        bvtd = row.getBlockViewDown();
        heldBlock = row.getHeldBlock();
        bmr = row.getBmr();
        description = row.getDescription();
        if(row.getMode().equals(Row.MODES_REGULAR))
            if(row.getAttackType().equals(Attack.STRIKE))
                strike = row.getAttack();
            else if(row.getAttackType().equals(Attack.STAB))
                stab = row.getAttack();
            else strike = row.getAttack();
        else
            if(row.getAttackType().equals(Attack.STRIKE))
                alt_strike = row.getAttack();
            else if(row.getAttackType().equals(Attack.STAB))
                alt_stab = row.getAttack();
        type = row.getAttackType();
    }
    //endregion

    //region methods
    public void addRow(Row row) {
        if(row.getMode().equals(Row.MODES_REGULAR)){
            if(row.getAttackType().equals(Attack.STRIKE))
                strike = row.getAttack();
            else if(row.getAttackType().equals(Attack.STAB))
                stab = row.getAttack();
            else if(row.getAttackType().equals(ThrownAttack.TYPE))
                strike = row.getAttack(); }
        else if(row.getMode().equals(Row.MODES_ALT)) {
            if(row.getAttackType().equals(Attack.STRIKE))
                alt_strike = row.getAttack();
            else if(row.getAttackType().equals(Attack.STAB))
                alt_stab = row.getAttack();
            else if(row.getAttackType().equals(ThrownAttack.TYPE))
                alt_strike = row.getAttack(); }
    }

    public String getHandedShorthand()
    {
        if(handed.equals(HANDED_ONE))
            return "1H";
        if(handed.equals(HANDED_TWO))
            return "2H";
        if(handed.equals(HANDED_HYBRID))
            return "1/2H";
        if(handed.equals(HANDED_SHIELD))
            return "Shield";
        return "";
    }

    public enum MODE { REGULAR, ALT; }
    public enum ATK_TYPE { STRIKE, STAB; }
    public Attack getAttack(){ return strike; }
    public Attack getAttack(MODE mode, ATK_TYPE type) {
        if(mode == MODE.REGULAR)
            if(type == ATK_TYPE.STRIKE)
                return strike;
            else return stab;
        else if(type == ATK_TYPE.STRIKE)
            return alt_strike;
        else return alt_stab;
    }
    //endregion


}
