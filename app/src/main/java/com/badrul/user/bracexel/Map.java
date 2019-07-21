package com.badrul.user.bracexel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    public void back(View view) {
        Intent intent=new Intent(getApplicationContext(),AdminDashboard.class);
        startActivity(intent);
    }
}
