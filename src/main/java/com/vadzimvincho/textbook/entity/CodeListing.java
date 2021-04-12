package com.vadzimvincho.textbook.entity;

import java.util.LinkedList;
import java.util.List;

public class CodeListing implements TextBookComponent {
    private List<CodeLine> codeLines = new LinkedList<>();

    @Override
    public List getTextComponent() {
        return codeLines;
    }

    @Override
    public void addTextComponent(TextComponent textComponent) {
        codeLines.add((CodeLine) textComponent);
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) {
        codeLines.remove(textComponent);
    }

    @Override
    public String getTextComponentToString() {
        StringBuilder paragraph = new StringBuilder();
        for (TextComponent paragraphComponent : codeLines) {
            paragraph.append(paragraphComponent.getTextComponentToString());
            paragraph.append("\n");
        }
        return paragraph.toString().trim();
    }
}
