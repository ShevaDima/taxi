package com.solvd.taxi.StringTask;

import com.solvd.taxi.infrastructure.TaxiApp;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StringTask {
    private static final Logger log = LogManager.getLogger(TaxiApp.class);
    private static final File file = new File("src/main/java/com/solvd/taxi/StringTask/text.txt");
    private static String content = null;

    public static void read() {
        try {
            content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            log.info(e.getMessage());
        }
        log.info("File task\n");
        log.info(content);
        log.info("'we' matches\n");
        log.info(StringUtils.countMatches(content, "we"));
        log.info("\n\n");
    }
}
