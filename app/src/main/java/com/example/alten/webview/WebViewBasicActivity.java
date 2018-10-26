package com.example.alten.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
WebView -> Android nos permite convertir nuestra activity en un Navegador.
 */
public class WebViewBasicActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_basic);

        webView = findViewById(R.id.webViewBasic);
        //Le podemos decir que acepte JavaScript, Zoom, bloquear imagenes etc
        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.getSettings().setBuiltInZoomControls(true);
        //webView.getSettings().setBlockNetworkImage(true);
        webView.loadUrl("https://www.google.com/");

         /*
        Creamos un nuevo WebViewCliente. Para tener nuestro propio navegador en la aplicación
        De esta manera evitamos que cuando pulsamos un botón o nos redirija a algún lado se nos vaya al navegador por defecto del telefono en vez de estar en nuestro propio webView
         */
        webView.setWebViewClient(new WebViewClient());
    }

    //Vamos a poner el onBackPressed que no cierre la app, sino que vaya para atrás en el navegador
    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
