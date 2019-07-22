package frise.project.mordapp.view.custom;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Attack;
import frise.project.mordapp.model.RegularAttack;
import frise.project.mordapp.retrofit.HELPER;

public class DamageTable {

    View view;
    TextView[] lblHead, lblBody, lblLeg;

    public DamageTable(View tableLayout) {

        view = tableLayout;

        lblHead = new TextView[4];
        lblHead[0] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_head_lbl_0);
        lblHead[1] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_head_lbl_1);
        lblHead[2] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_head_lbl_2);
        lblHead[3] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_head_lbl_3);

        lblBody = new TextView[4];
        lblBody[0] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_body_lbl_0);
        lblBody[1] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_body_lbl_1);
        lblBody[2] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_body_lbl_2);
        lblBody[3] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_body_lbl_3);

        lblLeg = new TextView[4];
        lblLeg[0] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_leg_lbl_0);
        lblLeg[1] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_leg_lbl_1);
        lblLeg[2] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_leg_lbl_2);
        lblLeg[3] = tableLayout.findViewById(R.id.frag_wpn_detail_tbl_leg_lbl_3);
    }

    public void setValues(Attack atk) {
        if(atk!=null)
            for(int i = 0; i < 4; i++) {
                lblHead[i].setText(Integer.toString(atk.dmgHead()[i]));
                lblBody[i].setText(Integer.toString(atk.dmgChest()[i]));
                lblLeg[i].setText(Integer.toString(atk.dmgLeg()[i])); }
        else handleNullAttack();
    }

    public void setVisible(boolean visibility) {
        view.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    private void handleNullAttack() {
        Log.d(HELPER.DEBUG, "passed null attack to DamageTable");
    }
}
