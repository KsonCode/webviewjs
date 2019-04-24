package com.bwie.webviewjs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;

public class JsbridgeActivity extends AppCompatActivity {

    BridgeWebView bridgeWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsbridge);
        bridgeWebView = findViewById(R.id.webview);


        bridgeWebView.setDefaultHandler(new DefaultHandler());
        bridgeWebView.loadUrl("file:///android_asset/test.html");

        bridgeWebView.send("hhhhhhhhhhhh");

        bridgeWebView.registerHandler("toandroid", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                System.out.println("js传过来的数据："+data);
                function.onCallBack("{我是安卓}");
            }
        });
    }

    /**
     * 数据发送到js
     * @param view
     */
    public void sendtojs(View view) {

        bridgeWebView.callHandler("hello", "{我是安卓发送的数据}", new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                System.out.println("js返回数据："+data);
            }
        });

    }
}
