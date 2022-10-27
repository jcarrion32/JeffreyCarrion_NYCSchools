package com.example.jeffreycarrion_nycschools.model.states;

import com.example.jeffreycarrion_nycschools.model.pojo.NYCSATResponse;

public class SuccessSATResponse extends UIState {
    private NYCSATResponse data;

    public NYCSATResponse getData() {
        return data;
    }

    public void setData(NYCSATResponse data) {
        this.data = data;
    }
}
