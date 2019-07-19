package frise.project.mordapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import frise.project.mordapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragWpnDetailBlank extends Fragment {


    public FragWpnDetailBlank() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_wpn_detail_blank, container, false);
    }

}
