package com.example.jeffreycarrion_nycschools.view.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.jeffreycarrion_nycschools.model.repo.Repo;

import javax.inject.Inject;

public class SchoolViewModelProvider implements ViewModelProvider.Factory {
    private Repo repository;

    @Inject
    public SchoolViewModelProvider(Repo repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SchoolViewModel(repository);
    }
}
