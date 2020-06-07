package com.example.waktusholat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waktusholat.R;
import com.example.waktusholat.asmaulhusna.DataItem;

import java.util.ArrayList;

public class AsmaulHusnaAdapter extends RecyclerView.Adapter<AsmaulHusnaAdapter.ViewHolder> {

    private ArrayList<DataItem> dataItems = new ArrayList<>();

    private Context context;

    public AsmaulHusnaAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AsmaulHusnaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_asmaulhusna,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_asmaulhusna.setText(dataItems.get(position).getName());
        holder.tv_arti.setText(dataItems.get(position).getTransliteration());
        holder.tv_meaning.setText(dataItems.get(position).getEn().getMeaning());
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_asmaulhusna,tv_arti,tv_meaning;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_asmaulhusna = itemView.findViewById(R.id.tv_asmaulhusna);
            tv_arti = itemView.findViewById(R.id.tv_arti);
            tv_meaning = itemView.findViewById(R.id.tv_meaning);
        }
    }
}
