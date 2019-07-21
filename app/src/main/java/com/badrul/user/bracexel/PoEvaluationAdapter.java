package com.badrul.user.bracexel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PoEvaluationAdapter extends BaseAdapter {

    ArrayList<users> list;
    Context c;
    static String s;
    static Double n;
    PoEvaluationAdapter(Context context){
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
        View row=layoutInflater.inflate(R.layout.po_evalution_ref,parent,false);

        TextView vo= (TextView) row.findViewById(R.id.uName);
        TextView name= (TextView) row.findViewById(R.id.poGrowth);

        TextView ba= (TextView) row.findViewById(R.id.ratio);


        users tmp= list.get(position);


        vo.setText(tmp.name);

        name.setText(tmp.bamount);
        ba.setText(tmp.ratio);








        return row;


    }

}
