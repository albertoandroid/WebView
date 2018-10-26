package com.example.alten.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
WebViewClient -> Nos permite manejar la navegación dentro del WebView y manejar los eventos que se generan.
 */
public class WebViewClientActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_client);

        webView = findViewById(R.id.webViewClient);
        webView.setWebViewClient(new WebViewClient(){
            //Cuando la página empieza a cargarse en el webView
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d("TAG1", "onPageStarted - URL que se ha comenzado a descargar..." + url);
            }

            //Cuando la página ha sido completamente cargada
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d("TAG1", "onPageFinished - URL finalizada de descargar " + url);
            }

            /*
            Nos da la oportunidad de tomar el control antes de que la URL sea cargada. Así que podemos cambiar la url que queremos cargar.
            Ejemplo -> Si detectamos un dominio lo podemos bloquear, podemos cambiar la url que llega. O bloquear por ejemplo las web que sean http y solo dejar las https
            Return true -> Cancelamos la carga de la URL por parte del WebView. Pero podemos manejar nosotros la carga de URL por ejemplo con el metodo view.loadURL
            Return false -> El WebView carga la URL de forma habitual.
             */
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("TAG1", "shouldOverrideUrlLoading " + url);
                if (url.startsWith("http:")) {
                    Log.d("TAG1", "http: " + "No cargamos la web al no ser SSL");
                    //Si por ejemplo cuando no sea una SSL lo queremos desviar a https://www.google.es/
                    String urlSSL = "https://www.google.es/";
                    view.loadUrl(urlSSL);
                    return true;
                } else {
                    Log.d("TAG1", "https: " + "Cargamos la web al ser SSL");
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webView.loadUrl("http://www.androiddesdecero.com/");
        //webView.loadUrl("https://www.google.es");
    }
}