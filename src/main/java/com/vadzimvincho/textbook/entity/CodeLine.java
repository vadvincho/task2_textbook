package com.vadzimvincho.textbook.entity;

public class CodeLine implements TextComponent {
    private String codeLine;

    public String getCodeLine() {
        return codeLine;
    }

    public void setCodeLine(String codeLine) {
        this.codeLine = codeLine;
    }

    @Override
    public String getTextComponentToString() {
        return codeLine;
    }
}
