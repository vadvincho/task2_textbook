package com.vadzimvincho.textbook.services.comparators;

import com.vadzimvincho.textbook.entity.Word;

import java.util.List;

public enum WordsComparator {
    SORT_BY_SYMBOL_NUMBER {
        @Override
        public List<Word> sort(List<Word> words, char symbol) {
            words.sort((o1, o2) -> {
                long i1 = o1.getTextComponentToString().chars().filter(ch -> ch == symbol).count();
                long i2 = o2.getTextComponentToString().chars().filter(ch -> ch == symbol).count();
                int compare = Integer.compare((int) i1, (int) i2);
                return compare != 0 ? compare : o1.getTextComponentToString().compareTo(o2.getTextComponentToString());
            });
            return words;
        }
    };

    public abstract List<Word> sort(List<Word> words, char symbol);
}
