package frise.project.mordapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.RowContainer;
import frise.project.mordapp.retrofit.HELPER;
import frise.project.mordapp.retrofit.ItemDAO;
import frise.project.mordapp.retrofit.ResultListener;

public class ActivityWeaponList extends AppCompatActivity
implements AdapterWpn.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_list);

        pegarFragment(new FragWpnList());
    }

    void pegarFragment(Fragment frag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.act_main_container, frag);
        ft.commit();
    }

    @Override
    public void onClick(Item item) {
        Fragment frg = new FragWpnDetail();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragWpnDetail.TAG_WEAPON, item);
        frg.setArguments(bundle);
        pegarFragment(frg);
    }
}
