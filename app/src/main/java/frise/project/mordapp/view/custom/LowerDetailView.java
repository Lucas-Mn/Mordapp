package frise.project.mordapp.view.custom;

import android.view.View;

import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.RegularAttack;

public abstract class LowerDetailView {

    protected View view;

    public LowerDetailView(View parentView, Attack attack) {}

    public abstract String getType();

    public abstract void setAttack(Attack attack);

}
