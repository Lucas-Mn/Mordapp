package frise.project.mordapp.model;

public class ShieldAttack extends Attack{

    private float turncapVertical, turncapHorizontal;
    private int negation;

    public float getTurncapVertical(){return turncapVertical;}
    public float getTurncapHorizontal(){return turncapHorizontal;}
    public int getNegation(){return negation;}

    public ShieldAttack(float turncapVertical, float turncapHorizontal, int negation) {
        this.turncapVertical = turncapVertical;
        this.turncapHorizontal = turncapHorizontal;
        this.negation = negation;
    }

    public static final String TYPE = Item.TYPE_SHIELD;
    @Override
    public String getType() {
        return TYPE;
    }
}
