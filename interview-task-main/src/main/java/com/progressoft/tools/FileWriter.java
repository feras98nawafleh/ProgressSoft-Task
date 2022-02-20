package com.progressoft.tools;

import java.nio.file.Path;
import java.util.List;

public interface FileWriter {
    void writeFile(List<String> data, Path destPath);
}
