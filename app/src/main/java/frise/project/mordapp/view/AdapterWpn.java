package frise.project.mordapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;

public class AdapterWpn extends RecyclerView.Adapter {

    private List<Item> items;
    private Listener listener;

    public AdapterWpn(List<Item> items, Listener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull @Override
    public WpnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WpnViewHolder vh = new WpnViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.reycler_cell_weapon, parent, false));

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        WpnViewHolder vh = (WpnViewHolder) holder;
        vh.bind(items.get(position));
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(items.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class WpnViewHolder extends RecyclerView.ViewHolder {
        private static boolean shorthandHanded = true;

        ImageView img;
        TextView name, handed;

        public WpnViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cell_wpn_lbl_name);
            img = itemView.findViewById(R.id.cell_wpn_img_cost);
            handed = itemView.findViewById(R.id.cell_wpn_lbl_handed);
        }

        public void bind(Item item) {
            name.setText(item.getName());
            img.setImageResource(AdapterWpn.getCostImg(item.getCost()));
            if(shorthandHanded) handed.setText(item.getHandedShorthand());
            else handed.setText(item.getHanded());
        }
    }

    public interface Listener
    { void onClick(Item item); }

    public static final int getCostImg(int cost) {
        if(cost == 1) return R.drawable.thumbnail_cost_1;
        if(cost == 2) return R.drawable.thumbnail_cost_2;
        if(cost == 3) return R.drawable.thumbnail_cost_3;
        if(cost == 4) return R.drawable.thumbnail_cost_4;
        if(cost == 5) return R.drawable.thumbnail_cost_5;
        if(cost == 6) return R.drawable.thumbnail_cost_6;
        if(cost == 7) return R.drawable.thumbnail_cost_7;
        if(cost == 8) return R.drawable.thumbnail_cost_8; //there is no weapon that costs 9
        if(cost == 10) return R.drawable.thumbnail_cost_10; //so there is nowhere to get the thumbnail from
        if(cost == 11) return R.drawable.thumbnail_cost_11;

        return R.drawable.ic_launcher_background;
    }
}
