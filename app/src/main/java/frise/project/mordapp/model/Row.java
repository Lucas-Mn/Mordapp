package frise.project.mordapp.model;

import android.util.Log;

import androidx.room.Entity;

import frise.project.mordapp.retrofit.HELPER;

public class Row {

    //region helpers
    public static final String MODES_REGULAR = "Regular";
    public static final String MODES_ALT = "Alt";
    //endregion

    //region attributes
    private int pos;
    private String name;
    private int cost;
    private String handed;
    private String mode;
    private String attacktype;
    private int head0, chest0, legs0,
                head1, chest1, legs1,
                head2, chest2, legs2,
                head3, chest3, legs3;
    private int windup, release, recovery, combo;
    private int drain, negation;
    private float miss;
    //turncap horizontal and vertical
    private float tch, tcv;
    private int length, kb, wood, stone;
    private String soh, comboes, flinch;
    private float bvtu, bvth, bvtd;
    private String heldblock;
    private String bmr;
    private int projectile_speed;
    private int gravity_scale;
    private int maxAmmo;
    private String description; //only used for useable items
    //endregion

    //region getters
    public String getName(){return name;}
    public int getPos(){return pos;}
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
    public boolean getStopOnHit(){return soh.equals("Yes");}
    public boolean getCanCombo(){return comboes.equals("Yes");}
    public boolean getCanFlinch(){return flinch.equals("Yes");}
    public float getBlockViewUp(){return bvtu;}
    public float getBlockViewHorizontal(){return bvth;}
    public float getBlockViewDown(){return bvtd;}
    public boolean getHeldBlock(){return heldblock.equals("Yes");}
    public String getBmr(){return bmr;}
    public int getProjectileSpeed(){return projectile_speed;}
    public int getGravityScale(){return gravity_scale;}
    public int getMaxAmmo(){return maxAmmo;}
    public String getDescription(){return description;}
    //endregion

    public Attack getAttack() {
        int[] dmg_head = new int[4];
        dmg_head[0] = head0;
        dmg_head[1] = head1;
        dmg_head[2] = head2;
        dmg_head[3] = head3;
        int[] dmg_chest = new int[4];
        dmg_chest[0] = chest0;
        dmg_chest[1] = chest1;
        dmg_chest[2] = chest2;
        dmg_chest[3] = chest3;
        int[] dmg_legs = new int[4];
        dmg_legs[0] = legs0;
        dmg_legs[1] = legs1;
        dmg_legs[2] = legs2;
        dmg_legs[3] = legs3;

        Attack atk;

        if(attacktype.equals(RegularAttack.STRIKE) || attacktype.equals(RegularAttack.STAB))
            atk = new RegularAttack(dmg_head, dmg_chest, dmg_legs
                                    ,windup, release, recovery, combo,
                                    drain, negation, miss,
                                    tch, tcv,
                                    getStopOnHit(), getCanCombo(), getCanFlinch(), length,
                                    kb, wood, stone);
        else if(attacktype.equals(ThrownAttack.TYPE))
            atk = new ThrownAttack(dmg_head, dmg_chest, dmg_legs,
                                    wood, stone, flinch,
                                    projectile_speed, gravity_scale);
        else //if(attacktype.equals(ShieldAttack.TYPE))
            atk = new ShieldAttack(bvtu, bvth, bvtd, tcv, tch, negation, getHeldBlock(), bmr);

        return atk;
    }

    //region String Builder
    @Override
    public String toString() {
        return buildString(
                pos, name, cost,
                handed, mode, attacktype,
                head0, chest0, legs0,
                head1, chest1, legs1,
                head2, chest2, legs2,
                head3, chest3, legs3,
                windup, combo, release, recovery,
                drain, negation, miss,
                tch, tcv, length,
                kb, wood, stone,
                soh, comboes, flinch,
                bvtu, bvth, bvtd,
                heldblock, bmr, projectile_speed,
                gravity_scale, maxAmmo, description);
    }

    private static final String SEPARATOR = "|";
    private String buildString(Object ... strings) {
        String s = "";
        for(Object x : strings) {
            s+= x + SEPARATOR; }
        return s;
    }

    public Row(String string) {
        LineReader r = new LineReader(string);
        pos = r.nextLineInt(); name = r.nextLine(); cost = r.nextLineInt();
        handed = r.nextLine(); mode = r.nextLine(); attacktype = r.nextLine();
        head0 = r.nextLineInt(); chest0 = r.nextLineInt(); legs0 = r.nextLineInt();
        head1 = r.nextLineInt(); chest1 = r.nextLineInt(); legs1 = r.nextLineInt();
        head2 = r.nextLineInt(); chest2 = r.nextLineInt(); legs2 = r.nextLineInt();
        head3 = r.nextLineInt(); chest3 = r.nextLineInt(); legs3 = r.nextLineInt();
        windup = r.nextLineInt(); combo = r.nextLineInt(); release = r.nextLineInt(); recovery = r.nextLineInt();
        drain = r.nextLineInt(); negation = r.nextLineInt(); miss = r.nextLineFloat();
        tch = r.nextLineFloat(); tcv = r.nextLineFloat(); length = r.nextLineInt();
        kb = r.nextLineInt(); wood = r.nextLineInt(); stone = r.nextLineInt();
        soh = r.nextLine(); comboes = r.nextLine(); flinch = r.nextLine();
        bvtu = r.nextLineFloat(); bvth = r.nextLineFloat(); bvtd = r.nextLineFloat();
        heldblock = r.nextLine(); bmr = r.nextLine(); projectile_speed = r.nextLineInt();
        gravity_scale = r.nextLineInt(); maxAmmo = r.nextLineInt(); description = r.nextLine();
    }

    private class LineReader {
        private String line;
        private int index;

        public LineReader(String line){
            this.line = line;
            this.index = 0; }

        public String nextLine() {
            String next;
            for(next = ""; true; index++) {
                String currentChar = line.substring(index, index+1);
                if(currentChar.equals(Row.SEPARATOR))
                    { index++; break; }
                else
                    next += currentChar; }

            return next;
        }

        public int nextLineInt(){
            return Integer.parseInt(nextLine()); }
        public float nextLineFloat(){
            return Float.parseFloat(nextLine()); }
        public boolean nextLineBool(){
            return nextLine().equals("Yes");
        }
    }
    //endregion

}
