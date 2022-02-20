package com.progressoft.tools;

import java.nio.file.Path;
import java.util.List;

public interface FileReader {
    List<List<String>> readFile(Path path);
}
