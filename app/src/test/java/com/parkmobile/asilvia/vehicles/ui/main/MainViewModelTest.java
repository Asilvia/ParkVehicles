package com.parkmobile.asilvia.vehicles.ui.main;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;

import com.parkmobile.asilvia.vehicles.api.ApiResponse;
import com.parkmobile.asilvia.vehicles.repository.DataManager;
import com.parkmobile.asilvia.vehicles.vo.Vehicle;
import com.parkmobile.asilvia.vehicles.vo.Vehicles;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import retrofit2.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by asilvia on 01/06/2018.
 */
@RunWith(JUnit4.class)
public class MainViewModelTest {

    @Rule

    public TestRule rule = new InstantTaskExecutorRule();

    private MainViewModel viewModel;
    private DataManager dataManager;

    @Before
    public void setUp() throws Exception {
        dataManager = mock(DataManager.class);
        viewModel = new MainViewModel(dataManager);
    }


    @Test
    public  void testNull() {
        assertThat(viewModel.getDataManager(), notNullValue());
        assertThat(viewModel.getSelected(), notNullValue());
    }

    @Test
    public void getSelectedTest()
    {
        Vehicle item = mock(Vehicle.class);
        item.setVehicleId(107623);
        item.setCountry("GB");
        item.setColor("Blue");
        item.setType("Truck");
        item.setDefault(true);

        Observer<Vehicle> observer = mock(Observer.class);
        viewModel.getSelected().observeForever(observer);

        viewModel.selected.postValue(item);

        verify(observer).onChanged(item);



    }



}