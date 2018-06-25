package com.fortests.meet7practicediff;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends android.support.v7.widget.RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Person> mPersonList;

    public MyAdapter(List<Person> personList) {
        mPersonList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = mPersonList.get(position).getName();
        holder.mNameTextView.setText(name);
        int age = mPersonList.get(position).getAge();
        holder.mAgeTextView.setText(String.valueOf(age));
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    public void setPersonList(List<Person> personList){

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mNameTextView;
        private TextView mAgeTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(R.id.name);
            mAgeTextView = (TextView) itemView.findViewById(R.id.age);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        if ((payloads.isEmpty())){
            super.onBindViewHolder(holder,position,payloads);
        } else {
            Bundle o = (Bundle) payloads.get(0);
            for (String key : o.keySet()){
                if (key.equals("name")){
                    String name1 = mPersonList.get(position).getName();
                    holder.mNameTextView.setText(name1);
                }
                if (key.equals("age")){
                    int age1 = mPersonList.get(position).getAge();
                    holder.mAgeTextView.setText(String.valueOf(age1));
                }
            }
        }
    }

    public void onNewData(List<Person> newData){
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffCall(newData,mPersonList));
        diffResult.dispatchUpdatesTo(this);
        mPersonList.clear();
        mPersonList.addAll(newData);
    }
}
