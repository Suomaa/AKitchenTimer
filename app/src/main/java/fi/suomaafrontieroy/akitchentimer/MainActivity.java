package fi.suomaafrontieroy.akitchentimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimer = (TextView) findViewById(R.id.text_timer);

        new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                String tick = "To the finish: " + millisUntilFinished / 1000;
                mTimer.setText(tick);
            }

            public void onFinish() {
                mTimer.setText("Ready!");
            }
        }
                .start();
    }

}