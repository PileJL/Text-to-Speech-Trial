package com.example.quizbee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MultichoiceQuestion extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    int item_number = 1;
    int correct_answers = 0;
    TextView question_num;

    String[][] pre_choices = {
            {"Judjment", "Judjment", "Judgement", "Judjement"},
            {"Receive", "Recieve", "Recieve", "Recieve"},
            {"wiit", "wit", "wiet", "wiet"},
            {"oppurtunity", "oportunity", "opportunity", "oppurtonity"},
            {"reckon", "wreckon", "rheckon", "rheckon"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multichoice_question1);

        question_num = findViewById(R.id.question_num);
        radioGroup = findViewById(R.id.choice_group);
    }

    public void submitAnswer(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        if (radioId == -1) {
            Toast.makeText(getApplicationContext(), "Select your answer", Toast.LENGTH_SHORT).show();
        }
        else {
            radioButton = findViewById(radioId);
            String answer = radioButton.getText().toString().toLowerCase();

            if (item_number == 1 && answer.equals("judgement")) {
                correct_answers++;
            }
            else if (item_number == 2 && answer.equals("receive")) {
                correct_answers++;
            }
            else if (item_number == 3 && answer.equals("wit")) {
                correct_answers++;
            }
            else if (item_number == 4 && answer.equals("opportunity")) {
                correct_answers++;
            }
            else if (item_number == 5 && answer.equals("reckon")) {
                correct_answers++;
            }

            Toast.makeText(getApplicationContext(), "Answer submitted", Toast.LENGTH_SHORT).show();
            radioGroup.clearCheck();
            item_number++;
            changeChoices();
            if (item_number == 6) {
                Intent intent = new Intent(MultichoiceQuestion.this, EndGame.class);
                intent.putExtra("correct_answers", Integer.toString(correct_answers));
                startActivity(intent);
            }
            if (item_number < 6) {
                question_num.setText(Integer.toString(item_number) +"/5");
            }





        }
    }
    public void changeChoices() {
        RadioButton choice1 = findViewById(R.id.choice1);
        RadioButton choice2 = findViewById(R.id.choice2);
        RadioButton choice3 = findViewById(R.id.choice3);
        RadioButton choice4 = findViewById(R.id.choice4);

        View[] choices = {choice1, choice2, choice3, choice4};
        if (item_number == 2) {
            choice1.setText(pre_choices[1][0]);
            choice2.setText(pre_choices[1][1]);
            choice3.setText(pre_choices[1][2]);
            choice4.setText(pre_choices[1][3]);
        }
        else if (item_number == 3) {
            choice1.setText(pre_choices[2][0]);
            choice2.setText(pre_choices[2][1]);
            choice3.setText(pre_choices[2][2]);
            choice4.setText(pre_choices[2][3]);
        }
        else if (item_number == 4) {
            choice1.setText(pre_choices[3][0]);
            choice2.setText(pre_choices[3][1]);
            choice3.setText(pre_choices[3][2]);
            choice4.setText(pre_choices[3][3]);
        }
        else if (item_number == 5) {
            choice1.setText(pre_choices[4][0]);
            choice2.setText(pre_choices[4][1]);
            choice3.setText(pre_choices[4][2]);
            choice4.setText(pre_choices[4][3]);
        }

    }

}