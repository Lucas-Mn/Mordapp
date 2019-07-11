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

    public AdapterWpn(List<Item> items, Listener listener)
    {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
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

    public static class WpnViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name, handed;

        public WpnViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cell_wpn_lbl_name);
        }

        public void bind(Item item)
        {
            name.setText(item.getName());
        }
    }

    public interface Listener
    { void onClick(Item item); }
}
