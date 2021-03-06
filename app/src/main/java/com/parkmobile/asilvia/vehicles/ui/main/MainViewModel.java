package com.parkmobile.asilvia.vehicles.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;


import com.parkmobile.asilvia.vehicles.repository.DataManager;
import com.parkmobile.asilvia.vehicles.ui.base.BaseViewModel;
import com.parkmobile.asilvia.vehicles.util.AbsentLiveData;
import com.parkmobile.asilvia.vehicles.vo.Vehicle;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by asilvia on 31/05/2018.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {
    private final DataManager mDataManager;
    private LiveData<List<Vehicle>> mObservableVehicles;

    public final MutableLiveData<Vehicle> selected;



    public MainViewModel(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
        mObservableVehicles = AbsentLiveData.create();
        selected = new MutableLiveData<Vehicle>();
    }

    public LiveData<List<Vehicle>> getmObservableVehicles()
    {
        return mObservableVehicles;
    }

    void getVehiclesList()
    {

        mObservableVehicles = Transformations.switchMap(mDataManager.getVehicles(), vehicleResponse ->{
            MediatorLiveData<List<Vehicle>> listVehicles = new MediatorLiveData<>();

            if (vehicleResponse.isSuccessful())
            {
                listVehicles.postValue(vehicleResponse.body.getVehicles());
            }

            return listVehicles;
        });
    }




    public void select(Vehicle item) {
        selected.setValue(item);

    }

    public LiveData<Vehicle> getSelected() {
        return selected;
    }


}
