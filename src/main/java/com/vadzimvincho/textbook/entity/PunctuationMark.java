package com.vadzimvincho.textbook.entity;

public class PunctuationMark implements SentenceComponent {
    private Character punctuationMark;

    public Character getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(Character punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String getTextComponentToString() {
        return punctuationMark.toString();
    }
}