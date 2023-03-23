package com.exe.paradox.Models;

import java.util.ArrayList;

public class Question {
    int questionNo;
    String _id;
    String questionId;
    String question;
    ArrayList<String> images;
    String answer; //Not to be given by server

    public Question() {
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getImages() {
        return images;
    }
}
