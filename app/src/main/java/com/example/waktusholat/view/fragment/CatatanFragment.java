package com.example.waktusholat.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waktusholat.R;
import com.example.waktusholat.adapter.CatatanAdapter;
import com.example.waktusholat.alarm.AlarmActivity;
import com.example.waktusholat.entity.AppDatabase;
import com.example.waktusholat.entity.DataCatatan;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CatatanFragment extends Fragment {

    private RecyclerView recyclerView;
    private AppDatabase appDatabase;
    private EditText tittle, note;
    private Button btn_submit, btn_alarm;
    private View catatanlayout;


    public CatatanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catatan, container, false);

        tittle = view.findViewById(R.id.et_tittle);
        note = view.findViewById(R.id.et_note);
        btn_submit = view.findViewById(R.id.btn_submit);
        btn_alarm = view.findViewById(R.id.btn_alarm);
        recyclerView = view.findViewById(R.id.rc_fr_note);
        catatanlayout = view.findViewById(R.id.cv_item);

        appDatabase = AppDatabase.iniDb(view.getContext());

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String judul = tittle.getText().toString();
                String catatan = note.getText().toString();

                if (judul.equals("") || catatan.equals("")){
                    Toast.makeText(getContext(), "Harap isi semua data", Toast.LENGTH_SHORT).show();
                }else {
                    DataCatatan item = new DataCatatan();

                    item.setNote(catatan);
                    item.setTittle(judul);

                    appDatabase.dao().insertData(item);
                    Toast.makeText(getContext(), "Data insert", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlarmActivity.class);
                startActivity(intent);
            }
        });

        recyclerView.setHasFixedSize(true);
        List<DataCatatan> list = appDatabase.dao().getData();
        Log.d("Catatan Fragment" , "List Database : " + list.size());

        if(list.size() > 0){
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            CatatanAdapter catatanAdapter = new CatatanAdapter(list,getContext());
            recyclerView.setAdapter(catatanAdapter);
        }
        return view;

    }

}
