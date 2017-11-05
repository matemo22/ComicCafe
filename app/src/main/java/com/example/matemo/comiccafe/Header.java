package com.example.matemo.comiccafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Header extends AppCompatActivity {

    TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        userEmail = findViewById(R.id.userEmail);

        userEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Sent Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
