package com.vadzimvincho.textbook.services;

import com.vadzimvincho.textbook.entity.Paragraph;
import com.vadzimvincho.textbook.entity.TextBook;
import com.vadzimvincho.textbook.entity.Word;
import com.vadzimvincho.textbook.entity.ParagraphComponent;
import com.vadzimvincho.textbook.entity.SentenceComponent;
import com.vadzimvincho.textbook.entity.TextBookComponent;
import com.vadzimvincho.textbook.services.comparators.SentencesComparator;
import com.vadzimvincho.textbook.services.comparators.WordsComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextModifier {
    //  2.	Вывести все предложения заданного текста в порядке возрастания
//        количества слов в каждом из них.
    public String task2(TextBook textBook) {
        List<ParagraphComponent> sentences = new ArrayList<>();
        for (TextBookComponent textBookComponent : textBook.getTextComponent()) {
            if(textBookComponent instanceof Paragraph){
                List<ParagraphComponent> paragraphComponents = textBookComponent.getTextComponent();
                sentences.addAll(paragraphComponents);
            }
        }
        List<ParagraphComponent> resultList = SentencesComparator.SORT_BY_WORD_NUMBER.sort(sentences);
        String resultString = resultList.stream()
                .map(paragraphComponent -> paragraphComponent.getTextComponentToString() + "\n")
                .collect(Collectors.joining());
        return resultString;
    }

//    9.	Все слова текста рассортировать по возрастанию количества заданной буквы в слове.
//    Слова с одинаковым коли¬чеством расположить в алфавитном порядке.
    public String task9(TextBook textBook) {
        List<Word> words = new ArrayList<>();
        List<TextBookComponent> textBookComponents = textBook.getTextComponent();
        for (TextBookComponent textBookComponent : textBookComponents) {
            if(textBookComponent instanceof Paragraph){
                List<ParagraphComponent> paragraphComponents = textBookComponent.getTextComponent();
                for (ParagraphComponent paragraphComponent : paragraphComponents) {
                    List<SentenceComponent> sentenceComponents = paragraphComponent.getTextComponent();
                    for (SentenceComponent sentenceComponent : sentenceComponents) {
                        if (sentenceComponent instanceof Word) {
                            words.add((Word) sentenceComponent);
                        }
                    }
                }
            }
        }
        WordsComparator.SORT_BY_SYMBOL_NUMBER.sort(words,'т');
        String resultString = words.stream()
                .map(word -> word.getTextComponentToString() + "\n")
                .collect(Collectors.joining());
        return resultString;
    }
}
