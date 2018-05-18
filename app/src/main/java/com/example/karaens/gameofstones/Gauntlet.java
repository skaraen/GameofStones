package com.example.karaens.gameofstones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gauntlet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauntlet);
        Button restart=findViewById(R.id.restartButton);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Screen.sts=new int[]{0,0,0,0,0,0};
                startActivity(new Intent(Gauntlet.this,GameScreen.class));
            }
        });
    }
}
