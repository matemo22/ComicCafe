package com.example.matemo.comiccafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Setting extends AppCompatActivity {
    TextView settingInformation, lastBackup;
    Button btnBackup, btnRestore, btnLoginSetting, btnLogoutSetting;
    DataBaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        dbHandler = new DataBaseHandler(this);
        settingInformation = findViewById(R.id.settingInformation);
        lastBackup = findViewById(R.id.lastBackup);
        btnBackup = findViewById(R.id.btnBackup);
        btnRestore = findViewById(R.id.btnRestore);
        btnLoginSetting = findViewById(R.id.btnLoginSetting);
        btnLogoutSetting = findViewById(R.id.btnLogoutSetting);

        if(dbHandler.getUser().size()!=0)
        {
            btnLoginSetting.setVisibility(View.INVISIBLE);
            btnLogoutSetting.setVisibility(View.VISIBLE);
            settingInformation.setVisibility(View.INVISIBLE);
            btnBackup.setEnabled(true);
            btnRestore.setEnabled(true);
        }

        btnLoginSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(Setting.this, LoginScreen.class);
                startActivity(loginIntent);
            }
        });

        btnLogoutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.deleteUser();
                Intent menuIntent = new Intent(Setting.this, MainActivity.class);
                startActivity(menuIntent);
                finish();
            }
        });

        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
