package com.example.spring_data_intro.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUtil {
    String[] readFileContent (String filePath) throws IOException;
}
