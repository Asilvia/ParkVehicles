package com.parkmobile.asilvia.vehicles.repository;

import android.arch.lifecycle.LiveData;


import com.parkmobile.asilvia.vehicles.api.ApiResponse;
import com.parkmobile.asilvia.vehicles.vo.Vehicles;

/**
 * Created by asilvia on 31/05/2018.
 */

public interface DataManager {
    LiveData<ApiResponse<Vehicles>> getVehicles();


}
