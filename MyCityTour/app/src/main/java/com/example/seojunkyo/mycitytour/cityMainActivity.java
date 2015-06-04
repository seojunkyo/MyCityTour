package com.example.seojunkyo.mycitytour;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by seojunkyo on 2015. 3. 17..
 */
public class cityMainActivity extends FragmentActivity implements View.OnClickListener{

    final String TAG = "MainActivity";

    int mCurrentFragmentIndex;
    public final static int FRAGMENT_ONE = 0;
    public final static int FRAGMENT_TWO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_main);

        Button bt_oneFragment = (Button) findViewById(R.id.map_click);
        bt_oneFragment.setOnClickListener(this);
        Button bt_twoFragment = (Button) findViewById(R.id.info_click);
        bt_twoFragment.setOnClickListener(this);

        mCurrentFragmentIndex = FRAGMENT_ONE;

        fragmentReplace(mCurrentFragmentIndex);
    }

    public void fragmentReplace(int reqNewFragmentIndex) {

        Fragment newFragment = null;
        Log.d(TAG, "fragmentReplace " + reqNewFragmentIndex);
        newFragment = getFragment(reqNewFragmentIndex);

        // replace fragment
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.tail_fragment, newFragment);

        // Commit the transaction
        transaction.commit();

    }
    private Fragment getFragment(int idx) {
        Fragment newFragment = null;

        switch (idx) {
            case FRAGMENT_ONE:
                newFragment = new cityMapFragment();
                break;
            case FRAGMENT_TWO:
                newFragment = new cityInfoFragment();
                break;
            default:
                Log.d(TAG, "Unhandle case");
                break;
        }
        return newFragment;
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.map_click:
                mCurrentFragmentIndex = FRAGMENT_ONE;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.info_click:
                mCurrentFragmentIndex = FRAGMENT_TWO;
                fragmentReplace(mCurrentFragmentIndex);
                break;
        }
    }
}
