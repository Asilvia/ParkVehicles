package com.parkmobile.asilvia.vehicles.ui.main;

import android.arch.lifecycle.ViewModelProvider;


import com.parkmobile.asilvia.vehicles.repository.DataManager;
import com.parkmobile.asilvia.vehicles.util.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by asilvia on 31-05-2018.
 */


    @Module
    public class MainActivityModule {

        @Provides
        MainViewModel provideMainViewModel(DataManager dataManager) {
            return new MainViewModel(dataManager);
        }

        @Provides
        ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
            return new ViewModelProviderFactory<>(mainViewModel);
        }

    }
