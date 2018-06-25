package com.fortests.meet7practicediff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

public class DiffCall extends DiffUtil.Callback {
    private List<Person> mOldList;
    private List<Person> mNewList;

    public DiffCall(List<Person> oldList, List<Person> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).getId() == mNewList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Person newPerson = mNewList.get(newItemPosition);
        Person oldPerson = mOldList.get(oldItemPosition);
        Bundle diff = new Bundle();
        if (!newPerson.getName().equals(oldPerson.getName())){
            diff.putString("name",newPerson.getName());
        }
        if (!(newPerson.getId() == oldPerson.getId())){
            diff.putInt("id", newPerson.getId());
        }
        if (!(newPerson.getAge() == oldPerson.getAge())){
            diff.putInt("age", newPerson.getAge());
        }
        if (diff.size() == 0){
            return null;
        }
        return diff;
    }
}
