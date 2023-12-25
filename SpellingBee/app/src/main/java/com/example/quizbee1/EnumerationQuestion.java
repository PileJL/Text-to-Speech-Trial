package com.example.quizbee1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class EnumerationQuestion extends AppCompatActivity {

    private int correct_answers = 0;
    private int item_number = 1;
    private TextToSpeech mTTs;
    String[] words = {"Minute", "Queue", "Power", "Reap", "Exaggerate"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enumeration_question);

        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                mTTs.setLanguage(Locale.US);
            }
        });
        speak(words[item_number-1]);
    }

    private void speak(String text) {
//        mTTs.setPitch(1);
//        mTTs.setSpeechRate();
        mTTs.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onDestroy() {
        if (mTTs != null) {
            mTTs.stop();
            mTTs.shutdown();
        }
        super.onDestroy();
    }

    public void replayWord(View view) {

        speak(words[item_number-1]);
    }

    public void submitAnswer(View view) {
        EditText editText = findViewById(R.id.answer);
        String answer = editText.getText().toString().toLowerCase();
        TextView question_num = findViewById(R.id.question_num);

        if (!answer.isEmpty()) {
            if (item_number == 1 && answer.equals("minute")) {
                correct_answers++;
            }
            else if (item_number == 2 && answer.equals("queue")) {
                correct_answers++;
            }
            else if (item_number == 3 && answer.equals("power")) {
                correct_answers++;
            }
            else if (item_number == 4 && answer.equals("reap")) {
                correct_answers++;
            }
            else if (item_number == 5 && answer.equals("exaggerate")) {
                correct_answers++;
            }

            editText.setText("");

            Toast.makeText(getApplicationContext(), "Answer submitted", Toast.LENGTH_SHORT).show();
            item_number++;
            if (item_number == 6) {
                Intent intent = new Intent(EnumerationQuestion.this, EndGame.class);
                intent.putExtra("correct_answers", Integer.toString(correct_answers));
                startActivity(intent);
            }
            if (item_number < 6) {
                question_num.setText(Integer.toString(item_number) +"/5");
            }

        }
        else {
            Toast.makeText(getApplicationContext(), "Please enter your answer", Toast.LENGTH_SHORT).show();
        }
    }

    public void backToGameMode(View view) {
        startActivity(new Intent(EnumerationQuestion.this, GameModeSelection.class));
    }
}