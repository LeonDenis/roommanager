package br.com.leonixsoftware.roommanager;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by leondenis on 14/10/18.
 */

public class AppLeonixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setFullScreen() {
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected void setNextActivity(Runnable runnable, Long delay) {
        new Handler().postDelayed(runnable, delay);
    }

    protected <Any> Any load(Integer element) {
        return ((Any)findViewById(element));
    }
}
