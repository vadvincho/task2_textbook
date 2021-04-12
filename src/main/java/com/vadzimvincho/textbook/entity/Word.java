package com.vadzimvincho.textbook.entity;

public class Word implements SentenceComponent {
    private String word;

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String getTextComponentToString() {
        return word;
    }
}
