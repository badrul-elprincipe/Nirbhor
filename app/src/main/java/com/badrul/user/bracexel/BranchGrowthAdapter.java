package com.badrul.user.bracexel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BranchGrowthAdapter extends BaseAdapter {

    ArrayList<users> list;
    Context c;
    BranchGrowthAdapter(Context context){
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
        View row=layoutInflater.inflate(R.layout.branch_growth_ref,parent,false);
        TextView po= (TextView) row.findViewById(R.id.bUsername);
        TextView vo= (TextView) row.findViewById(R.id.voName);
        TextView name= (TextView) row.findViewById(R.id.growth);

        TextView ba= (TextView) row.findViewById(R.id.realization);


        users tmp= list.get(position);
        po.setText(tmp.name);
        vo.setText(tmp.von);

        name.setText(tmp.bamount);
        ba.setText(tmp.cinstallment);





        return row;


    }

}
