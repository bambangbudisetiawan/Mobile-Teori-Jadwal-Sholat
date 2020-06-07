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
import com.example.waktusholat.adapter.AsmaulHusnaAdapter;
import com.example.waktusholat.asmaulhusna.DataItem;
import com.example.waktusholat.viewmodel.AsmaulHusnaViewModel;
import com.example.waktusholat.viewmodel.WaktuSholatViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AsmaulHusnaFragment extends Fragment {

    private AsmaulHusnaAdapter asmaulHusnaAdapter;
    private RecyclerView rvAsmaulHusnaDiscover;
    private AsmaulHusnaViewModel asmaulHusnaViewModel;

    public AsmaulHusnaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asmaulhusna, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        asmaulHusnaAdapter = new AsmaulHusnaAdapter(getContext());
        asmaulHusnaAdapter.notifyDataSetChanged();

        rvAsmaulHusnaDiscover = view.findViewById(R.id.fragmentasmaulhusna);
        //gambar tapi nggak kupake ?
        rvAsmaulHusnaDiscover.setLayoutManager(new GridLayoutManager(getContext(),1));

        asmaulHusnaViewModel = new ViewModelProvider(this).get(AsmaulHusnaViewModel.class);
        asmaulHusnaViewModel.setAsmaulHusnaDiscover();
        asmaulHusnaViewModel.getAsmaulHusnaDiscover().observe(this,getAsmaulHusnaDiscover);

        rvAsmaulHusnaDiscover.setAdapter(asmaulHusnaAdapter);
    }

    private Observer<ArrayList<DataItem>> getAsmaulHusnaDiscover = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if (dataItems != null){
                asmaulHusnaAdapter.setData(dataItems);
            }
        }
    };
}
