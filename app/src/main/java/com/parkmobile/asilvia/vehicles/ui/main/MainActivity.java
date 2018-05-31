package com.parkmobile.asilvia.vehicles.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.parkmobile.asilvia.vehicles.BR;
import com.parkmobile.asilvia.vehicles.R;
import com.parkmobile.asilvia.vehicles.databinding.ActivityMainBinding;
import com.parkmobile.asilvia.vehicles.ui.base.BaseActivity;
import com.parkmobile.asilvia.vehicles.ui.main.fragment.VehicleDetailsFragment;
import com.parkmobile.asilvia.vehicles.ui.main.fragment.VehicleListFragment;
import com.parkmobile.asilvia.vehicles.vo.Vehicle;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>  {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    ActivityMainBinding mActivityMainBinding;
    private MainViewModel mainViewModel;


    @Override
    public void onBackPressed() {
        mActivityMainBinding.toolbar.setTitle(getResources().getString(R.string.app_name));
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mainViewModel.getVehiclesList();


        if (savedInstanceState == null) {
            showListVehicles();
        }

    }

    private void showListVehicles() {

        VehicleListFragment fragment = new VehicleListFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment, VehicleListFragment.TAG).commit();
    }

    public void showVehicleInformation(String title) {
        mActivityMainBinding.toolbar.setTitle(title);

        VehicleDetailsFragment vehicleDetailsFragment = new VehicleDetailsFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(VehicleDetailsFragment.TAG)
                .replace(R.id.fragment_container,
                        vehicleDetailsFragment, null).commit();
    }




    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        return mainViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
