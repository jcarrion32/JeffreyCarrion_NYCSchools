package com.example.jeffreycarrion_nycschools.model.repo;

import com.example.jeffreycarrion_nycschools.model.network.Network;
import com.example.jeffreycarrion_nycschools.model.pojo.NYCSATResponse;
import com.example.jeffreycarrion_nycschools.model.states.SuccessSATResponse;
import com.example.jeffreycarrion_nycschools.model.states.SuccessSchoolResponse;
import com.example.jeffreycarrion_nycschools.model.states.UIState;

import io.reactivex.rxjava3.core.Single;

public class RepoImpl implements Repo {
    private Network network;

    public RepoImpl(Network network){
        this.network = network;
    }

    @Override
    public Single<UIState> getSchoolList() {
        return network.getSERVICE().getSchoolList()
                .map(nycSchoolResponses -> {
                    SuccessSchoolResponse result = new SuccessSchoolResponse();
                    result.setData(nycSchoolResponses);
                    return result;
                });
    }

    @Override
    public Single<UIState> getSchoolDetails(String dbn) {
        return network.getSERVICE().getSatList()
                .map(nycSchoolSats -> {
                    NYCSATResponse satSchool = new NYCSATResponse();
                    for (NYCSATResponse sat :
                            nycSchoolSats) {
                        if (sat.getDbn().equals(dbn))
                            satSchool = sat;
                    }
                    SuccessSATResponse result = new SuccessSATResponse();
                    result.setData(satSchool);
                    return result;
                });
    }
}
