package com.bentals.class8;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements MainInterface{

    private Button b1, b2;
    private FrameLayout fragmentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = (FrameLayout) findViewById(R.id.fragmentContainer);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment1 f1 = new Fragment1();
                switchFragment(f1);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 f2 = new Fragment2();
                switchFragment(f2);
            }
        });


        Fragment1 f1 = new Fragment1();
        switchFragment(f1);
    }

    public void switchFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(fragmentContainer.getId(), fragment, "TAG")
                .addToBackStack(null)
                .commit();
    }

    //interface implementation
    @Override
    public void changeButtonTitle(String title) {
        b1.setText(title);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
