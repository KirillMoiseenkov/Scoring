package com.example.demo;

import com.example.demo.utils.DataType;
import com.example.demo.utils.factory.ScoringXMLTagCreatorCommon;
import com.example.demo.utils.factory.model.ScoringXMLTagCommonEntity;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class mainTest {

    public static void main(String[] args) throws IOException {

        Long l = 1L;

        String s = "vasya";

        checkObj(l);

    }


    public static void checkObj(Object object){

        System.out.println(object.toString());

    }

}
