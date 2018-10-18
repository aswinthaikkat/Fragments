package com.example.user.fragments;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{


    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();

    FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState==null){
            addCountriesFragment();
        }
    }

    private void addCountriesFragment(){

        fragmentTransaction=fragmentManager.beginTransaction();

        ListFragment countryListFragment=new ListFragment();
        countryListFragment.setFragmentActionListener(this);

        fragmentTransaction.add(R.id.frameHolder,countryListFragment);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(String countryName){
        fragmentTransaction=fragmentManager.beginTransaction();

        ListItemFragment countryDescriptionFragment=new ListItemFragment();

        Bundle bundle=new Bundle();
        bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY,countryName);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.frameHolder,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onCountrySelected(String country) {
        addCountryDescriptionFragment(country);
    }


}
