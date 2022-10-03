package com.example.tasty.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tasty.R;
import com.example.tasty.User.UserDashboard;

import java.util.Timer;

public class SplashScreen extends AppCompatActivity {
     private static int SPLASH_TIMER = 5000;
    Timer timer;
    //assign variables
    ImageView background;
    TextView logo_name;
    TextView powered_by;

    //animations
    Animation sideanim,bottomanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.splash_screen);

        //hooks
        background = findViewById(R.id.background_image);
        logo_name = findViewById(R.id.tasty);
       powered_by = findViewById(R.id.powered_by);

        //animations
        sideanim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //assign animations
        background.setAnimation(sideanim);
        logo_name.setAnimation(sideanim);
       powered_by.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
                Intent intent = new Intent(getApplicationContext(),UserDashboard.class);
               startActivity(intent);
               finish();

            }
        },SPLASH_TIMER);
  }
}