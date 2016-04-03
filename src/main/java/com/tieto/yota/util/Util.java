package com.tieto.yota.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.io.IOException;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Util {
    private static Process process;

    public static void startApp() throws IOException {
        if (process == null) {
            String path = Paths.get("app.jar").toFile().getCanonicalPath();
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", path);
            process = pb.start();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    stopApp();
                }
            });
        }
    }

    public static void stopApp() {
        if (process != null) {
            process.destroyForcibly();
            process = null;
        }
    }

    public static void resetApp() throws IOException {
        stopApp();
        FileUtils.deleteDirectory(Paths.get("sliderDB").toFile());
        startApp();
    }

    public static void waitForJQuery() {
        Wait().until((ExpectedCondition<Object>) webDriver -> executeJavaScript("return jQuery.active").equals(0L));
    }
}
