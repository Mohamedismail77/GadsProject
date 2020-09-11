package com.ismail.gads.bindings;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.ismail.gads.Record;
import com.ismail.gads.RecordListAdapter;

import java.util.List;

public class RecycleViewBinding {

    @BindingAdapter(value = {"data"},requireAll = false)
    public static void listAdapter(RecyclerView recyclerView, LiveData<List<Record>> data){
        RecordListAdapter adapter = new RecordListAdapter();
        recyclerView.setAdapter(adapter);
        data.observeForever(new Observer<List<Record>>() {
            @Override
            public void onChanged(List<Record> recordList) {
                adapter.submitList(data.getValue());
            }
        });


    }

}
