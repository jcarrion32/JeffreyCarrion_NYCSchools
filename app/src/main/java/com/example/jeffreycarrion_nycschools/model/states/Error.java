package com.example.jeffreycarrion_nycschools.model.states;

public class Error extends UIState{
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
