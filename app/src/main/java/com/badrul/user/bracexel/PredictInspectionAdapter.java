package com.badrul.user.bracexel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PredictInspectionAdapter extends BaseAdapter {

    ArrayList<users> list;
    Context c;
    static String s;
    static Double n;
    PredictInspectionAdapter(Context context){
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
        View row=layoutInflater.inflate(R.layout.predictinspection_ref,parent,false);


        TextView name= (TextView) row.findViewById(R.id.uName);

        TextView ba= (TextView) row.findViewById(R.id.poName);
        TextView ba1= (TextView) row.findViewById(R.id.growth);


        users tmp= list.get(position);




        name.setText(tmp.pon);
        ba.setText(tmp.growth);
        ba1.setText(tmp.quality);








        return row;


    }

}
