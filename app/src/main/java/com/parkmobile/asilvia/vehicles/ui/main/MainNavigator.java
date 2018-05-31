package com.parkmobile.asilvia.vehicles.ui.main;

import android.arch.lifecycle.LiveData;

import com.parkmobile.asilvia.vehicles.vo.Vehicles;

/**
 * Created by asilvia on 31/05/2018.
 */

public interface MainNavigator {

    LiveData<Vehicles> getVehicles();
}
