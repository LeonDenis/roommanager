package br.com.leonixsoftware.roommanager;

import android.content.Intent;
import android.os.Build;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by leondenis on 14/10/18.
 */

public class SplashApp extends AppLeonixActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_app);
        // Tela Cheia.
        super.setFullScreen();
        // Trocando de Tela
        super.setNextActivity(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        }, 2500L);

    }
}
