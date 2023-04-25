package balehouane.bbtscoringtool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PreFightingActivity extends AppCompatActivity {

    private Button startF;
    public static EditText fighterRed;
    public static EditText fighterBlue;
    public static EditText teamRed;
    public static EditText teamBlue;
    public static EditText weightCategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_fighting);

        startF = (Button) findViewById(R.id.startF);
        fighterRed = (EditText) findViewById(R.id.nameR);
        fighterBlue = (EditText) findViewById(R.id.nameB);
        teamRed = (EditText) findViewById(R.id.teamR);
        teamBlue = (EditText) findViewById(R.id.teamB);
        weightCategorie = (EditText) findViewById(R.id.weight);

        startF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFightingActivity();
            }
        });
    }

    private void openFightingActivity(){
        Intent intent = new Intent(this, FightingActivity.class);
        startActivity(intent);
        finish();
    }
}
