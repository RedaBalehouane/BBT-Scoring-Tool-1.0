package balehouane.bbtscoringtool;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class FightingActivity extends AppCompatActivity {

    public PreFightingActivity preFightingActivity;

    private static final long START_TIME_IN_MILLIS = 120000;

    public static TextView timer;
    public static ImageView spButton;
    private CountDownTimer tCounter;

    private boolean timerRunning;
    private long timeLeft = START_TIME_IN_MILLIS;

    private ImageView punchR;
    private ImageView punchB;
    private ImageView chestR;
    private ImageView chestB;
    private ImageView headR;
    private ImageView headB;
    private ImageView gamjeomR;
    private ImageView gamjeomB;
    private TextView counterR;
    private TextView counterB;
    private TextView rouge;
    private TextView bleu;
    private  TextView teamR;
    private TextView teamB;
    private TextView weight;
    private TextView jeomCounterR;
    private TextView jeomCounterB;
    private int jeaomR = 0;
    private  int jeomB = 0;
    private int rPoint = 0;
    private int bPoint = 0;
    private ImageView close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);

        timer = (TextView) findViewById(R.id.timer);
        spButton = (ImageView) findViewById(R.id.startICO);

        spButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        punchR = (ImageView) findViewById(R.id.punchRed);
        punchB = (ImageView) findViewById(R.id.punchBlue);
        chestR = (ImageView) findViewById(R.id.chestRed);
        chestB = (ImageView) findViewById(R.id.chestBlue);
        headR = (ImageView) findViewById(R.id.headRed);
        headB = (ImageView) findViewById(R.id.headBlue);
        counterR = (TextView) findViewById(R.id.counterRed);
        counterB = (TextView) findViewById(R.id.counterBlue);
        gamjeomR = (ImageView) findViewById(R.id.gamejeomR);
        gamjeomB = (ImageView) findViewById(R.id.gamejeomB);
        close = (ImageView)findViewById(R.id.close);

        rouge = (TextView) findViewById(R.id.rouge);
        bleu = (TextView) findViewById(R.id.bleu);
        teamR = (TextView) findViewById(R.id.teamRt);
        teamB = (TextView) findViewById(R.id.teamBt);
        weight = (TextView) findViewById(R.id.weightL);
        jeomCounterR = (TextView) findViewById(R.id.gamejeomCounterR);
        jeomCounterB = (TextView) findViewById(R.id.gamejeomCounterB);

        rouge.setText(preFightingActivity.fighterRed.getText());
        bleu.setText(preFightingActivity.fighterBlue.getText());
        teamR.setText(preFightingActivity.teamRed.getText());
        teamB.setText(preFightingActivity.teamBlue.getText());
        weight.setText(preFightingActivity.weightCategorie.getText());


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        gamjeomR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPoint ++;
                counterB.setText(Integer.toString(bPoint));
                jeaomR++;
                jeomCounterR.setText(Integer.toString(jeaomR));
            }
        });

        gamjeomB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rPoint ++;
                counterR.setText(Integer.toString(rPoint));
                jeomB++;
                jeomCounterB.setText(Integer.toString(jeomB));
            }
        });

        punchR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rPoint++;
                counterR.setText(Integer.toString(rPoint));
            }
        });

        chestR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rPoint+=2;
                counterR.setText(Integer.toString(rPoint));
            }
        });

        headR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rPoint+=3;
                counterR.setText(Integer.toString(rPoint));
            }
        });

        punchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPoint++;
                counterB.setText(Integer.toString(bPoint));
            }
        });

        chestB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPoint+=2;
                counterB.setText(Integer.toString(bPoint));
            }
        });

        headB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPoint+=3;
                counterB.setText(Integer.toString(bPoint));
            }
        });
    }

    private void startTimer(){
        tCounter =  new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                spButton.setImageDrawable(getDrawable(R.drawable.start));
            }
        }.start();

        timerRunning = true;
        spButton.setImageDrawable(getDrawable(R.drawable.pause));
    }

    private void pauseTimer(){
        tCounter.cancel();
        timerRunning = false;
        spButton.setImageDrawable(getDrawable(R.drawable.start));
    }

    private void updateTimer(){
        int minutes = (int) (timeLeft/ 1000) /60;
        int secondes = (int) (timeLeft / 1000) %60;

        String timeLeftFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, secondes);
        timer.setText(timeLeftFormat);
    }

    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
