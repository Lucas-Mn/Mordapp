package frise.project.mordapp.model;

import java.io.Serializable;

public class Item implements Serializable {

    public static final String TYPE_WEAPON = "weapon";
    public static final String TYPE_USEABLE = "useable";

    private String name;
    private int pos;
    private String type; //weapon or item
    private int cost;
    private Attack stab, strike;
    private Attack alt_stab, alt_strike;
    private int range, alt_range;

    public Item(String name, String type, int cost, RegularAttack stab, RegularAttack strike, RegularAttack alt_stab, RegularAttack alt_strike, int range, int alt_range) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.stab = stab;
        this.strike = strike;
        this.alt_stab = alt_stab;
        this.alt_strike = alt_strike;
        this.range = range;
        this.alt_range = alt_range;
    }

    public Item(Row row)
    {
        name = row.getName();
        pos = row.getPos();
        cost = row.getCost();
        if(row.getMode().equals(Row.MODES_REGULAR))
            if(row.getAttackType().equals(Attack.STRIKE))
                strike = row.getAttack();
            else if(row.getAttackType().equals(Attack.STAB))
                stab = row.getAttack();
        else
            if(row.getAttackType().equals(Attack.STRIKE))
                alt_strike = row.getAttack();
            else if(row.getAttackType().equals(Attack.STAB))
                alt_stab = row.getAttack();
        type = row.getAttackType()=="Use"?TYPE_USEABLE:TYPE_WEAPON;
    }

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

    //region gets
    public String getName(){return name;}
    public int getPos(){return pos;}
    public String getType(){return type;}
    public int getCost(){return cost;}
    public int getRange(){return range;}
    public int getAltRange(){return alt_range;}
    //endregion

    public enum MODE { REGULAR, ALT; }
    public enum ATK_TYPE { STRIKE, STAB; }
    public Attack getAttack(MODE mode, ATK_TYPE type) {
        if(mode == MODE.REGULAR)
            if(type == ATK_TYPE.STRIKE)
                return strike;
            else return stab;
        else if(type == ATK_TYPE.STRIKE)
            return alt_strike;
        else return alt_stab;
    }

}
