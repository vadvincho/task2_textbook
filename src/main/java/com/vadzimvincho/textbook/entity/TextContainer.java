package com.vadzimvincho.textbook.entity;

import java.util.List;

public interface TextContainer extends TextComponent {
    void addTextComponent(TextComponent textComponent);

    void removeTextComponent(TextComponent textComponent);

    List getTextComponent();
}
