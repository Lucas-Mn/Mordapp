package frise.project.mordapp.controller;

import android.icu.text.CaseMap;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.RegularAttack;
import frise.project.mordapp.model.ThrownAttack;
import frise.project.mordapp.view.custom.AttackTypeToggler;
import frise.project.mordapp.view.custom.DamageTable;
import frise.project.mordapp.view.custom.LowerDetailView;
import frise.project.mordapp.view.custom.LowerDetailViewRegular;
import frise.project.mordapp.view.custom.LowerDetailViewThrown;

public class WpnDetailManager
implements AttackTypeToggler.Listener {

    private Item.MODE mode = Item.MODE.REGULAR;
    private Item.ATK_TYPE atkType = Item.ATK_TYPE.STRIKE;

    private Item item;

    private View view;
    private DamageTable table;
    private LowerDetailView currentDetailView;
    private Map<String, LowerDetailView> detailViews;
    private AttackTypeToggler typeToggler;
    private Button btnToggleMode;

    public WpnDetailManager(View view, Item item)
    {
        this.view = view;
        this.item = item;

        btnToggleMode = view.findViewById(R.id.frag_wpn_detail_btn_alt);

        table = new DamageTable(view.findViewById(R.id.frag_wpn_detail_table_layout));

        table.setValues(item.getAttack(mode, Item.ATK_TYPE.STRIKE));

        typeToggler = new AttackTypeToggler(
                view.findViewById(R.id.frag_wpn_detail_btn_strike),
                view.findViewById(R.id.frag_wpn_detail_btn_stab),
        this);


        detailViews = new HashMap<>();
        detailViews.put(RegularAttack.TYPE, new LowerDetailViewRegular(view));
        if(item.getAttack(Item.MODE.ALT, Item.ATK_TYPE.STRIKE) != null)
            detailViews.put(ThrownAttack.TYPE, new LowerDetailViewThrown(view));
        else
            btnToggleMode.setVisibility(View.GONE);
        selectDetailView(getCurrentAttack().getType());

//        lowerDetailView = item.getAttack(mode, Item.ATK_TYPE.STRIKE).getDetailView(view);
//        lowerDetailView.setAttack(getCurrentAttack());
    }

    public void toggleMode() {
        typeToggler.setVisible(true);
        if(mode == Item.MODE.REGULAR) {
            mode = Item.MODE.ALT;
            if(item.getAttack(Item.MODE.ALT, Item.ATK_TYPE.STAB) == null) {
                atkType = Item.ATK_TYPE.STRIKE;
                typeToggler.setVisible(false); } }
        else mode = Item.MODE.REGULAR;
        updateViews();
    }

    public void setAtkType(Item.ATK_TYPE type) {
        this.atkType = type;
        updateViews();
    }

    private void updateViews() {
        table.setValues(getCurrentAttack());
        selectDetailView(getCurrentAttack().getType());
    }

    //AttackTypeToggler.Listener
    @Override
    public void toggle() {
        if(atkType== Item.ATK_TYPE.STRIKE)
            atkType = Item.ATK_TYPE.STAB;
        else atkType = Item.ATK_TYPE.STRIKE;
        updateViews();
    }

    public Attack getCurrentAttack() {
        return item.getAttack(mode, atkType); }

    private void selectDetailView(String type) {
        for(LowerDetailView v : detailViews.values()) {
            if(v.getType().equals(type)) {
                v.setVisible(true);
                currentDetailView = v; }
            else
                v.setVisible(false);
        }
        currentDetailView.setAttack(getCurrentAttack());
    }
}
