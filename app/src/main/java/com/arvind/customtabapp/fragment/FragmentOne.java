package com.arvind.customtabapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.arvind.customtabapp.R;
import com.arvind.customtabapp.databinding.FragmentOneBinding;

public class FragmentOne extends Fragment {

    FragmentOneBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);
        binding.setLifecycleOwner(this);
        initialize();
        initClickListener();
        return binding.getRoot();
    }

    private void initialize() {


    }

    private void initClickListener() {


    }
}
