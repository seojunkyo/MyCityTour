package com.example.seojunkyo.mycitytour;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.*;
import android.app.Fragment;



/**
 * Created by seojunkyo on 2015. 3. 17..
 */
public class cityMainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_main);
    }

    public void onClicked(int id) {
        cityBottomFragment tailFragment = (cityBottomFragment)getFragmentManager().findFragmentById(R.id.tail_fragment);
        switch(id){
            case R.id.map_click:
                break;
            case R.id.info_click:
                break;
        }
    }
}
