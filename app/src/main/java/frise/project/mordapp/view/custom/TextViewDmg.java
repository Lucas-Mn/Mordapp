package frise.project.mordapp.view.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;

import frise.project.mordapp.R;

@SuppressLint("AppCompatCustomView")
public class TextViewDmg extends TextView {

    public TextViewDmg(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                updateText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void updateText(CharSequence text)
    {
        String s = text.toString();
        Integer value = Integer.parseInt(s);
        Resources res = getContext().getResources();
        if(value >= 100) {
            setBackgroundColor(res.getColor(R.color.colorDmg100));
            setTextColor(res.getColor(R.color.colorDmgTxt100)); }
        else if(value >= 50) {
            setBackgroundColor(res.getColor(R.color.colorDmg50));
            setTextColor(res.getColor(R.color.colorDmgTxt50)); }
        else if(value >= 34) {
            setBackgroundColor(res.getColor(R.color.colorDmg34));
            setTextColor(res.getColor(R.color.colorDmgTxt34)); }
        else if(value >= 25) {
            setBackgroundColor(res.getColor(R.color.colorDmg25));
            setTextColor(res.getColor(R.color.colorDmgTxt25)); }
        else {
            setBackgroundColor(res.getColor(R.color.colorDmg0));
            setTextColor(res.getColor(R.color.colorDmgTxt0)); }
    }

}
