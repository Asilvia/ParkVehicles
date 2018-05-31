package com.parkmobile.asilvia.vehicles.api;

import android.arch.lifecycle.LiveData;

import com.parkmobile.asilvia.vehicles.vo.Vehicles;

import retrofit2.http.GET;

/**
 * Created by asilvia on 31/05/2018.
 * Perform api calls
 */

public interface MainApiHelper {

    @GET("vehicles")
    LiveData<ApiResponse<Vehicles>> getVehiclesInformation();



}
