package com.badrul.user.bracexel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter {

    ArrayList<users> list;
    Context c;
    DataAdapter(Context context){
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
        View row=layoutInflater.inflate(R.layout.user_ref,parent,false);
        TextView po= (TextView) row.findViewById(R.id.po);
        TextView vo= (TextView) row.findViewById(R.id.vo);
        TextView name= (TextView) row.findViewById(R.id.name);

        TextView ba= (TextView) row.findViewById(R.id.bAmount);
        TextView ci= (TextView) row.findViewById(R.id.cuInstallment);
        TextView od= (TextView) row.findViewById(R.id.ovDue);
        TextView out= (TextView) row.findViewById(R.id.outstanding);

        users tmp= list.get(position);
        po.setText(tmp.pon);
        vo.setText(tmp.von);

        name.setText(tmp.name);
        ba.setText(tmp.bamount);
        ci.setText(tmp.cinstallment);
        od.setText(tmp.overdue);
        out.setText(tmp.outstanding);




        return row;


    }

}
