package com.badrul.user.bracexel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PredictInspectionActivity extends AppCompatActivity {
    private Spinner spinner;
    ListView listView;
    List<String> list;

    TextView uName,voGrowth,poName,visitT;
    Button inspect;
    PredictInspectionAdapter predictInspectionAdapter;
    static String string;
    static String qua;
    static double comp;
    static String rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict_inspection);
        Intent intent=getIntent();


        uName=(TextView)findViewById(R.id.uName);
        voGrowth=(TextView)findViewById(R.id.voGrowth);
        poName=(TextView)findViewById(R.id.poName);
        visitT=findViewById(R.id.sGrowthText);

        inspect=(Button)findViewById(R.id.inspect);
        spinner=(Spinner)findViewById(R.id.spinner);
        listView=(ListView)findViewById(R.id.poListView);
        predictInspectionAdapter=new PredictInspectionAdapter(this);
        listView.setAdapter(predictInspectionAdapter);

        list=new ArrayList<String>();
        list.add("Select");
        list.add("VO1");
        list.add("VO2");
        list.add("VO3");
        list.add("VO4");
        list.add("VO5");



        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line
                ,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        visitT.setText("");

                        break;

                    case 1:
                        visitT.setText("");
                        string=list.get(1).trim();
                        predE1(string);

                        break;

                    case 2:
                        visitT.setText("");
                        string=list.get(2).trim();
                        predE2(string);

                        break;

                    case 3:
                        visitT.setText("");
                        string=list.get(3).trim();
                        predE3(string);

                        break;

                    case 4:
                        visitT.setText("");
                        string=list.get(4).trim();
                        predE4(string);

                        break;

                    case 5:
                        visitT.setText("");
                        string=list.get(5).trim();
                        predE5(string);

                        break;




                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    private void predE1(final String string) {
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                predictInspectionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    if (d.getValue(users.class).von.equals(string)){
                        predictInspectionAdapter.list.add(d.getValue(users.class));
                        predictInspectionAdapter.notifyDataSetChanged();

                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void predE2(final String string) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                predictInspectionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    if (d.getValue(users.class).von.equals(string)){
                        predictInspectionAdapter.list.add(d.getValue(users.class));
                        predictInspectionAdapter.notifyDataSetChanged();

                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void predE3(final String string) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                predictInspectionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    if (d.getValue(users.class).von.equals(string)){
                        predictInspectionAdapter.list.add(d.getValue(users.class));
                        predictInspectionAdapter.notifyDataSetChanged();

                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void predE4(final String string) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                predictInspectionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    if (d.getValue(users.class).von.equals(string)){
                        predictInspectionAdapter.list.add(d.getValue(users.class));
                        predictInspectionAdapter.notifyDataSetChanged();

                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void predE5(final String string) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                predictInspectionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    if (d.getValue(users.class).von.equals(string)){
                        predictInspectionAdapter.list.add(d.getValue(users.class));
                        predictInspectionAdapter.notifyDataSetChanged();

                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void inspect(View view) {
        visit();

    }

    private void visit() {
        comp = 10.0;
        if (predictInspectionAdapter.list.isEmpty()){
            visitT.setText("No Data");
        }
        else {
            for (int i=0;i<predictInspectionAdapter.list.size();i++){
                qua = predictInspectionAdapter.list.get(i).quality;
            }
            if (Double.parseDouble(qua)> 10.0){
                rep = "Need to visit area";
            }
            else {
                rep = "NO need to visit area";
            }
            visitT.setText(rep);

        }

    }
}
