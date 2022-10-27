package com.example.jeffreycarrion_nycschools.model.repo;

import com.example.jeffreycarrion_nycschools.model.states.UIState;

import io.reactivex.rxjava3.core.Single;

public interface Repo {
    Single<UIState> getSchoolList();
    Single<UIState> getSchoolDetails(String dbn);
}
