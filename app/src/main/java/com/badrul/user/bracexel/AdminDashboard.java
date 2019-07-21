package com.badrul.user.bracexel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {

    Button map;
    Button gouser;
    Button gonew;
    Button branchEv;
    Button poEv;
    Button ins;
    Button que;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        map=(Button)findViewById(R.id.map);
        gouser=findViewById(R.id.bt3);
        gonew=findViewById(R.id.bt4);
        branchEv=findViewById(R.id.bt5);
        poEv=findViewById(R.id.bt6);
        ins=findViewById(R.id.bt7);
        que=findViewById(R.id.bt8);






    }

    public void goMap(View view) {
        Intent myIntent=new Intent(AdminDashboard.this,Map.class);
        startActivity(myIntent);
    }

    public void goUser(View view) {
        Intent intent=new Intent(getApplicationContext(),UserDataActivity.class);
        startActivity(intent);

    }

    public void goNewUser(View view) {
        Intent intent=new Intent(getApplicationContext(),NewUserDataActivity.class);
        startActivity(intent);

    }

    public void branchGrowthGo(View view) {
        Intent intent=new Intent(getApplicationContext(),BranchGrowthActivity.class);
        startActivity(intent);
    }

    public void poEvaluateGo(View view) {
        Intent intent=new Intent(getApplicationContext(),PoEvaluationActivity.class);
        startActivity(intent);
    }

    public void predictInspectionGo(View view) {
        Intent intent=new Intent(getApplicationContext(),PredictInspectionActivity.class);
        startActivity(intent);
    }

    public void query(View view) {
        Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
        startActivity(intent);
    }
}
