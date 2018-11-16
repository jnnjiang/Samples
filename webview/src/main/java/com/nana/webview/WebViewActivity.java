package com.nana.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;

/**
 * WebView主要用于处理Android和JS交互的问题
 * https://blog.csdn.net/carson_ho/article/details/64904691/ 总结的非常好
 * https://www.cnblogs.com/butterfly-clover/p/3903580.html
 * Android调用JS：
 * 1.
 */
public class WebViewActivity extends AppCompatActivity {

    private static final String TAG = WebViewActivity.class.getName();
    private static final String URL = "file:///android_asset/javascript.html";
    @BindView(R.id.webview)
    WebView mWebView;
    @BindView(R.id.btn_call_js_method1)
    Button btnCallJSMethod1;
    @BindView(R.id.btn_call_js_method2)
    Button btnCallJSMethod2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initParams();
        mWebView.loadUrl(URL);
        btnCallJSMethod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callJSByLoadUrl();
            }
        });
    }

    private void initParams() {

        mWebView.getSettings().setJavaScriptEnabled(true);  //  设置页面支持Javascript
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); // 设置允许JS弹窗

        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setSupportZoom(true);          //支持缩放
        mWebView.getSettings().setBuiltInZoomControls(true); //显示放大缩小
        mWebView.setInitialScale(100); //初始化时缩放
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);//解决缓存问题
    }

    private void callJSByLoadUrl(){

    }

    private void callJSByEvaluateJavaScript(){

    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }
    }



    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
