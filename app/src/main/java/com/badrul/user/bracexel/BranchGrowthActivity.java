package com.badrul.user.bracexel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BranchGrowthActivity extends AppCompatActivity {

    TextView bgtitle;
    TextView un;
    TextView vo;
    TextView gr;
    TextView rz;
    TextView grow;
    TextView rea;
    Button sog;
    Button sor;
    ListView growthList;
    Button bbk;
    static int sum;
    static int sumR;

    BranchGrowthAdapter branchGrowthAdapter;
    DatabaseReference branchReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_growth);
        Intent intent=getIntent();

        bgtitle=findViewById(R.id.bTxt);
        un=findViewById(R.id.bUsername);
        vo=findViewById(R.id.voName);
        gr=findViewById(R.id.growth);
        rz=findViewById(R.id.realization);
        grow=findViewById(R.id.sGrowthText);
        rea=findViewById(R.id.rText);
        sog=findViewById(R.id.sGrowth);
        sor=findViewById(R.id.sumRealization);
        bbk=findViewById(R.id.btBack);

        growthList=findViewById(R.id.brListView);
        branchGrowthAdapter=new BranchGrowthAdapter(this);
        growthList.setAdapter(branchGrowthAdapter);

        branchReference= FirebaseDatabase.getInstance().getReference("users");

        branchReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                branchGrowthAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    branchGrowthAdapter.list.add(d.getValue(users.class));
                    branchGrowthAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void growthCalc(View view) {
        calculateGrowth();
    }

    private void calculateGrowth() {
        sum= Integer.parseInt(branchGrowthAdapter.list.get(0).bamount);
        for (int i=1;i<branchGrowthAdapter.list.size();i++){
            sum = sum + Integer.parseInt(branchGrowthAdapter.list.get(i).bamount);

        }
        grow.setText(Integer.toString(sum));
    }

    public void realizationCalc(View view) {
        calculateRealization();
    }

    private void calculateRealization() {

        sumR= Integer.parseInt(branchGrowthAdapter.list.get(0).cinstallment);
        for (int i=1;i<branchGrowthAdapter.list.size();i++){
            sumR = sumR + Integer.parseInt(branchGrowthAdapter.list.get(i).cinstallment);

        }
        rea.setText(Integer.toString(sumR));
    }

    public void backb(View view) {
        Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
        startActivity(intent);
        finish();
    }
}
