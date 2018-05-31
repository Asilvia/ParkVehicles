package com.parkmobile.asilvia.vehicles.di.module;

import android.app.Application;
import android.content.Context;


import com.parkmobile.asilvia.vehicles.repository.AppDataManager;
import com.parkmobile.asilvia.vehicles.repository.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by asilvia on 31/05/2018.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

}
