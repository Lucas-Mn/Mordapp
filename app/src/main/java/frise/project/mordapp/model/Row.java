package frise.project.mordapp.model;

public class Row {

    //region helpers
    public static final String MODES_REGULAR = "Regular";
    public static final String MODES_ALT = "Alt";
    //endregion

    //region attributes
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
    private float bvtu, bvth, bvtd;
    private String heldBlock;
    private String bmr;
    private int projectile_speed;
    private float gravity_scale;
    private int maxAmmo;
    private String description; //only used for useable items
    //endregion

    //region getters
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
    public float getBlockViewUp(){return bvtu;}
    public float getBlockViewHorizontal(){return bvth;}
    public float getBlockViewDown(){return bvtd;}
    public boolean getHeldBlock(){return heldBlock=="Yes";}
    //bmr?
    public int getProjectileSpeed(){return projectile_speed;}
    public float getGravityScale(){return gravity_scale;}
    public int getMaxAmmo(){return maxAmmo;}
    public String getDescription(){return description;}
    //endregion

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
                                    getStopOnHit(), getCanCombo(), getCanFlinch(), length,
                                    kb, wood, stone);
        else
            atk = new ThrownAttack(dmg_head, dmg_chest, dmg_legs,
                                    wood, stone, flinch,
                                    projectile_speed, gravity_scale);

        return atk;
    }

    //region String Builder
    @Override
    public String toString() {
        return buildString(
                listposition, name, cost,
                handed, mode, attacktype,
                head, chest, legs,
                head_2, chest_2, legs_2,
                head_3, chest_3, legs_3,
                head_4, chest_4, legs_4,
                windup, combo, release, recovery,
                drain, negation, miss,
                tch, tcv, length,
                kb, wood, stone,
                soh, comboes, flinch,
                bvtu, bvth, bvtd,
                heldBlock, bmr, projectile_speed,
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
        listposition = r.nextLineInt(); name = r.nextLine(); cost = r.nextLineInt();
        handed = r.nextLine(); mode = r.nextLine(); attacktype = r.nextLine();
        head = r.nextLineInt(); chest = r.nextLineInt(); legs = r.nextLineInt();
        head_2 = r.nextLineInt(); chest_2 = r.nextLineInt(); legs_2 = r.nextLineInt();
        head_3 = r.nextLineInt(); chest_3 = r.nextLineInt(); legs_3 = r.nextLineInt();
        head_4 = r.nextLineInt(); chest_4 = r.nextLineInt(); legs_4 = r.nextLineInt();
        windup = r.nextLineInt(); combo = r.nextLineInt(); release = r.nextLineInt(); recovery = r.nextLineInt();
        drain = r.nextLineInt(); negation = r.nextLineInt(); miss = r.nextLineFloat();
        tch = r.nextLineFloat(); tcv = r.nextLineFloat(); length = r.nextLineInt();
        kb = r.nextLineInt(); wood = r.nextLineInt(); stone = r.nextLineInt();
        soh = r.nextLine(); comboes = r.nextLine(); flinch = r.nextLine();
        bvtu = r.nextLineFloat(); bvth = r.nextLineFloat(); bvtd = r.nextLineFloat();
        heldBlock = r.nextLine(); bmr = r.nextLine(); projectile_speed = r.nextLineInt();
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
