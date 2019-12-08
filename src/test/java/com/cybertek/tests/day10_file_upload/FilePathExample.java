package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {


    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/Adsız doküman.txt";

        String filePath = projectPath + "/" + relativePath;

    }
}
