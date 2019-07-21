package com.badrul.user.bracexel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TextView txt;

    private Button bt1, bt2, bt3;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference1;
    private List<userdata> usl=new ArrayList<>();
    private List<newuserdata>nusl=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt = (TextView) findViewById(R.id.textView);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);

        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        databaseReference1= FirebaseDatabase.getInstance().getReference("newusers");




        Log.d("myactivity","just created"+usl);




        bt2.setVisibility(View.INVISIBLE);
        bt3.setVisibility(View.INVISIBLE);

        try {
            readVOdata();
            readVOnew();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Log.d("myactivity","just created"+usl);
    }

    private void readVOnew() throws IOException {
        InputStream is= getResources().openRawResource(R.raw.vonew);
        BufferedReader br=new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line;
        br.readLine();
        while((line=br.readLine())!=null){
            String[] tok=line.split(",");
            nusl.add(new newuserdata(tok[0],Integer.parseInt(tok[1]),tok[2],Integer.parseInt(tok[3]),tok[4],tok[5],tok[6]));
        }

    }

    private void readVOdata() throws IOException {
        InputStream is= getResources().openRawResource(R.raw.vo1);
        BufferedReader br=new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line;
        br.readLine();
        while((line=br.readLine())!=null){
            String[] tok=line.split(",");
            usl.add(new userdata(tok[0],tok[1],tok[2],Integer.parseInt(tok[3]),Integer.parseInt(tok[4]),Integer.parseInt(tok[5]),Integer.parseInt(tok[6]),Double.parseDouble(tok[7]),tok[8],tok[9],tok[10],tok[11],tok[12],tok[13],tok[14],tok[15]));
        }



    }













    public void storeData(View view) {
        for (int i=0; i<usl.size();i++){
            String s= usl.get(i).getPon();
            String id=databaseReference.push().getKey();


            users ud=new users(id,s,usl.get(i).getVon(),usl.get(i).getName(),Integer.toString(usl.get(i).getBamount()),Integer.toString(usl.get(i).getCinstallment()),Integer.toString(usl.get(i).getOverdue()),Integer.toString(usl.get(i).getOutstanding()),Double.toString(usl.get(i).getRatio()),usl.get(i).getQcha(),usl.get(i).getQed(),usl.get(i).getqBP(),usl.get(i).getQsavings(),usl.get(i).getqDis(),usl.get(i).getqSan(),usl.get(i).getGrowth(),usl.get(i).getQuality());
            databaseReference.child(id).setValue(ud);


        }


        Toast.makeText(this,"Data Added",Toast.LENGTH_LONG).show();
        Vogichogi();





    }
    public void stroreNew(View view) {
        for (int i=0; i<nusl.size();i++){

            String id=databaseReference1.push().getKey();
            String yincome= Integer.toString(nusl.get(i).getYincome());
            String fmember= Integer.toString(nusl.get(i).getFmember());


            newusers ud=new newusers(id,nusl.get(i).getName(),yincome,nusl.get(i).getPloanrecord(),fmember,nusl.get(i).getCharacter(),nusl.get(i).getCriminalrec(),nusl.get(i).getPopinion());
            databaseReference1.child(id).setValue(ud);

        }


        Toast.makeText(this,"Data Added",Toast.LENGTH_LONG).show();
        Vogichogi1();
    }

    public void change(View view) {
        Vogichogi2();

    }


    public void Vogichogi() {
        bt2.setVisibility(View.VISIBLE);

        bt1.setVisibility(View.INVISIBLE);

        txt.setText("Hello");
    }

    public void Vogichogi1() {

        bt2.setVisibility(View.VISIBLE);
        bt1.setVisibility(View.INVISIBLE);
        txt.setText("Welcome to the Nirvor");
        bt3.setVisibility(View.VISIBLE);

    }


    public void Vogichogi2() {
        Intent myIntent = new Intent(MainActivity.this, SignUp.class);

        startActivity(myIntent);
        finish();
    }

}