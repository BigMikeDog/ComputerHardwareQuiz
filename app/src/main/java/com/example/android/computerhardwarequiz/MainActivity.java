package com.example.android.computerhardwarequiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View view){

        int score = 0;
        String toastMessage = null;
        boolean wrong=false;

        RadioButton q1a3 = findViewById(R.id.q1_r3);
        RadioButton q2a3 = findViewById(R.id.q2_r3);
        CheckBox q3a1 = findViewById(R.id.q3_c1);
        CheckBox q3a2 = findViewById(R.id.q3_c2);
        CheckBox q3a3 = findViewById(R.id.q3_c3);
        CheckBox q3a4 = findViewById(R.id.q3_c4);
        RadioButton q4a3 = findViewById(R.id.q4_r3);

        EditText contestantNameField = findViewById(R.id.contestant_name);
        String contestantName = contestantNameField.getText().toString();

        if (q1a3.isChecked()){
            score++;
        }else{
            toastMessage = getString(R.string.q1FirstWrong);
            wrong=true;

        }
        if (q2a3.isChecked()){
            score++;
        }else if (wrong){
            toastMessage = toastMessage + " " + getString(R.string.q2Wrong);
        }else{
            toastMessage = getString(R.string.q2FirstWrong);
            wrong=true;
        }
        if (q3a1.isChecked()&(!q3a2.isChecked())&q3a3.isChecked()&q3a4.isChecked()){
            score++;
        }else if (wrong){
            toastMessage = toastMessage + " " + getString(R.string.q3Wrong);
        }else{
            toastMessage = getString(R.string.q3FirstWrong);
            wrong=true;
        }
        if (q4a3.isChecked()){
            score++;
        }else if (wrong){
            toastMessage = toastMessage + " " + getString(R.string.q4Wrong);
        }else{
            toastMessage = getString(R.string.q4FirstWrong);
        }
        if (score==4){
            toastMessage=getString(R.string.allCorrect,contestantName);
        }else{
            toastMessage = toastMessage + " " + getString(R.string.wrongSuffex,contestantName);
        }

        Context context = this.getApplicationContext();
        Toast result = Toast.makeText(context,toastMessage,Toast.LENGTH_LONG);
        result.show();
    }
}
