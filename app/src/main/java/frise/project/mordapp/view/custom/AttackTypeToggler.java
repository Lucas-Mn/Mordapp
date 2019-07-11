package frise.project.mordapp.view.custom;

import android.view.View;
import android.widget.ImageView;

import frise.project.mordapp.R;

public class AttackTypeToggler {

    ImageView imgStrike, imgStab;
    String selection;
    private Listener listener;

    private static final String STRIKE = "strike";
    private static final String STAB = "stab";

    public AttackTypeToggler(View strike, View stab, Listener listener)
    {
        imgStrike = (ImageView) strike;
        imgStab = (ImageView) stab;
        imgStrike.setImageResource(R.drawable.btn_toggle_strike_on);
        imgStab.setImageResource(R.drawable.btn_toggle_stab_off);
        selection = STRIKE;
        this.listener = listener;
        imgStrike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(STRIKE);
            }
        });
        imgStab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(STAB);
            }
        });
    }

    private void click(String atkType)
    {
        if(atkType.equals(selection))
            return;
        if(atkType.equals(STRIKE))
        {
            listener.strike();
            imgStrike.setImageResource(R.drawable.btn_toggle_strike_on);
            imgStab.setImageResource(R.drawable.btn_toggle_stab_off);
        }
        else
        {
            listener.stab();
            imgStrike.setImageResource(R.drawable.btn_toggle_strike_off);
            imgStab.setImageResource(R.drawable.btn_toggle_stab_on);
        }
        selection = atkType;
    }

    public interface Listener
    {
        void strike();
        void stab();
    }

}
