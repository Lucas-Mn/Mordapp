package frise.project.mordapp.controller;

import android.view.View;
import android.widget.FrameLayout;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.RegularAttack;
import frise.project.mordapp.view.custom.AttackTypeToggler;
import frise.project.mordapp.view.custom.DamageTable;
import frise.project.mordapp.view.custom.LowerDetailView;

public class WpnDetailManager
implements AttackTypeToggler.Listener {

    private Item.MODE mode = Item.MODE.REGULAR;
    private Item.ATK_TYPE atkType = Item.ATK_TYPE.STRIKE;

    private Item item;

    private View view;
    private DamageTable table;
    private LowerDetailView lowerDetailView;
    private AttackTypeToggler typeToggler;

    public WpnDetailManager(View view, Item item)
    {
        this.view = view;
        this.item = item;

        table = new DamageTable(view.findViewById(R.id.frag_wpn_detail_table_layout));

        table.setValues(item.getAttack(mode, Item.ATK_TYPE.STRIKE));

        typeToggler = new AttackTypeToggler(
                view.findViewById(R.id.frag_wpn_detail_btn_strike),
                view.findViewById(R.id.frag_wpn_detail_btn_stab),
        this);

        lowerDetailView = item.getAttack(mode, Item.ATK_TYPE.STRIKE).getDetailView(view);
        lowerDetailView.setAttack(getCurrentAttack());
    }

    public void toggleMode() {
        if(mode == Item.MODE.REGULAR)
            mode = Item.MODE.ALT;
        else mode = Item.MODE.REGULAR;
        updateViews();
    }

    public void setAtkType(Item.ATK_TYPE type) {
        this.atkType = type;
        updateViews();
    }

    private void updateViews() {
        table.setValues(getCurrentAttack());
        if(lowerDetailView.getType() == getCurrentAttack().getType())
            lowerDetailView.setAttack(getCurrentAttack());
        else
            lowerDetailView = getCurrentAttack().getDetailView(view);
    }

    //AttackTypeToggler.Listener
    @Override
    public void toggle() {
        if(atkType== Item.ATK_TYPE.STRIKE)
            atkType = Item.ATK_TYPE.STAB;
        else atkType = Item.ATK_TYPE.STRIKE;
        updateViews();
    }

    public Attack getCurrentAttack()
    { return item.getAttack(mode, atkType); }
}
