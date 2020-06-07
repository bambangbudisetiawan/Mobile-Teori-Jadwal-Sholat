package com.example.waktusholat.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.waktusholat.R;
import com.example.waktusholat.view.activity.MainActivity;
import com.example.waktusholat.view.activity.SplashActivity;

public class MainLoginActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        db = new DatabaseHelper(this);

        logout = (Button)findViewById(R.id.btn_logout);
        Boolean checkSession = db.checkSession("ada");
        if(checkSession == false){
            Intent loginIntent = new Intent(MainLoginActivity.this,LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }

        //logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updateSession = db.upgradeSession("kosong", 1);
                if (updateSession == true){
                    Toast.makeText(getApplicationContext(),"Berhasil Keluar",Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(MainLoginActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });
    }
}
