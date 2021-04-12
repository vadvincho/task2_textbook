package com.vadzimvincho.textbook;

import com.vadzimvincho.textbook.entity.TextBook;
import com.vadzimvincho.textbook.services.FileManager;
import com.vadzimvincho.textbook.services.TextBookParser;
import com.vadzimvincho.textbook.services.TextModifier;

public class Application {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        TextBookParser textBookParser = new TextBookParser();
        TextModifier textModifier = new TextModifier();

        String textbookStr = fileManager.readTextbook();
        TextBook textBook = textBookParser.parseTextbook(textbookStr);

        String task2 = textModifier.task2(textBook);
        String task9 = textModifier.task9(textBook);

        StringBuilder resultString = new StringBuilder();
        resultString.append(textBook.getTextComponentToString())
                .append("task2")
                .append("=====================================")
                .append("\n")
                .append(task2)
                .append("task9")
                .append("=====================================")
                .append("\n")
                .append(task9);
        fileManager.writeTextbook(resultString.toString());
    }
}
