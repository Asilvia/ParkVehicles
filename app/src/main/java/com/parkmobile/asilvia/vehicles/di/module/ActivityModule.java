package com.parkmobile.asilvia.vehicles.di.module;


import com.parkmobile.asilvia.vehicles.ui.main.MainActivity;
import com.parkmobile.asilvia.vehicles.ui.main.MainActivityModule;
import com.parkmobile.asilvia.vehicles.ui.main.fragment.VehicleDetailsFragment;
import com.parkmobile.asilvia.vehicles.ui.main.fragment.VehicleListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by asilvia on 31/05/2018.
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract VehicleListFragment contributeVehicleListFragment();

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract VehicleDetailsFragment contributeVehicleDetailsFragment();
}
