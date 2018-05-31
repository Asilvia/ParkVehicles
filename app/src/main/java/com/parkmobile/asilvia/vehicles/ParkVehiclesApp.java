package com.parkmobile.asilvia.vehicles;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;


import com.parkmobile.asilvia.vehicles.di.component.DaggerMainComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;

/**
 * Created by asilvia on 31/05/2018.
 */

public class ParkVehiclesApp extends Application implements HasActivityInjector , HasSupportFragmentInjector{

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerMainComponent.builder().application(this).build().inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }



    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
