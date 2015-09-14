package com.hp.fucktesting;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.HashSet;

public class WebviewActivity extends AppCompatActivity {

    private WebView mWebview;

    private int mNumber = 0;

    private boolean flag = false;

    private ArrayList<String> list = new ArrayList<>();

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebview = (WebView) findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true);

        mWebview.setWebViewClient(new MyWebViewClient());
//        mWebview.setWebChromeClient(new MyWebChromeClient());

        mWebview.loadUrl("http://h5.m.taobao.com/mlapp/olist.html?spm=a2141.7756461.2.3&tabCode=waitConfirm");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    Log.e("SunOfBeach", list.get(i));


                }
                Log.e("SunOfBeach","-------------");
                HashSet<String> strings = new HashSet<String>(list);
                list.clear();
                list.addAll(strings);
                for (int i = 0; i < list.size(); i++) {
                    Log.e("SunOfBeach", list.get(i));


                }
            }
        }, 60000);


    }


    final class MyWebChromeClient extends WebChromeClient {


    }


    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.e("webview", view.toString() + "-------" + url + "-------" + favicon);


        }


        @Override
        public void onPageFinished(final WebView view, String url) {
            super.onPageFinished(view, url);
/*
            String js = "javascript:(function () { alert(\"fuck the door\");})()";
            view.loadUrl(js);*/


            if (url.startsWith("http://h5.m.taobao.com/mlapp/olist.html")) {

                if (!flag) {

                    Log.e("webview", "excute" + "----" + url);
                    String js = "javascript:$(\"li[name=viewLogistic]\").length";

                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {

                    }
                    view.evaluateJavascript(js, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {

                            Log.e("value", value);

                            mNumber = Integer.parseInt(value);
                            try {
                                Thread.sleep(2000);
                            } catch (Exception e) {

                            }
                            String js1 = "javascript:$(\"li[name=viewLogistic]\")[0].click()";
                            view.loadUrl(js1);
                            flag = true;
                        }
                    });

                } else {
                    if (index < mNumber) {
                        Log.e("waybill", "size+" + index);
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {

                        }
                        String js1 = "javascript:$(\"li[name=viewLogistic]\")[" + (++index) + "].click()";
                        view.loadUrl(js1);
                    }
                }


            }
            if (url.startsWith("http://h5.m.taobao.com/awp/mtb/oper.htm")) {

                Log.e("h5", "第五步");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                String js = "javascript:$(\".logis-info p\").last().html().replace(\"运单号码\",\"\").replace(\" \",\"\").trim()";
                view.evaluateJavascript(js, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        Log.e("wayBill", value);
                        if (value!=null && !value.equals("")) {

                                list.add(value);

                            try {
                                Thread.sleep(2000);
                            } catch (Exception e) {

                            }
                            String js2 = "javascript:$(\"a[class=back]\").click()";
                            view.loadUrl(js2);


                        }
                    }
                });

            }


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_webview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
