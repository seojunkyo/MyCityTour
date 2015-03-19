package com.example.seojunkyo.mycitytour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Fragment;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by seojunkyo on 2015. 3. 18..
 */
public class cityInfoFragment  extends Fragment{

    View view;
    WebView infoWeb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.city_info, container, false);

        if ("http://m.daum.net" != null) {
            infoWeb = (WebView) view.findViewById(R.id.fragment_web);
            infoWeb.getSettings().setJavaScriptEnabled(true);
            infoWeb.setWebViewClient(new webClient());
            infoWeb.loadUrl("http://m.daum.net");
        }
        return view;
    }

    private class webClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
}
