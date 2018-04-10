package com.example.android.pupil_watch;

/**
 * Created by Rashed on 10-04-2018.
 */

public class QuesAns {
    private String Question;
    private String Answer;

    public QuesAns(String q, String a) {
        Question = q;
        Answer = a;
    }

    public String getq() {
        return Question;
    }

    public String geta() {
        return Answer;
    }
}
