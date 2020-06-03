package org.testing.gacha.Utils;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static void copyFile(String file, String dest) {
        try {
            File from = new File(file);
            File to = new File(dest);
            String toDir = to.getParent();
            mkdirs(toDir);
            FileUtils.copyFile(from, to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copyFile(File file, File dest) {
        String dir = dest.getParent();
        mkdirs(dir);
        try {
            FileUtils.copyFile(file, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mkdirs(String path) {
        File dest = new File(path);
        if (!dest.exists() && !dest.isDirectory()) {
            dest.mkdirs();
        }
    }
}
