package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class InterviewTask {
    private static final String OPEN_TITLE_TAG = "<title>";
    private static final String CLOSE_TITLE_TAG = "</title>";

    private InterviewTask() {

    }

    public static String findUrlTitle(String[] args) throws IOException {
        Optional<URL> url = Optional.empty();
        try {
            url = Optional.of(new URL(args[0]));
        } catch (MalformedURLException e) {
            System.err.println("Wrong URL");
        }
        InputStream inputStream;
        inputStream = url.orElseThrow(
                () -> new IOException("Can't open stream for such a URL")).openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.matches(String.format("%s(.*?)%s", OPEN_TITLE_TAG, CLOSE_TITLE_TAG))) {
                    String titleValueTag = trimmedLine.substring(trimmedLine.indexOf(OPEN_TITLE_TAG) + OPEN_TITLE_TAG.length(), trimmedLine.indexOf(CLOSE_TITLE_TAG));
                    System.out.println(titleValueTag);
                    return titleValueTag;
                }
            }
        }
        return "";
    }
}
