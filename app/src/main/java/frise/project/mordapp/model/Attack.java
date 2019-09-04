package frise.project.mordapp.model;

public abstract class Attack {

    public static final String STAB = "Stab";
    public static final String STRIKE = "Strike";

    protected int[] dmg_head;
    protected int[] dmg_chest;
    protected int[] dmg_leg;

    public abstract String getType();
    public int[] dmgHead(){return dmg_head;}
    public int[] dmgChest(){return dmg_chest;}
    public int[] dmgLeg(){return dmg_leg;}

    public Integer getDmgHead(int armour){ return dmg_head[armour]; }
    public Integer getDmgChest(int armour){ return dmg_chest[armour]; }
    public Integer getDmgLeg(int armour){ return dmg_leg[armour]; }
    public Integer getDmg(Item.ARMOUR_PIECE armour_piece, int armour_level){
        switch(armour_piece){
            case head:
                return getDmgHead(armour_level);
            case chest:
                return getDmgChest(armour_level);
            case leg:
                return getDmgLeg(armour_level); }
        return null; }

}
