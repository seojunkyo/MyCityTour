package com.example.seojunkyo.mycitytour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by seojunkyo on 2015. 3. 16..
 */
public class loginActivity extends Activity {

    private Button placeBtn1;
    private Button placeBtn2;
    private Button placeBtn3;
    private Button placeBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeBtn1=(Button)findViewById(R.id.place1);
        placeBtn2=(Button)findViewById(R.id.place2);
        placeBtn3=(Button)findViewById(R.id.place3);
        placeBtn4=(Button)findViewById(R.id.place4);

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.place1:
                Intent plc1=new Intent(this, cityMainActivity.class);
                startActivity(plc1);
                break;
            case R.id.place2:
                Intent plc2=new Intent(this, cityMainActivity.class);
                startActivity(plc2);
                break;
            case R.id.place3:
                Intent plc3=new Intent(this, cityMainActivity.class);
                startActivity(plc3);
                break;
            case R.id.place4:
                Intent plc4=new Intent(this, cityMainActivity.class);
                startActivity(plc4);
                break;
        }
    }
}
