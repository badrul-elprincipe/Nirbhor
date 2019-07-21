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

public class QuestionActivity extends AppCompatActivity {
    private Spinner spinner;
    private ListView listView;
    List<String> list;

    TextView uName,po,answer,insText;
    Button datapass;
    QuestionAdapter questionAdapter;
    static String string;
    static int n;
    static int yescounter;
    static int nocounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Intent intent=getIntent();

        uName=(TextView)findViewById(R.id.uName);
        po=(TextView)findViewById(R.id.pName);

        answer=(TextView) findViewById(R.id.answer);
        insText=findViewById(R.id.sGrowthText);
        datapass=findViewById(R.id.inspect);

        spinner=(Spinner)findViewById(R.id.spinner);
        listView=(ListView)findViewById(R.id.poListView);
        questionAdapter=new QuestionAdapter(this);
        listView.setAdapter(questionAdapter);

        list=new ArrayList<String>();
        list.add("select");
        list.add("Loan Pressure");
        list.add("Education");
        list.add("Brac Program");
        list.add("savings");

        list.add("Disability");
        list.add("Sanitation");

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
                        insText.setText("");

                        break;

                    case 1:
                        insText.setText("");
                        n=1;
                        string=list.get(1).trim();
                        predE1(string);

                        break;

                    case 2:
                        insText.setText("");
                        n=2;
                        string=list.get(1).trim();
                        predE2(string);

                        break;

                    case 3:
                        insText.setText("");
                        n=3;
                        string=list.get(1).trim();
                        predE3(string);

                        break;


                    case 4:
                        insText.setText("");
                        n=4;
                        string=list.get(1).trim();
                        predE4(string);

                        break;

                    case 5:
                        insText.setText("");
                        n=5;
                        string=list.get(1).trim();
                        predE5(string);

                        break;

                    case 6:
                        insText.setText("");
                        n=6;
                        string=list.get(1).trim();
                        predE6(string);

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
                questionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){

                        questionAdapter.list.add(d.getValue(users.class));
                        questionAdapter.notifyDataSetChanged();




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
                questionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){

                        questionAdapter.list.add(d.getValue(users.class));
                        questionAdapter.notifyDataSetChanged();




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
                questionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){

                        questionAdapter.list.add(d.getValue(users.class));
                        questionAdapter.notifyDataSetChanged();




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
                questionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){

                        questionAdapter.list.add(d.getValue(users.class));
                        questionAdapter.notifyDataSetChanged();




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
                questionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){

                        questionAdapter.list.add(d.getValue(users.class));
                        questionAdapter.notifyDataSetChanged();




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void predE6(final String string) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionAdapter.list.clear();

                for (DataSnapshot d: dataSnapshot.getChildren()){

                        questionAdapter.list.add(d.getValue(users.class));
                        questionAdapter.notifyDataSetChanged();




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void inspect(View view) {
        analyze();
    }

    private void analyze() {
        yescounter=0;
        nocounter=0;
        if(questionAdapter.list.isEmpty()){
            insText.setText("No Data Found");
        }
        else {
            for (int i=0;i<questionAdapter.list.size();i++){
                if(n==1){
                    if(questionAdapter.list.get(i).qcha.equals("Yes")){
                        yescounter=yescounter+1;
                    }
                    else {
                        nocounter=nocounter+1;
                    }
                }
                if(n==2){
                    if(questionAdapter.list.get(i).qed.equals("Yes")){
                        yescounter=yescounter+1;
                    }
                    else {
                        nocounter=nocounter+1;
                    }
                }
                if(n==3){
                    if(questionAdapter.list.get(i).qBP.equals("Yes")){
                        yescounter=yescounter+1;
                    }
                    else {
                        nocounter=nocounter+1;
                    }
                }
                if(n==4){
                    if(questionAdapter.list.get(i).qsavings.equals("Yes")){
                        yescounter=yescounter+1;
                    }
                    else {
                        nocounter=nocounter+1;
                    }
                }
                if(n==5){
                    if(questionAdapter.list.get(i).qDis.equals("Yes")){
                        yescounter=yescounter+1;
                    }
                    else {
                        nocounter=nocounter+1;
                    }
                }
                if(n==6){
                    if(questionAdapter.list.get(i).qSan.equals("Yes")){
                        yescounter=yescounter+1;
                    }
                    else {
                        nocounter=nocounter+1;
                    }
                }
            }
            if(nocounter > yescounter){
                insText.setText("Ratio is below 50% you should contact correspondent authority");
            }
            else {
                insText.setText("Ratio is at satisfactory level");
            }
        }
    }
}
