package frise.project.mordapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragSort extends Fragment {

    Button btnDmgAsc, btnDmgDesc;

    ActivityWeaponList activity;

    public FragSort() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sort, container, false);

        activity = (ActivityWeaponList) getActivity();
        btnDmgAsc = view.findViewById(R.id.frag_sort_btn_dmg_asc);
        btnDmgDesc = view.findViewById(R.id.frag_sort_btn_dmg_desc);

        btnDmgAsc.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Config cfg = new Config();
                cfg.ascending = true;
                cfg.type = SORT_TYPE.DMG;
                cfg.armour_piece = Item.ARMOUR_PIECE.head;
                cfg.armour_level = 3;
                activity.sort(cfg); }});

        btnDmgDesc.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Config cfg = new Config();
                cfg.ascending = false;
                cfg.type = SORT_TYPE.DMG;
                cfg.armour_piece = Item.ARMOUR_PIECE.head;
                cfg.armour_level = 3;
                activity.sort(cfg); }});

        return view;
    }

    public enum SORT_TYPE { DMG }
    public class Config{

        public SORT_TYPE type;
        public boolean ascending;

        //only necessary for type DMG
        public Item.ARMOUR_PIECE armour_piece;
        public int armour_level;
    }

}
