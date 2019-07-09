package frise.project.mordapp.model;

public class Attack
{
    private int[] dmg_head;
    private int[] dmg_chest;
    private int[] dmg_leg;

    private int windup, release, recovery, combo;
    private boolean stop_on_hit;

    public int[] dmgHead(){return dmg_head;}
    public int[] dmgChest(){return dmg_chest;}
    public int[] dmgLeg(){return dmg_leg;}
    public int getWindup(){return windup;}
    public int getRelease(){return release;}
    public int getRecovery(){return recovery;}
    public int getCombo(){return combo;}
    public boolean isStop_on_hit(){return stop_on_hit;}

    public Attack(int[] dmg_head, int[] dmg_chest, int[] dmg_leg, int windup, int release, int recovery, int combo, boolean stop_on_hit)
    {
        this.dmg_head = dmg_head;
        this.dmg_chest = dmg_chest;
        this.dmg_leg = dmg_leg;
        this.windup = windup;
        this.release = release;
        this.recovery = recovery;
        this.combo = combo;
        this.stop_on_hit = stop_on_hit;
    }

    public static final String STAB = "Stab";
    public static final String STRIKE = "Strike";

}
