package com.example.waktusholat.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waktusholat.R;
import com.example.waktusholat.entity.DataCatatan;

import java.util.List;

public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.viewHolder> {
    private Context context;
    //CatatanFragment fragment;
    List<DataCatatan> list;

    public CatatanAdapter(List<DataCatatan> list, Context context) {
        //public NoteAdapter(CatatanFragment fragment, List<DataCatatan> list, MainContract.view view){
        this.context = context;
        //this.fragment = fragment;
        this.list = list;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView tvTittle, tvNote, id;
        CardView cardView;

        public viewHolder(View itemView) {
            super(itemView);
            tvTittle = itemView.findViewById(R.id.tv_item_tittle);
            tvNote = itemView.findViewById(R.id.tv_item_note);
            id = itemView.findViewById(R.id.tv_item_id);
            cardView = itemView.findViewById(R.id.cv_item);
        }
    }

    @NonNull
    @Override
    public CatatanAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_catatan, parent, false);
        return new viewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final CatatanAdapter.viewHolder holder, int position) {
        final DataCatatan item = list.get(position);
        holder.tvTittle.setText(item.getTittle());
        holder.tvNote.setText(item.getNote());
        holder.id.setText(String.valueOf(item.getId()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
