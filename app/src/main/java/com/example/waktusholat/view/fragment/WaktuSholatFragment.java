package com.example.waktusholat.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waktusholat.R;
import com.example.waktusholat.adapter.WaktuSholatAdapter;
import com.example.waktusholat.viewmodel.WaktuSholatViewModel;
import com.example.waktusholat.waktusholat.DataItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class WaktuSholatFragment extends Fragment {

    private WaktuSholatAdapter waktuSholatAdapter;
    private RecyclerView rvWaktuSholatDiscover;
    private WaktuSholatViewModel waktuSholatViewModel;

    public WaktuSholatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_waktu_sholat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        waktuSholatAdapter = new WaktuSholatAdapter(getContext());
        waktuSholatAdapter.notifyDataSetChanged();

        rvWaktuSholatDiscover = view.findViewById(R.id.fragmentwaktusholatrv);
        //gambar tapi nggak kupake ?
        rvWaktuSholatDiscover.setLayoutManager(new GridLayoutManager(getContext(),1));

        waktuSholatViewModel = new ViewModelProvider(this).get(WaktuSholatViewModel.class);
        waktuSholatViewModel.setWaktuSholatDiscover();
        waktuSholatViewModel.getWaktuSholatDiscover().observe(this,getWaktuSholatDiscover);

        rvWaktuSholatDiscover.setAdapter(waktuSholatAdapter);
    }

    private Observer<ArrayList<DataItem>> getWaktuSholatDiscover = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if (dataItems != null){
                waktuSholatAdapter.setData(dataItems);
            }
        }
    };
}
