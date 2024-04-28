package com.example.selenium.Utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class ConfigReader {

    private Properties properties;

    // Read from properties files and returns properties object
    public Properties initProp() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/application.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            log.info("Unable to read Properties file.");
        }
        return properties;
    }

    public List<Map<String, String>> csvToMap(String csvFileName) {
        List<Map<String, String>> lines = new ArrayList<>();
        String line;
        String csvSplitBy = ",";
        try {
            Properties props = initProp();
            String csvFilePath = props.getProperty("csv.file.path") + File.separator + csvFileName;
            BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
            line = br.readLine();
            List<String> firstLine = Arrays.asList(line.split(csvSplitBy));
            while ((line = br.readLine()) != null) {
                List<String> data = Arrays.asList(line.split(csvSplitBy));
                Map<String, String> map = IntStream.range(0, firstLine.size())
                        .boxed()
                        .collect(Collectors.toMap(firstLine::get, data::get));
                lines.add(map);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
