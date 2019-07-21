package com.badrul.user.bracexel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionAdapter extends BaseAdapter {

    ArrayList<users> list;
    Context c;
    static String s;
    static Double n;
    QuestionAdapter(Context context){
        c=context;
        list=new ArrayList<users>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.question_ref,parent,false);


        TextView name= (TextView) row.findViewById(R.id.uName);

        TextView ba= (TextView) row.findViewById(R.id.po);
        TextView ba1= (TextView) row.findViewById(R.id.answer);



        users tmp= list.get(position);




        name.setText(tmp.name);
        ba.setText(tmp.pon);


        if (QuestionActivity.n==1){
            ba1.setText(tmp.qcha);

        }
        if (QuestionActivity.n==2){
            ba1.setText(tmp.qed);

        }
        if (QuestionActivity.n==3){
            ba1.setText(tmp.qBP);

        }
        if (QuestionActivity.n==4){
            ba1.setText(tmp.qsavings);

        }
        if (QuestionActivity.n==5){
            ba1.setText(tmp.qDis);

        }
        if (QuestionActivity.n==6){
            ba1.setText(tmp.qSan);

        }












        return row;


    }

}
