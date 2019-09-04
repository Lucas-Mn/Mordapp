package frise.project.mordapp.view;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import frise.project.mordapp.R;
import frise.project.mordapp.model.Item;
import frise.project.mordapp.retrofit.HELPER;

public class AdapterWpn extends RecyclerView.Adapter implements Filterable {

    private List<Item> items, all_items, original_order_items;
    private Listener listener;

    private CharSequence filter = "";

    public AdapterWpn(List<Item> items, Listener listener) {
        this.all_items = items;
        this.items = items;
        this.original_order_items = items;
        this.listener = listener;
    }

    public void setItems(List<Item> items) {
        this.all_items = items;
        this.items = items;
        this.original_order_items = items;
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

    @Override
    public Filter getFilter(){
        return new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                filter = charSequence;
                items = new ArrayList<>();
                for(Item item : all_items)
                    if(item.getName().toLowerCase().contains(charSequence))
                        items.add(item);
                FilterResults results = new FilterResults();
                results.values = items;
                return results; }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                items = (List<Item>) filterResults.values;
                notifyDataSetChanged(); } };
    }

    //region orders
    public void orderRegular(){
        all_items = original_order_items;
    }

    public void orderDamage(final Item.ARMOUR_PIECE armour_piece, final int armour_level, boolean ascending) {
        Comparator<Item> comparator =
                (Item item, Item t1) -> item.getHtk(armour_piece, armour_level).compareTo(t1.getHtk(armour_piece, armour_level));
        if(!ascending)
            if(Build.VERSION.SDK_INT >= 24) //minimum SDK for comparator.reversed()
                Collections.sort(all_items, comparator.reversed());
            else{
                List<Item> unreversed_list = new ArrayList<>(original_order_items);
                Collections.sort(unreversed_list, comparator);
                List<Item> reversed_list = new ArrayList<>();
                for(int i = unreversed_list.size() - 1; i >= 0; ++i)
                    reversed_list.add(unreversed_list.get(i)); }
        else
            Collections.sort(all_items, comparator);
        notifyDataSetChanged();
        Log.d(HELPER.DEBUG, "Ordered weapon list by " + armour_piece.toString() + " - " + armour_level + (ascending ? " ascending order" : " descending order")); }

    //endregion

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

    public interface Listener {
        void onClick(Item item); }

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
