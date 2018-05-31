package com.parkmobile.asilvia.vehicles.ui.base;

import android.arch.lifecycle.ViewModel;

import com.parkmobile.asilvia.vehicles.repository.DataManager;

import android.databinding.ObservableBoolean;
/**
 * Created by asilvia on 31-05-2018.
 */

public abstract class BaseViewModel<N> extends ViewModel {
    private N mNavigator;
    private final DataManager mDataManager;
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    public BaseViewModel(DataManager dataManager) {
        this.mDataManager = dataManager;
    }


    public void onViewCreated() {

    }

    public void onDestroyView() {

    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }


    public N getNavigator() {
        return mNavigator;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

}
