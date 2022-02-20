package com.progressoft.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderImp implements FileReader {
    @Override
    public List<List<String>> readFile(Path path) {
        if (path == null)
            throw new IllegalArgumentException("Can not import with null value");

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(String.valueOf(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException ee){
            throw new IllegalArgumentException("source file not found");
        } catch (IOException e) {
            throw new IllegalStateException("Error while reading");
        }
        return records;
    }
}
