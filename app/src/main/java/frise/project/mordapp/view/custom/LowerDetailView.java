package frise.project.mordapp.view.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.RegularAttack;

public abstract class LowerDetailView {

    protected View parentView;
    protected View view;

    public LowerDetailView(View parentView) {
        this.parentView = parentView;
    }

    public abstract String getType();
    public abstract View getSubView();

    public abstract void setAttack(Attack attack);

    public void setVisible(boolean visible) {
        getSubView().setVisibility(visible ? View.VISIBLE : view.GONE);
    }

    protected void inflate(int view_id) {
        view = LayoutInflater.from(parentView.getContext())
                .inflate(view_id, (ViewGroup)parentView.findViewById(R.id.frag_wpn_detail_lower_container), true);
    }

}
