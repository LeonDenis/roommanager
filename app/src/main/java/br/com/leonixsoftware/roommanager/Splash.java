package br.com.leonixsoftware.roommanager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by leondenis on 14/10/18.
 */

public class Splash extends AppLeonixActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Tela Cheia.
        super.setFullScreen();
        // Trocando de Tela
        super.setNextActivity(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), SplashApp.class));
                finish();
            }
        }, 2000L);
    }
}
