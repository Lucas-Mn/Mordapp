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

}
