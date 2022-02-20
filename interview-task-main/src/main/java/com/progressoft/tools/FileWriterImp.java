package com.progressoft.tools;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImp implements FileWriter {

    @Override
    public void writeFile(List<String> data, Path destPath) {
        if (destPath == null || data == null)
            throw new IllegalArgumentException("Can not export with null values");
        try (java.io.FileWriter csvWriter = new java.io.FileWriter(String.valueOf(destPath),true)) {
            csvWriter.append(String.join(",", data));
            csvWriter.append("\n");
        } catch (IOException e) {
            throw new IllegalStateException("Error while writing",e);
        }
    }
}
