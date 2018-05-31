package com.parkmobile.asilvia.vehicles.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parkmobile.asilvia.vehicles.R;
import com.parkmobile.asilvia.vehicles.vo.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asilvia on 31/05/2018.
 */

public class RecyclerVehiclesAdapter extends RecyclerView.Adapter<RecyclerVehiclesAdapter.ViewHolder> {

    private List<Vehicle> listVehicles;
    private ItemClickListener clickListener;

    public RecyclerVehiclesAdapter() {
        this.listVehicles = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Vehicle item = listVehicles.get(position);
        holder.vehicle_name.setText(item.getVrn());
    }

    @Override
    public int getItemCount() {
        return listVehicles.size();
    }

    public Vehicle getItem(int position)
    {
        return this.listVehicles.get(position);
    }

    public void setListVehicles(List<Vehicle> list)
    {
        this.listVehicles = new ArrayList<>();
        this.listVehicles.addAll(list);
        notifyDataSetChanged();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView vehicle_name;

        private ViewHolder(View itemView) {
            super(itemView);
            vehicle_name =(TextView) itemView.findViewById(R.id.vehicle_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
