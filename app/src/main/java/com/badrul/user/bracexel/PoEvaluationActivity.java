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

public class PoEvaluationActivity extends AppCompatActivity {

    private Spinner spinner;
    ListView poEvList;
    List<String> list;
    String str;
    TextView uName,poGrowth,sGrowthText;
    Button aRatio;
    static String string;
    PoEvaluationAdapter poEvaluationAdapter;
    static int growth;
    static double avgGrowth;
    static double ratio;
    static double avgDouble;
    static String gr;
    static String rat;
    static double calc;
    static int counter;
    static int showEval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po_evaluation);
        Intent intent=getIntent();


        uName=(TextView)findViewById(R.id.uName);
        poGrowth=(TextView)findViewById(R.id.poGrowth);
        sGrowthText=(TextView)findViewById(R.id.sGrowthText);
        aRatio=(Button)findViewById(R.id.aRatio);
        spinner=(Spinner)findViewById(R.id.spinner);
        poEvList=(ListView)findViewById(R.id.poListView);

        poEvaluationAdapter=new PoEvaluationAdapter(this);
        poEvList.setAdapter(poEvaluationAdapter);

        list=new ArrayList<String>();
        list.add("Select");
        list.add("PO1");
        list.add("PO2");
        list.add("PO3");

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
                        sGrowthText.setText("");
                        //evalauator();


                        break;

                    case 1:

                        sGrowthText.setText("");

                        string=list.get(1).toString().trim();
                        pocE1(string);

                        //evalauator();
                        break;

                    case 2:

                        sGrowthText.setText("");

                        string=list.get(2).toString().trim();
                        pocE2(string);
                        //evalauator();

                        break;

                    case 3:
                        sGrowthText.setText("");

                        string=list.get(3).toString().trim();
                        pocE3(string);
                        //evalauator();

                        break;



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    private void pocE3(final String string) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                poEvaluationAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    if (d.getValue(users.class).pon.equals(string)){
                        poEvaluationAdapter.list.add(d.getValue(users.class));
                        poEvaluationAdapter.notifyDataSetChanged();

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void pocE2(final String string) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                poEvaluationAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    if (d.getValue(users.class).pon.equals(string)){
                        poEvaluationAdapter.list.add(d.getValue(users.class));
                        poEvaluationAdapter.notifyDataSetChanged();

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void pocE1(final String string) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                poEvaluationAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){
                    if (d.getValue(users.class).pon.equals(string)){
                        poEvaluationAdapter.list.add(d.getValue(users.class));
                        poEvaluationAdapter.notifyDataSetChanged();

                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void reportPO(View view) {
        evalauator();

    }

    private void evalauator() {





        if (poEvaluationAdapter.list.isEmpty()){
            sGrowthText.setText("No Data Found");


        }
        else{
            growth=0;

            ratio=0.0;
            avgDouble=0.0;
            calc=0.0;
            counter =0;
            gr="";
            rat="";

            for(int i=0;i<poEvaluationAdapter.list.size();i++){
                //counter=counter+1;
                gr=poEvaluationAdapter.list.get(i).growth;
                rat=poEvaluationAdapter.list.get(i).quality;






            }
            showEval=200000;

            //avgDouble=ratio/counter*100;
            //gr=Integer.toString(growth-showEval);
            //rat=Double.toString(avgDouble);
            sGrowthText.setText("Last Month Loan: "+showEval+"\n"+"Total Growth: "+gr+"\n"+"Quality: "+rat);

        }

    }
}
