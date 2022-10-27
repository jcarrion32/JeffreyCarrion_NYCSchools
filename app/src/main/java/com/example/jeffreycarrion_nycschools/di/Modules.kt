package com.example.jeffreycarrion_nycschools.di

import com.example.jeffreycarrion_nycschools.model.network.Network
import com.example.jeffreycarrion_nycschools.model.repo.Repo
import com.example.jeffreycarrion_nycschools.model.repo.RepoImpl
import com.example.jeffreycarrion_nycschools.view.viewmodel.SchoolViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RepoModule {
    @Singleton
    @Provides
    fun providesRepository(): Repo {
        return RepoImpl(Network.getInstance())
    }
}

@InstallIn(ActivityComponent::class)
@Module
object ViewModelModule{
    @Provides
    fun providesVM(repository: Repo): SchoolViewModelProvider {
        return SchoolViewModelProvider(repository)
    }
}