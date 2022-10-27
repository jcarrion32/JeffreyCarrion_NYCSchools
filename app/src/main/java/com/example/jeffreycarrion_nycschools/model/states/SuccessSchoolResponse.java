package com.example.jeffreycarrion_nycschools.model.states;

import com.example.jeffreycarrion_nycschools.model.pojo.NYCSchoolResponse;

import java.util.List;

public class SuccessSchoolResponse extends UIState{
    private List<NYCSchoolResponse> data;

    public List<NYCSchoolResponse> getData() {
        return data;
    }

    public void setData(List<NYCSchoolResponse> data) {
        this.data = data;
    }
}
