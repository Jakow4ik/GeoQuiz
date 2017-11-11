package com.example.adminama.geoquiz;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.adminama.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOW = "com.example.adminama.geoquiz.answer_shown";
    private static final String KEY_CHEAT = "cheat";
    private static final String KEY_VIEW = "view";

    private boolean mAnswerIsTrue;
    private boolean chekCheat;

    private TextView mAnswerTextView;
    private Button mShowAnswerButton;

    public static Intent newIntent(Context packageContext, boolean answerISTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerISTrue);
        return intent;
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOW, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }

                setAnswerShownReult(true);
                chekCheat = true;


            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY_VIEW, mAnswerTextView.getText().toString());
        savedInstanceState.putBoolean(KEY_CHEAT, chekCheat);

    }

    @Override
    public void onRestoreInstanceState(Bundle restoreInstanceState) {
        super.onRestoreInstanceState(restoreInstanceState);
        mAnswerTextView.setText(restoreInstanceState.getString(KEY_VIEW));

        if (restoreInstanceState.getBoolean(KEY_CHEAT)) {
            setAnswerShownReult(true);
            chekCheat = true;
        }
    }

    private void setAnswerShownReult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOW, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}

