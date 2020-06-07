package com.example.waktusholat.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.waktusholat.R;
import com.example.waktusholat.view.fragment.AlquranFragment;
import com.example.waktusholat.view.fragment.CatatanFragment;
import com.example.waktusholat.view.fragment.AsmaulHusnaFragment;
import com.example.waktusholat.view.fragment.WaktuSholatFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new WaktuSholatFragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_bottomnav_waktusholat:
                selectedFragment = new WaktuSholatFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottomnav_catatan:
                selectedFragment = new CatatanFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottomnav_tanggal:
                selectedFragment = new AsmaulHusnaFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottomnav_alquran:
                selectedFragment = new AlquranFragment();
                loadFragment(selectedFragment);
                break;
        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_fragment,selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
