package com.example.selenium.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    public static void saveBytesToFile(byte[] bytes, String fileName) throws IOException {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bytes);
        }
    }
}
