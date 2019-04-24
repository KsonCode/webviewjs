package com.bwie.webviewjs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class MessageEntity {

    private WebView webView;
    private AppCompatActivity context;

    public MessageEntity(AppCompatActivity context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }

    @JavascriptInterface
    public void receiveJs(String str){
        System.out.println("js："+str);


        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String s = "我已收到";
                webView.loadUrl("javascript:callJS('"+s+"')");
            }
        });


    }

}
