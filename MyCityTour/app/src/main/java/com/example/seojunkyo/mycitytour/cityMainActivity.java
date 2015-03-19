package com.example.seojunkyo.mycitytour;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by seojunkyo on 2015. 3. 17..
 */
public class cityMainActivity extends FragmentActivity{

    GoogleMap mGoogleMap;

    LatLng loc = new LatLng(37.5306, 126.9653); // 위치 좌표 설정
    CameraPosition cp= new CameraPosition.Builder().target((loc)).zoom(16).build();
    MarkerOptions marker = new MarkerOptions().position(loc);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_main);

        mGoogleMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_map)).getMap();
// 화면에 구글맵 표시
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp)); // 지정위치로 이동
        mGoogleMap.addMarker(marker); // 지정위치에 마커 추가
    }

    public void onClick(View view) {
        Fragment info_fr=new cityInfoFragment();
        FragmentTransaction info_ft = getFragmentManager().beginTransaction();

        Fragment map_fr = new cityMapFragment();
        FragmentTransaction map_ft = getFragmentManager().beginTransaction();


        if (view == findViewById(R.id.info_click)) {
            info_ft.add(R.id.tail_fragment, info_fr);
            info_ft.addToBackStack(null);
            info_ft.commit();

        } else if(view == findViewById(R.id.map_click)) {
            map_ft.add(R.id.tail_fragment, map_fr);
            info_ft.addToBackStack(null);
            map_ft.commit();
        }
    }
}
