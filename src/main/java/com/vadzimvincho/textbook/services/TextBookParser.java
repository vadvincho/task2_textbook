package com.vadzimvincho.textbook.services;

import com.vadzimvincho.textbook.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextBookParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextBookParser.class);

    public TextBook parseTextbook(String text) {
        LOGGER.info("Textbook parsing is started");
        TextBook textBook = new TextBook();
        List<String> paragraphList = splitUpTextbook(text);
        boolean isOpenListing = false;
        Paragraph paragraph;
        CodeListing codeListing = null;

        for (String paragraphString : paragraphList) {
            if (paragraphString.startsWith("<listing>") || isOpenListing) {
                if (paragraphString.startsWith("<listing>")) {
                    codeListing = new CodeListing();
                }
                isOpenListing = !paragraphString.startsWith("</listing>");
                CodeLine codeLine = new CodeLine();
                codeLine.setCodeLine(paragraphString);
                codeListing.addTextComponent(codeLine);
                if (!isOpenListing) {
                    textBook.addTextComponent(codeListing);
                }
            } else {
                List<String> sentenceList = splitUpParagraph(paragraphString);
                paragraph = new Paragraph();
                for (String sentenceString : sentenceList) {
                    List<String> wordOrPunctuationMarkList = splitUpSentence(sentenceString);
                    Sentence sentence = new Sentence();
                    for (String str : wordOrPunctuationMarkList) {
                        if (str.matches("[!.,;:?\\-\\s]")) {
                            PunctuationMark punctuationMark = new PunctuationMark();
                            punctuationMark.setPunctuationMark(str.charAt(0));
                            sentence.addTextComponent(punctuationMark);
                        } else {
                            Word word = new Word();
                            word.setWord(str);
                            sentence.addTextComponent(word);
                        }
                    }
                    paragraph.addTextComponent(sentence);
                }
                textBook.addTextComponent(paragraph);
            }
        }
        LOGGER.info("Textbook is ready");
        return textBook;
    }

    private List<String> splitUpTextbook(String text) {
        List<String> paragraphs = Arrays.stream(text.split("\\r?\\n"))
                .collect(Collectors.toList());
        return paragraphs;
    }

    private List<String> splitUpParagraph(String paragraphString) {
        List<String> sentences = Arrays.stream(paragraphString.split("(?<=[.!?])\\s+"))
                .collect(Collectors.toList());
        return sentences;
    }

    private List<String> splitUpSentence(String sentenceString) {
        List<String> words = Arrays.stream(sentenceString.split("((?<=[\\s\\p{Punct}])|(?=[\\s\\p{Punct}]))"))
                .collect(Collectors.toList());
        return words;
    }
}
