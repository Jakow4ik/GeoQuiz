package com.example.adminama.geoquiz;

/**
 * Created by adminama on 05.11.2017.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    public boolean isCheat() {
        return mCheat;
    }

    public void setCheat(boolean cheat) {
        mCheat = cheat;
    }

    private boolean mCheat;


    public Question(int textResId, boolean answerTrue) {

        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mCheat = false;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
