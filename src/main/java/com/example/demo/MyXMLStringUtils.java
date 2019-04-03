package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MyXMLStringUtils {

    public String path = "Experian_REQUEST.xml";

    public static String getXmlToString() throws IOException {

        byte[] encoded = Files.readAllBytes(Paths.get("/Users/kirillmoiseenkov/Downloads/demo/src/main/resources/Experian_REQUEST.xml"));

        String xml =  new String(encoded, StandardCharsets.UTF_8);

        return xml;
    }

}
