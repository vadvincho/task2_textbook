package com.vadzimvincho.textbook.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileManagerTest {
    private static String expectedString;
    private static FileManager fileManager;

    @BeforeAll
    static void init() {
        expectedString = "Это тестовый текст.\r\n" +
                "<listing>\r\n" +
                "public class MyObject implements Comparable<MyObject> {\r\n" +
                "\tdouble d;\r\n" +
                "}\r\n" +
                "</listing>\r\n" +
                "Вот всех, задачахттт!!\r\n";
        fileManager = new FileManager();
    }

    @Test
    void readTextbook() {
        String readFile = fileManager.readTextbook();
        Assertions.assertEquals(expectedString, readFile);
    }
}
