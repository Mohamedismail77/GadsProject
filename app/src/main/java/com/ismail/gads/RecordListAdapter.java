package com.ismail.gads;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.ismail.gads.databinding.ListItemBinding;

public class RecordListAdapter extends ListAdapter<Record, RecordListAdapter.RecordViewHolder> {

    private static final String TAG = "RecordListAdapter";

    protected RecordListAdapter(@NonNull DiffUtil.ItemCallback<Record> diffCallback) {
        super(diffCallback);
    }

    public RecordListAdapter(){
        super(new DiffUtil.ItemCallback<Record>() {
            @Override
            public boolean areItemsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
                return false;
            }
        });
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecordViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        holder.listItemBinding.setRecord(getItem(position));
    }


    public String getTAG() {
        return TAG+ getItemCount();

    }

    public class RecordViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding listItemBinding;
        public RecordViewHolder(@NonNull ListItemBinding itemView) {
            super(itemView.getRoot());
            listItemBinding = itemView;
        }


    }


}
