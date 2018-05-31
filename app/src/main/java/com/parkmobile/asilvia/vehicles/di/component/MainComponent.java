package com.parkmobile.asilvia.vehicles.di.component;

import android.app.Application;


import com.parkmobile.asilvia.vehicles.ParkVehiclesApp;
import com.parkmobile.asilvia.vehicles.di.module.ActivityModule;
import com.parkmobile.asilvia.vehicles.di.module.AppModule;
import com.parkmobile.asilvia.vehicles.di.module.NetModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by asilvia on 31/05/2018.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,  NetModule.class, AppModule.class, ActivityModule.class})
public interface MainComponent
{
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);


        MainComponent build();
    }
    void inject(ParkVehiclesApp app);
}
