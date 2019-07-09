package frise.project.mordapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import frise.project.mordapp.R;
import frise.project.mordapp.model.RowContainer;
import frise.project.mordapp.retrofit.HELPER;
import frise.project.mordapp.retrofit.ItemDAO;
import frise.project.mordapp.retrofit.ResultListener;

public class ActivityWeaponList extends AppCompatActivity {

    RecyclerView recycler;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_list);

        recycler = findViewById(R.id.act_list_recycler);
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        ItemDAO dao = new ItemDAO();
        dao.getRowContainer(new ResultListener<RowContainer>() {
            @Override
            public void finish(RowContainer container) {

                Toast.makeText(ActivityWeaponList.this, container.toString(), Toast.LENGTH_LONG)
                        .show();
                Log.d(HELPER.DEBUG, container.toString());
                adapter = new AdapterWpn(container.getItems());
                recycler.setAdapter(adapter);
            }
        });



    }
}
