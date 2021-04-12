package com.vadzimvincho.textbook.entity;

import java.util.LinkedList;
import java.util.List;

public class Sentence implements ParagraphComponent {
    private List<SentenceComponent> sentenceComponents = new LinkedList<>();

    @Override
    public List<SentenceComponent> getTextComponent() {
        return sentenceComponents;
    }

    @Override
    public void addTextComponent(TextComponent textComponent) {
        sentenceComponents.add((SentenceComponent) textComponent);
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) {
        sentenceComponents.remove(textComponent);
    }

    @Override
    public String getTextComponentToString() {
        StringBuilder sentence = new StringBuilder();
        for (TextComponent sentenceComponent : sentenceComponents) {
            sentence.append(sentenceComponent.getTextComponentToString());
        }
        return sentence.toString().trim();
    }
}
