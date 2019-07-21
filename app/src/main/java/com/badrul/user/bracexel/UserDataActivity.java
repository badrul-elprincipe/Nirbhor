package com.badrul.user.bracexel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserDataActivity extends AppCompatActivity {
    TextView title;
    TextView po;
    TextView vo;
    TextView name;
    TextView ba;
    TextView ci;
    TextView odue;
    TextView out;
    ListView listView;
    Button back;
    DataAdapter dataAdapter;
    DatabaseReference userDataReference;

    //ArrayList<String>list;
    //ArrayAdapter<String>adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        Intent intent=getIntent();

        po=findViewById(R.id.po);
        vo=findViewById(R.id.vo);
        name=findViewById(R.id.name);
        ba=findViewById(R.id.bAmount);
        ci=findViewById(R.id.cuInstallment);
        odue=findViewById(R.id.ovDue);
        out=findViewById(R.id.outstanding);
        title=findViewById(R.id.txt);
        back=findViewById(R.id.bt);

        listView=findViewById(R.id.listView);
        //list=new ArrayList<String>();
        //adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //listView.setAdapter(adapter);
        dataAdapter=new DataAdapter(this);
        listView.setAdapter(dataAdapter);

        userDataReference= FirebaseDatabase.getInstance().getReference("users");

        userDataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataAdapter.list.clear();
                //list.clear();
                for (DataSnapshot d: dataSnapshot.getChildren()){
                    dataAdapter.list.add(d.getValue(users.class));
                    dataAdapter.notifyDataSetChanged();
                    //list.add(d.getValue(newusers.class).getCharacter());
                    //adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }

    public void backcccc(View view) {
        Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
        startActivity(intent);
        finish();
    }
}
