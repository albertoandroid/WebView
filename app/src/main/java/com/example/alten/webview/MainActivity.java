package com.example.alten.webview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/*
WebView -> Android nos permite convertir nuestra activity en un Navegador.
 */
public class MainActivity extends AppCompatActivity {

    private Button btWebView;
    private Button btwebViewClient;
    private Button btWebViewProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    private void setUpView(){
        btWebView = findViewById(R.id.btWebView);
        btWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WebViewBasicActivity.class));
            }
        });

        btwebViewClient = findViewById(R.id.btWebViewClient);
        btwebViewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WebViewClientActivity.class));
            }
        });

        btWebViewProgressBar = findViewById(R.id.btWebViewProgressBar);
        btWebViewProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WebViewProgressBarActivity.class));
            }
        });
    }
}
