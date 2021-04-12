package com.vadzimvincho.textbook.entity;

import java.util.LinkedList;
import java.util.List;

public class TextBook implements TextContainer {
    private List<TextBookComponent> textBookComponents = new LinkedList<>();

    @Override
    public List<TextBookComponent> getTextComponent() {
        return textBookComponents;
    }

    @Override
    public void addTextComponent(TextComponent textComponent) {
        textBookComponents.add((TextBookComponent) textComponent);
    }

    @Override
    public void removeTextComponent(TextComponent textComponent) {
        textBookComponents.remove(textComponent);
    }

    @Override
    public String getTextComponentToString() {
        StringBuilder textBook = new StringBuilder();
        for (TextComponent textBookComponent : textBookComponents) {
            textBook.append(textBookComponent.getTextComponentToString());
            textBook.append("\n");
        }
        return textBook.toString();
    }
}