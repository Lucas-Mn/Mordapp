package frise.project.mordapp.model;

public class ShieldAttack extends Attack{

    private float blockViewToleranceUp, blockViewToleranceHorizontal;
    private float blockViewToleranceDown;
    private float turncapVertical, turncapHorizontal;
    private int negation;
    private boolean heldBlock;
    private String blockMovementRestriction;

    public float getBlockViewToleranceUp(){return blockViewToleranceUp;}
    public float getBlockViewToleranceHorizontal(){return blockViewToleranceHorizontal;}
    public float getBlockViewToleranceDown(){return getBlockViewToleranceDown();}
    public float getTurncapVertical(){return turncapVertical;}
    public float getTurncapHorizontal(){return turncapHorizontal;}
    public int getNegation(){return negation;}
    public boolean getHeldBlock(){return heldBlock;}
    public String getBlockMovementRestriction(){return getBlockMovementRestriction();}

    public ShieldAttack(float blockViewToleranceUp, float blockViewToleranceHorizontal, float blockViewToleranceDown,
                        float turncapVertical, float turncapHorizontal, int negation,
                        boolean heldBlock, String blockMovementRestriction) {
        this.blockViewToleranceUp = blockViewToleranceUp;
        this.blockViewToleranceHorizontal = blockViewToleranceHorizontal;
        this.blockViewToleranceDown = blockViewToleranceDown;
        this.turncapVertical = turncapVertical;
        this.turncapHorizontal = turncapHorizontal;
        this.negation = negation;
        this.heldBlock = heldBlock;
        this.blockMovementRestriction = blockMovementRestriction;
    }

    public static final String TYPE = Item.TYPE_SHIELD;
    @Override
    public String getType() {
        return TYPE;
    }
}
