package com.example.seojunkyo.mycitytour;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class cityHeadFragment extends Fragment{

    private Button headBt1,headBt2;
    private boolean isDone = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.city_head, container, false);
    }

    @Override
    public void onResume() {
        if(!isDone){
            headBt1 = (Button)this.getActivity().findViewById(R.id.map_click);
            headBt2 = (Button)this.getActivity().findViewById(R.id.info_click);
            // 버튼에 OnClickListener를 설정
            headBt1.setOnClickListener(onClickListener);
            headBt2.setOnClickListener(onClickListener);
            isDone = true;
        }
        super.onResume();
    }

    // Activity 로 데이터를 전달할 커스텀 리스너
    private CustomOnClickListener customListener;

    // Activity 로 데이터를 전달할 커스텀 리스너의 인터페이스
    public interface CustomOnClickListener{
        public void onClicked(int id);
    }

    // 버튼에 설정한 OnClickListener의 구현, 버튼이 클릭 될 때마다 Activity의 커스텀 리스너를 호출함
    OnClickListener onClickListener = new OnClickListener(){

        @Override
        public void onClick(View v) {
            customListener.onClicked(v.getId());
        }
    };

    // Activity 로 데이터를 전달할 커스텀 리스너를 연결
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        customListener = (CustomOnClickListener)activity;
    }
}
