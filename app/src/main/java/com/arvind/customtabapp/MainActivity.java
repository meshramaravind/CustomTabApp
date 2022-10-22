package com.arvind.customtabapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.arvind.customtabapp.databinding.ActivityMainBinding;
import com.arvind.customtabapp.fragment.FragmentFour;
import com.arvind.customtabapp.fragment.FragmentOne;
import com.arvind.customtabapp.fragment.FragmentThree;
import com.arvind.customtabapp.fragment.FragmentTwo;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setLifecycleOwner(this);

        initialize();
        toolbarInitialize();
    }

    private void toolbarInitialize() {
        mBinding.toolbarTitle.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        mBinding.toolbarTitle.setNavigationOnClickListener(view -> finish());
    }

    private void initialize() {
        mBinding.viewPagerBusinessLoan.setAdapter(new ViewPagerFragmentAdapter(MainActivity.this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mBinding.tabLayoutBusinessLoan, mBinding.viewPagerBusinessLoan, (tab, position) -> {

            switch (position) {
                case 0: {
                    tab.setText("New Loan Application");
                    break;
                }

                case 1: {
                    tab.setText("How It Works");
                    break;
                }

                case 2: {
                    tab.setText("FAQ’s");
                    break;
                }
                case 3: {
                    tab.setText("Status Tracking");
                    break;
                }
            }
        });
        tabLayoutMediator.attach();
    }

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {

        public ViewPagerFragmentAdapter(MainActivity mainActivity) {
            super((FragmentActivity) mainActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new FragmentOne();
                case 1:
                    return new FragmentTwo();
                case 2:
                    return new FragmentThree();
                case 3:
                    return new FragmentFour();

            }
            return new FragmentOne();
        }

        @Override
        public int getItemCount() {
            return getResources().getStringArray(R.array.custom_tabs).length;
        }
    }
}