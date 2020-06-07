package com.example.waktusholat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waktusholat.R;
import com.example.waktusholat.waktusholat.DataItem;

import java.util.ArrayList;

public class WaktuSholatAdapter extends RecyclerView.Adapter<WaktuSholatAdapter.ViewHolder> {

    private ArrayList<DataItem> dataItems = new ArrayList<>();

    private Context context;

    public WaktuSholatAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WaktuSholatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaktuSholatAdapter.ViewHolder holder, int position) {
        holder.tv_timezone.setText(dataItems.get(position).getMeta().getTimezone());
        holder.tv_subuh.setText(dataItems.get(position).getTimings().getFajr());
        holder.tv_dzuhur.setText(dataItems.get(position).getTimings().getDhuhr());
        holder.tv_ashar.setText(dataItems.get(position).getTimings().getAsr());
        holder.tv_maghrib.setText(dataItems.get(position).getTimings().getMaghrib());
        holder.tv_isya.setText(dataItems.get(position).getTimings().getIsha());
        holder.tv_readable.setText(dataItems.get(position).getDate().getReadable());
        holder.tv_hijriah.setText(dataItems.get(position).getDate().getHijri().getDate());
        holder.tv_majelis.setText(dataItems.get(position).getMeta().getMethod().getName());
        holder.tv_day.setText(dataItems.get(position).getDate().getHijri().getDay());
        holder.tv_bulan_hijriah.setText(dataItems.get(position).getDate().getHijri().getMonth().getAr());
        holder.tv_imsak.setText(dataItems.get(position).getTimings().getImsak());
        holder.tv_sunset.setText(dataItems.get(position).getTimings().getSunset());
        holder.tv_sunrise.setText(dataItems.get(position).getTimings().getSunrise());
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_timezone, tv_subuh, tv_dzuhur, tv_ashar, tv_maghrib, tv_isya, tv_readable;
        TextView tv_hijriah, tv_majelis,tv_day, tv_bulan_hijriah, tv_imsak, tv_sunrise, tv_sunset;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            tv_timezone = itemView.findViewById(R.id.tv_timezone);
            tv_subuh = itemView.findViewById(R.id.tv_subuh);
            tv_dzuhur = itemView.findViewById(R.id.tv_dzuhur);
            tv_ashar = itemView.findViewById(R.id.tv_ashar);
            tv_maghrib = itemView.findViewById(R.id.tv_maghrib);
            tv_isya = itemView.findViewById(R.id.tv_isya);
            tv_readable = itemView.findViewById(R.id.tv_readable);
            tv_hijriah = itemView.findViewById(R.id.tv_hijriah);
            tv_majelis = itemView.findViewById(R.id.tv_majelis);
            tv_day = itemView.findViewById(R.id.tv_day);
            tv_bulan_hijriah = itemView.findViewById(R.id.tv_bulan_hijriah);
            tv_imsak = itemView.findViewById(R.id.tv_imsak);
            tv_sunrise = itemView.findViewById(R.id.tv_sunrise);
            tv_sunset = itemView.findViewById(R.id.tv_sunset);
        }
    }
}
