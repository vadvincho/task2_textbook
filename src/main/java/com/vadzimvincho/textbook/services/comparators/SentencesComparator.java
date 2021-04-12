package com.vadzimvincho.textbook.services.comparators;

import com.vadzimvincho.textbook.entity.Word;
import com.vadzimvincho.textbook.entity.ParagraphComponent;
import com.vadzimvincho.textbook.entity.SentenceComponent;

import java.util.List;

public enum SentencesComparator {
    SORT_BY_WORD_NUMBER {
        @Override
        public List<ParagraphComponent> sort(List<ParagraphComponent> sentences) {
            sentences.sort((o1, o2) -> {
                List<SentenceComponent> list1 = o1.getTextComponent();
                int i1 = (int) list1.stream().filter(sentenceComponent -> sentenceComponent instanceof Word).count();
                List<SentenceComponent> list2 = o2.getTextComponent();
                int i2 = (int) list2.stream().filter(sentenceComponent -> sentenceComponent instanceof Word).count();
                return Integer.compare(i1, i2);
            });
            return sentences;
        }
    };

    public abstract List<ParagraphComponent> sort(List<ParagraphComponent> sentences);
}
