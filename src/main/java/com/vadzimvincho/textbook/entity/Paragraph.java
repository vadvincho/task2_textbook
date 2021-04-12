package com.vadzimvincho.textbook.entity;

import java.util.LinkedList;
import java.util.List;

public class Paragraph implements TextBookComponent {
    private List<ParagraphComponent> paragraphComponents = new LinkedList<>();

    @Override
    public List<ParagraphComponent> getTextComponent() {
        return paragraphComponents;
    }

    @Override
    public void addTextComponent(TextComponent textComponent) {
        paragraphComponents.add((ParagraphComponent) textComponent);
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) {
        paragraphComponents.remove(textComponent);
    }

    @Override
    public String getTextComponentToString() {
        StringBuilder paragraph = new StringBuilder();
        for (TextComponent paragraphComponent : paragraphComponents) {
            paragraph.append(paragraphComponent.getTextComponentToString());
            paragraph.append(" ");
        }
        return paragraph.toString().trim();
    }
}
