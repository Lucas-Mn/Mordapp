package frise.project.mordapp.view;

import android.view.View;
import android.widget.ImageView;

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

    //region variables
    private Item.MODE mode = Item.MODE.REGULAR;
    private Item.ATK_TYPE atkType = Item.ATK_TYPE.STRIKE;

    private Item item;

    private View view;
    private DamageTable table;
    private LowerDetailView currentDetailView;
    private Map<String, LowerDetailView> detailViews;
    private AttackTypeToggler typeToggler;
    private ImageView btnToggleMode;
    //endregion

    public WpnDetailManager(View view, Item item) {
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
        //regular attack details
        detailViews.put(RegularAttack.TYPE, new LowerDetailViewRegular(view, item));
        //if there is an alt mode, add thrown view if necessary
        if(item.getAttack(Item.MODE.ALT, Item.ATK_TYPE.STRIKE) != null) {
            if(item.getAttack(Item.MODE.ALT, Item.ATK_TYPE.STRIKE).getType() == ThrownAttack.TYPE)
                detailViews.put(ThrownAttack.TYPE, new LowerDetailViewThrown(view, item)); }
        else //if there is no alt mode, remove mode toggle
            btnToggleMode.setVisibility(View.GONE);
        selectDetailView(getCurrentAttack().getType());
    }

    //region controls
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

    //AttackTypeToggler.Listener
    @Override public void toggle() {
        if(atkType== Item.ATK_TYPE.STRIKE)
            atkType = Item.ATK_TYPE.STAB;
        else atkType = Item.ATK_TYPE.STRIKE;
        updateViews();
    }
    //endregion

    //region private methods
    private void updateViews() {
        table.setValues(getCurrentAttack());
        selectDetailView(getCurrentAttack().getType());
        btnToggleMode.setImageResource(mode == Item.MODE.REGULAR
                ? R.drawable.checkbox_off : R.drawable.checkbox_on);
    }

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
    //endregion

    //region public info
    public Attack getCurrentAttack() {
        return item.getAttack(mode, atkType); }
    //endregion
}
