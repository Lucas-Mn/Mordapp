package frise.project.mordapp.model;

public class Item {

    private String name;
    private int pos;
    private String type; //weapon or item
    private int cost;
    private Attack stab, strike;
    private Attack alt_stab, alt_strike;
    private int range, alt_range;

    public Item(String name, String type, int cost, Attack stab, Attack strike, Attack alt_stab, Attack alt_strike, int range, int alt_range) {
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
        if(row.getMode()==Row.MODES_REGULAR)
            if(row.getAttackType()==Attack.STRIKE)
                strike = row.getAttack();
            else if(row.getAttackType()==Attack.STAB)
                stab = row.getAttack();
        else
            if(row.getAttackType()==Attack.STRIKE)
                alt_strike = row.getAttack();
            else if(row.getAttackType()==Attack.STAB)
                alt_stab = row.getAttack();
    }

    public void addRow(Row row)
    {
        if(row.getMode()==Row.MODES_REGULAR)
            if(row.getAttackType()==Attack.STRIKE)
                strike = row.getAttack();
            else
                stab = row.getAttack();
        else
            if(row.getAttackType()==Attack.STRIKE)
                alt_strike = row.getAttack();
            else
                alt_stab = row.getAttack();
    }

    public String getName(){return name;}
    public int getPos(){return pos;}
    public String getType(){return type;}
    public int getCost(){return cost;}
    public Attack getStab(){return stab;}
    public Attack getStrike(){return strike;}
    public Attack getAltStab(){return alt_stab;}
    public Attack getAltStrike(){return alt_strike;}
    public int getRange(){return range;}
    public int getAltRange(){return alt_range;}

}
