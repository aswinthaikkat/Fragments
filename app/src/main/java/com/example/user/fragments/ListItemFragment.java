package com.example.user.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListItemFragment extends android.support.v4.app.Fragment {


    View rootView;
    TextView textViewCountryDescription;


    String countryName;
    String countryDescription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_item,container,false);
        initUI();
        return rootView;
    }

    private void initUI(){
        textViewCountryDescription = (TextView)rootView.findViewById(R.id.textViewCountryDescription);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        countryName = bundle.getString(FragmentActionListener.KEY_SELECTED_COUNTRY,"India");
        countryDescription = getString(getStringId(countryName));

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(countryName);
        textViewCountryDescription.setText(countryDescription);
    }

    private int getStringId(String countryName){
        if(countryName.equals("India")){
            return R.string.India;
        }else if(countryName.equals("USA")){
            return R.string.USA;
        }else if(countryName.equals("Pakistan")){
            return R.string.Pakistan;
        }else if(countryName.equals("Bangladesh")){
            return R.string.Bangladesh;
        }else if(countryName.equals("Egypt")){
            return R.string.Egypt;
        }else if(countryName.equals("Indonesia")){
            return R.string.Indonesia;
        }else if(countryName.equals("UK")){
            return R.string.UK;
        }else if(countryName.equals("Germany")){
            return R.string.Germany;
        }else {
            return R.string.India;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
