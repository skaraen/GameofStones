package com.example.karaens.gameofstones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

public class Screen extends AppCompatActivity {

    int s;
    static int[] sts={0,0,0,0,0,0};
    int[] drawables=new int[]{R.drawable.power,R.drawable.space,R.drawable.mind,R.drawable.reality,R.drawable.time,R.drawable.soul};
    String[] texts=new String[]{"Power","Space","Mind","Reality","Time","Soul"};
    RelativeLayout bg;
    TextView name;
    Button retry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        s=getIntent().getIntExtra("index",0);
        sts[s]=1;
        bg=findViewById(R.id.sscreen);
        bg.setBackgroundResource(drawables[s]);
        name=findViewById(R.id.stoneName);
        name.setText(texts[s]);
        retry=findViewById(R.id.buttonRetry);
        final Intent intent1=new Intent(Screen.this,GameScreen.class);
        final Intent intent2=new Intent(Screen.this,Gauntlet.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag=1;
                for(int i=0;i<6;i++)
                {
                    if(sts[i]==0)
                    {
                        flag=0;
                        break;
                    }
                }
                if(flag==1)
                {
                    startActivity(intent2);
                }
                else
                startActivity(intent1);
            }
        });

    }
}
