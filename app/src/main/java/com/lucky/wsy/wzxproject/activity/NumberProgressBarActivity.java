package com.lucky.wsy.wzxproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lucky.wsy.wzxproject.R;
import com.lucky.wsy.wzxproject.numberprogressbar.NumberProgressBar;

/**
 * Created by wsy on 2018/3/10.
 */

public class NumberProgressBarActivity extends Activity {


    private CountDownTimer countDownTimer;
    private int i=10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_progress_bar_activity);

        final NumberProgressBar bnp = (NumberProgressBar) findViewById(R.id.numberbar1);

        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                bnp.incrementProgressBy(i);
            }

            @Override
            public void onFinish() {
                bnp.incrementProgressBy(0);
            }
        };

        countDownTimer.start();
    }
}
