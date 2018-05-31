package com.parkmobile.asilvia.vehicles.ui.main.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.parkmobile.asilvia.vehicles.BR;
import com.parkmobile.asilvia.vehicles.R;
import com.parkmobile.asilvia.vehicles.databinding.FragmentVehicleListBinding;
import com.parkmobile.asilvia.vehicles.ui.base.BaseFragment;
import com.parkmobile.asilvia.vehicles.ui.main.MainActivity;
import com.parkmobile.asilvia.vehicles.ui.main.MainViewModel;
import com.parkmobile.asilvia.vehicles.ui.main.adapter.ItemClickListener;
import com.parkmobile.asilvia.vehicles.ui.main.adapter.RecyclerVehiclesAdapter;
import com.parkmobile.asilvia.vehicles.vo.Vehicle;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by asilvia on 31/05/2018.
 */

public class VehicleListFragment extends BaseFragment<FragmentVehicleListBinding, MainViewModel> implements ItemClickListener {
    public static final String TAG = "VehicleListFragment";
    private MainViewModel mainViewModel;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    FragmentVehicleListBinding fragmentVehicleListBinding;
    RecyclerVehiclesAdapter vehiclesAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentVehicleListBinding = getViewDataBinding();

        vehiclesAdapter = new RecyclerVehiclesAdapter();
        mainViewModel.setIsLoading(true);

        fragmentVehicleListBinding.vehiclesList.setHasFixedSize(true);
        fragmentVehicleListBinding.vehiclesList.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        fragmentVehicleListBinding.vehiclesList.setAdapter(vehiclesAdapter);

        mainViewModel.getmObservableVehicles().observe(getActivity(), new Observer<List<Vehicle>>() {
            @Override
            public void onChanged(@Nullable List<Vehicle> vehicles) {
                vehiclesAdapter.setListVehicles(vehicles);
                mainViewModel.setIsLoading(false);
            }
        });

        vehiclesAdapter.setClickListener(this);

    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_vehicle_list;
    }

    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(getActivity(), mViewModelFactory).get(MainViewModel.class);
        return mainViewModel;
    }


    @Override
    public void onClick(View view, int position) {
        Vehicle item = vehiclesAdapter.getItem(position);
        mainViewModel.select(item);
        ((MainActivity)getActivity()).showVehicleInformation(item.getVrn());
    }
}
