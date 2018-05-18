package com.example.karaens.gameofstones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Random;

public class GameScreen extends AppCompatActivity {
    int[] stone_id = new int[]{R.id.PowerStone, R.id.SpaceStone, R.id.MindStone, R.id.RealityStone, R.id.TimeStone, R.id.SoulStone};
    int[] status = new int[]{0, 0, 0, 0, 0, 0};
    int[] colors = new int[]{R.color.purple, R.color.blue, R.color.yellow, R.color.red, R.color.green, R.color.orange};
    TextView stone;
    Button grab, reset;
    final Random random = new Random();
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        grab = findViewById(R.id.grabButton);
        reset = findViewById(R.id.resetButton);
        grab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r = random.nextInt(6);
                if (status[r] == 0) {
                    status[r] = 1;
                    stone = findViewById(stone_id[r]);
                    stone.setBackgroundResource(colors[r]);
                }
                Intent intent = new Intent(GameScreen.this, Screen.class);
                intent.putExtra("index", r);
                startActivity(intent);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = new int[]{0, 0, 0, 0, 0, 0};
                Screen.sts = new int[]{0, 0, 0, 0, 0, 0};
                for (int i = 0; i < 6; i++) {
                    stone = findViewById(stone_id[i]);
                    stone.setBackgroundResource(R.color.grey);
                }
            }
        });

    }
}
