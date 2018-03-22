package com.example.imageeffectsdemo;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.view.View;

// these were added
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

/*

I used this tutorial
https://www.tutorialspoint.com/android/android_imageswitcher.htm


Image Transition Effects Demo
By: Varinder Sidhu

1. Import animation, AnimationUtils, ImageSwitcher, ImageView, ViewFactory

2. Set factory and make a view for the ImageSwitcher

3. Initialize the animation variables

4. Set the in and out animations to the ImageSwitcher

5. Set

*/

public class MainActivity extends Activity {
    private ImageSwitcher imgSwitcher;
    private Button b1,b2;

    private int imgNum;

    // initialize animation objects
    Animation in;
    Animation out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        imgNum = 0;

        imgSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        // makes a view for the imageswitcher
        // That's really all the documentation I could find
        // Seems like it sets specific settings for the ImageSwitcher

        imgSwitcher.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // initialize the animations
                in = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left);
                out = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_out_right);

                // set in and out animations to the ImageSwitcher
                imgSwitcher.setInAnimation(in);
                imgSwitcher.setOutAnimation(out);

                if (imgNum == 2)
                {
                    // set the image
                    imgSwitcher.setImageResource(R.drawable.ic_launcher_foreground);
                    imgNum = 1;
                }
                else
                {
                    // set the image
                    imgSwitcher.setImageResource(R.drawable.ic_launcher_background);
                    imgNum = 2;
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // initialize the animations
                in = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in);
                out = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out);

                // set in and out animations to the ImageSwitcher
                imgSwitcher.setInAnimation(in);
                imgSwitcher.setOutAnimation(out);

                if (imgNum == 1)
                {
                    // set the image
                    imgSwitcher.setImageResource(R.drawable.ic_launcher_background);
                    imgNum = 2;
                }
                else
                {
                    // set the image
                    imgSwitcher.setImageResource(R.drawable.ic_launcher_foreground);
                    imgNum = 1;
                }

            }
        });
    }
}