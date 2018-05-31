package com.parkmobile.asilvia.vehicles.repository;

import android.arch.lifecycle.LiveData;

import com.parkmobile.asilvia.vehicles.api.ApiResponse;
import com.parkmobile.asilvia.vehicles.api.MainApiHelper;
import com.parkmobile.asilvia.vehicles.vo.Vehicles;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by asilvia on 18/05/2018.
 */

public class AppDataManager implements DataManager {

    private MainApiHelper mMainApiHelper;



    @Inject
    public AppDataManager(MainApiHelper mainApiHelper) {
        this.mMainApiHelper = mainApiHelper;
    }


    @Override
    public LiveData<ApiResponse<Vehicles>> getVehicles() {
        return mMainApiHelper.getVehiclesInformation();
    }
}
