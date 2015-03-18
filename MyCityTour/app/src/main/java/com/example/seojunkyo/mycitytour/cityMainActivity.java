package com.example.seojunkyo.mycitytour;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v4.app.Fragment;
import android.widget.Button;


/**
 * Created by seojunkyo on 2015. 3. 17..
 */
public class cityMainActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_main);

    }

}
