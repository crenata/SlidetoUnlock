package com.hafiizh.slidetounlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.slide);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int alpha = (progress * (255 / 100));
                seekBar.getThumb().setAlpha(255 - alpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() < 90) {
                    seekBar.setThumb(getDrawable(R.drawable.ic_arrow_forward_black_24dp));
                    seekBar.setProgress(0);
                } else {
                    seekBar.setProgress(100);
                    seekBar.getThumb().setAlpha(0);
                    startActivity(new Intent(getApplicationContext(), Unlock.class));
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        seekBar.setProgress(0);
        seekBar.setThumb(getDrawable(R.drawable.ic_arrow_forward_black_24dp));
    }
}
