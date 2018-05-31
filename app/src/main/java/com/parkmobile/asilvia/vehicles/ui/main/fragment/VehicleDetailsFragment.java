package com.parkmobile.asilvia.vehicles.ui.main.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.parkmobile.asilvia.vehicles.BR;
import com.parkmobile.asilvia.vehicles.R;
import com.parkmobile.asilvia.vehicles.databinding.FragmentVehicleDetailBinding;
import com.parkmobile.asilvia.vehicles.ui.base.BaseFragment;
import com.parkmobile.asilvia.vehicles.ui.main.MainViewModel;
import com.parkmobile.asilvia.vehicles.vo.Vehicle;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by asilvia on 31/05/2018.
 */

public class VehicleDetailsFragment extends BaseFragment<FragmentVehicleDetailBinding, MainViewModel> {
    private MainViewModel mainViewModel;
    public static final String TAG = "VehicleDetailsFragment";

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    FragmentVehicleDetailBinding fragmentVehicleDetailBinding;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentVehicleDetailBinding = getViewDataBinding();



        mainViewModel.getSelected().observe(getActivity(), new Observer<Vehicle>() {
            @Override
            public void onChanged(@Nullable Vehicle vehicle) {
               if(vehicle != null) {
                   setLayoutValues(vehicle);
               }
            }
        });
    }



    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_vehicle_detail;
    }

    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(getActivity(), mViewModelFactory).get(MainViewModel.class);
        return mainViewModel;
    }
    private void setLayoutValues(@Nullable Vehicle vehicle) {
        fragmentVehicleDetailBinding.tvColor.setText(vehicle.getColor());
        fragmentVehicleDetailBinding.tvVehicleId.setText(String.valueOf(vehicle.getVehicleId()));

        fragmentVehicleDetailBinding.tvCountry.setText(vehicle.getCountry());
        fragmentVehicleDetailBinding.tvType.setText(vehicle.getType());
        fragmentVehicleDetailBinding.tvDefault.setText(String.valueOf(vehicle.getDefault()));
    }
}
