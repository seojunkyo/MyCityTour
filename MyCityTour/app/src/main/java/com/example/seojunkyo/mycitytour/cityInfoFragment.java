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
import android.widget.Toast;


/**
 * Created by seojunkyo on 2015. 3. 18..
 */
public class cityInfoFragment  extends Fragment implements OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.city_info, container, false);

        Button button = (Button) v.findViewById(R.id.info_click);
        button.setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.info_click:
                Toast.makeText(getActivity(), "TwoFragment", Toast.LENGTH_SHORT)
                        .show();
                break;

        }

    }
}
