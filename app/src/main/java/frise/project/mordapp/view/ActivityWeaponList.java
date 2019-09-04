package frise.project.mordapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;

import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.RegularAttack;
import frise.project.mordapp.retrofit.HELPER;

public class ActivityWeaponList extends AppCompatActivity
implements AdapterWpn.Listener, NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG_FRAG_WPN_LIST = "frg_wpn_list";

    DrawerLayout drawer;
    NavigationView navigationView;
    FragWpnList fragWpnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_list);

        drawer = findViewById(R.id.act_wpn_list_drawer);
        navigationView = findViewById(R.id.act_wpn_list_nav);

        navigationView.setNavigationItemSelectedListener(this);

        fragWpnList = new FragWpnList();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(TAG_FRAG_WPN_LIST);
        ft.replace(R.id.act_main_container, fragWpnList);
        ft.commit();
    }

    void setFrag(Fragment frag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.act_main_container, frag);
        ft.commit();
    }

    @Override
    public void onClick(Item item) {
        Fragment frg;
        if(item.getType().equals(RegularAttack.STRIKE) || item.getType().equals(RegularAttack.STAB))
            frg = new FragWpnDetail();
        else if(item.getType().equals(item.TYPE_SHIELD))
            frg = new FragWpnDetailShield();
        else if(item.getType().equals(item.TYPE_THROWN))
            frg = new FragWpnDetailThrown();
        else
            frg = new FragWpnDetailBlank();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragWpnDetail.TAG_WEAPON, item);
        frg.setArguments(bundle);
        setFrag(frg);
    }

    public void openDrawer(){
        drawer.openDrawer(GravityCompat.START);
    }

    //region GOTO
    public void gotoSort(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.act_main_container, new FragSort());
        ft.commit();
        Log.d(HELPER.DEBUG, "ActivityWeaponList: added FragSort");
    }

    public void sort(FragSort.Config config){
        getSupportFragmentManager().popBackStackImmediate(TAG_FRAG_WPN_LIST, 0);
        fragWpnList.sort(config);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_main_sort:
                gotoSort();
                break;
            case R.id.nav_main_about:
                break; }
        return false;
    }
    //endregion
}

//TODO: disallow back action if current fragment is FragWpnList. | close drawer after selecting option