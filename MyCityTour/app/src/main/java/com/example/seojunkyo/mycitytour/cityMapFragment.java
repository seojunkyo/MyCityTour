package com.example.seojunkyo.mycitytour;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class cityMapFragment extends Fragment{
    private GoogleMap mGoogleMap;
    private SupportMapFragment fragment;

    LatLng loc = new LatLng(37.5306, 126.9653); // 위치 좌표 설정
    CameraPosition cp= new CameraPosition.Builder().target((loc)).zoom(16).build();
    MarkerOptions marker = new MarkerOptions().position(loc);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.city_map, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.fragment_map);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.fragment_map, fragment).commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mGoogleMap == null) {
            mGoogleMap = fragment.getMap();
            mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp)); // 지정위치로 이동
            mGoogleMap.addMarker(marker);
        }
    }
}