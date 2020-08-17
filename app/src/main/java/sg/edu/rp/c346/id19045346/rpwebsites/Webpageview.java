package sg.edu.rp.c346.id19045346.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Webpageview extends AppCompatActivity {

    WebView retrieveweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpageview);

        retrieveweb = findViewById(R.id.webviewRP);
        retrieveweb.setWebViewClient(new WebViewClient());

        WebSettings webSettings = retrieveweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(false);
        webSettings.setBuiltInZoomControls(true);

        Intent intentReceived = getIntent();
        String web = intentReceived.getStringExtra("website");
        retrieveweb.loadUrl(web);


    }
}
