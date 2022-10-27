package com.example.jeffreycarrion_nycschools.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jeffreycarrion_nycschools.R;
import com.example.jeffreycarrion_nycschools.model.pojo.NYCSchoolResponse;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder> {

    private final List<NYCSchoolResponse> dataSet;
    private final Listener.ListClickEvent clickEvent;

    public SchoolAdapter(List<NYCSchoolResponse> dataSet,
                         Listener.ListClickEvent clickEvent){
        this.dataSet = dataSet;
        this.clickEvent = clickEvent;
    }

    @NonNull
    @Override
    public SchoolAdapter.SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SchoolViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.school_layout_item,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolAdapter.SchoolViewHolder holder, int position) {

        holder.bind(
                dataSet.get(position),
                clickEvent
        );
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }

    public static class SchoolViewHolder extends RecyclerView.ViewHolder {

        private final TextView schoolName;

        public SchoolViewHolder(@NonNull View itemView) {
            super(itemView);
            schoolName = itemView.findViewById(R.id.school_item_school_name);
        }

        public void bind(NYCSchoolResponse dataItem, Listener.ListClickEvent clickEvent) {
            schoolName.setText(
                    dataItem.getSchool_name()
            );
            itemView.setOnClickListener(view->
                    clickEvent.clickDetails(dataItem.getDbn(), dataItem.getSchool_name(), dataItem.getLocation(), dataItem.getSchool_email(), dataItem.getPhone_number())
            );
        }
    }
}
