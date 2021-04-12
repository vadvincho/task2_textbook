package com.vadzimvincho.textbook.services;

import com.vadzimvincho.textbook.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TextModifierTest {

    private static TextBook textBook;
    private static String expectedString;
    private static String expectedStringTask2;
    private static String expectedStringTask9;
    private static TextModifier textModifier;

    @BeforeAll
    static void init() {
        textModifier = new TextModifier();
        textBook = new TextBook();
        expectedStringTask2 = "Это тестовый текст.\n" +
                "Вот всех, задачахттт!!\n";
        expectedStringTask9 = "всех\n" +
                "Вот\n" +
                "Это\n" +
                "текст\n" +
                "тестовый\n" +
                "задачахттт\n";
        expectedString = "Это тестовый текст.\n" +
                "<listing>\n" +
                "public class MyObject implements Comparable<MyObject> {\n" +
                "\tdouble d;\n" +
                "}\n" +
                "</listing>\n" +
                "Вот всех, задачахттт!!\n";

        Word s0 = new Word();
        s0.setWord("Это");
        PunctuationMark s1 = new PunctuationMark();
        s1.setPunctuationMark(' ');
        Word s2 = new Word();
        s2.setWord("тестовый");
        PunctuationMark s3 = new PunctuationMark();
        s3.setPunctuationMark(' ');
        Word s4 = new Word();
        s4.setWord("текст");
        PunctuationMark s5 = new PunctuationMark();
        s5.setPunctuationMark('.');

        Sentence sentence1 = new Sentence();
        sentence1.addTextComponent(s0);
        sentence1.addTextComponent(s1);
        sentence1.addTextComponent(s2);
        sentence1.addTextComponent(s3);
        sentence1.addTextComponent(s4);
        sentence1.addTextComponent(s5);

        Paragraph paragraph1 = new Paragraph();
        paragraph1.addTextComponent(sentence1);

        CodeLine codeLine0 = new CodeLine();
        codeLine0.setCodeLine("<listing>");
        CodeLine codeLine1 = new CodeLine();
        codeLine1.setCodeLine("public class MyObject implements Comparable<MyObject> {");
        CodeLine codeLine2 = new CodeLine();
        codeLine2.setCodeLine("\tdouble d;");
        CodeLine codeLine3 = new CodeLine();
        codeLine3.setCodeLine("}");
        CodeLine codeLine4 = new CodeLine();
        codeLine4.setCodeLine("</listing>");

        CodeListing codeListing = new CodeListing();
        codeListing.addTextComponent(codeLine0);
        codeListing.addTextComponent(codeLine1);
        codeListing.addTextComponent(codeLine2);
        codeListing.addTextComponent(codeLine3);
        codeListing.addTextComponent(codeLine4);

        Word s20 = new Word();
        s20.setWord("Вот");
        PunctuationMark s21 = new PunctuationMark();
        s21.setPunctuationMark(' ');
        Word s22 = new Word();
        s22.setWord("всех");
        PunctuationMark s23 = new PunctuationMark();
        s23.setPunctuationMark(',');
        PunctuationMark s24 = new PunctuationMark();
        s24.setPunctuationMark(' ');
        Word s25 = new Word();
        s25.setWord("задачахттт");
        PunctuationMark s26 = new PunctuationMark();
        s26.setPunctuationMark('!');
        PunctuationMark s27 = new PunctuationMark();
        s27.setPunctuationMark('!');

        Sentence sentence2 = new Sentence();
        sentence2.addTextComponent(s20);
        sentence2.addTextComponent(s21);
        sentence2.addTextComponent(s22);
        sentence2.addTextComponent(s23);
        sentence2.addTextComponent(s24);
        sentence2.addTextComponent(s25);
        sentence2.addTextComponent(s26);
        sentence2.addTextComponent(s27);

        Paragraph paragraph2 = new Paragraph();
        paragraph2.addTextComponent(sentence2);

        textBook.addTextComponent(paragraph1);
        textBook.addTextComponent(codeListing);
        textBook.addTextComponent(paragraph2);
    }

    @Test
    void task2() {
        String task2 = textModifier.task2(textBook);
        Assertions.assertEquals(expectedStringTask2, task2);
    }

    @Test
    void task9() {
        String task9 = textModifier.task9(textBook);
        Assertions.assertEquals(expectedStringTask9, task9);
    }

    @Test
    void task2NullPointerException() {
        assertThrows(NullPointerException.class, () -> textModifier.task2(null));
    }
}