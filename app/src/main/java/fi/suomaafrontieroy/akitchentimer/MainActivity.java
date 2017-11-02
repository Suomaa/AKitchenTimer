package fi.suomaafrontieroy.akitchentimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTimer;
    private NumberPicker hoursPicker;
    private NumberPicker minutesPicker;
    private NumberPicker secondsPicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimer = (TextView) findViewById(R.id.textTimer);

        hoursPicker = (NumberPicker) findViewById(R.id.hoursPicker);
        hoursPicker.setMaxValue(24);
        hoursPicker.setMinValue(0);

        minutesPicker = (NumberPicker) findViewById(R.id.minutesPicker);
        minutesPicker.setMaxValue(59);
        minutesPicker.setMinValue(0);

        secondsPicker = (NumberPicker) findViewById(R.id.secondsPicker);
        secondsPicker.setMaxValue(59);
        secondsPicker.setMinValue(0);

    }

    public void CreateTimer(int timer) {
        new CountDownTimer(timer, 1000) {

            public void onTick(long millisUntilFinished) {
                String tick = "Time remaining: " + millisUntilFinished / 1000;
                mTimer.setText(tick);
            }

            public void onFinish() {
                mTimer.setText("Ready!");
            }
        }
                .start();
    }

    public void clickButtonStart(View view) {
        int hours = hoursPicker.getValue();
        int minutes = minutesPicker.getValue();
        int seconds = secondsPicker.getValue();
        int timer = (hours * 3600 + minutes * 60 + seconds) * 1000;
        CreateTimer(timer);
    }
}