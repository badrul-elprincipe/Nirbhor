package com.badrul.user.bracexel;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewUserDataActivity extends AppCompatActivity {

    TextView nutitle;
    TextView naam;
    TextView yin;
    TextView ploan;
    TextView fmem;
    TextView ch;
    TextView crim;
    TextView pop;
    ListView newuserLv;
    Button bck;

    NewUserAdapter newUserAdapter;
    DatabaseReference newUserReference;
    static String dlt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_data);
        Intent intent=getIntent();

        naam=findViewById(R.id.name);
        yin=findViewById(R.id.yIncome);
        ploan=findViewById(R.id.plRecords);
        fmem=findViewById(R.id.fMember);
        ch=findViewById(R.id.character);
        crim=findViewById(R.id.crReport);
        pop=findViewById(R.id.poOpinion);
        nutitle=findViewById(R.id.txt);
        bck=findViewById(R.id.bt);

        newuserLv=findViewById(R.id.listView2);
        newUserAdapter=new NewUserAdapter(this);
        newuserLv.setAdapter(newUserAdapter);

        newUserReference= FirebaseDatabase.getInstance().getReference("newusers");

        newUserReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                newUserAdapter.list.clear();
                //list.clear();
                for (DataSnapshot d: dataSnapshot.getChildren()){
                    newUserAdapter.list.add(d.getValue(newusers.class));
                    newUserAdapter.notifyDataSetChanged();
                    //list.add(d.getValue(newusers.class).getCharacter());
                    //adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        newuserLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(NewUserDataActivity.this);
                builder.setMessage("Are You Want to Reject This Applicant ?");
                builder.setCancelable(false);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dlt=newUserAdapter.list.get(position).id;
                        newUserAdapter.list.remove(position);
                        newUserAdapter.notifyDataSetChanged();

                        delete(dlt);
                        Toast.makeText(getApplicationContext(),"Applicant Removed",Toast.LENGTH_LONG).show();


                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
                return true;


            }
        });


    }

    private void delete(String dlt) {
        DatabaseReference dUser= FirebaseDatabase.getInstance().getReference("newusers").child(dlt);
        dUser.removeValue();
    }

    public void backbbb(View view) {
        Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
        startActivity(intent);
        finish();
    }
}
