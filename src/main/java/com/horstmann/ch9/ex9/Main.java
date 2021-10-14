package com.horstmann.ch9.ex9;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Collectors;

/**
 * Используя класс URLConnection, введите данные с веб-страницы, защищенной паролем с элементарной аутентификацией.
 * Соедините вместе имя пользователя, двоеточие, пароль и определите кодировку Base64 полученного результата
 * следующим образом:
 * String input = username + : + password;
 * String encoding = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
 * Установите в HTTP-заголовке Authorization значение "Basic" + encoding , a
 * затем введите содержимое страницы и выведите его на экран.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://jigsaw.w3.org/HTTP/Basic/");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("Authorization", generateBasicPassword("guest", "guest"));
        urlConnection.setDoInput(true);
        try (InputStream in = urlConnection.getInputStream()) {
            Reader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = bufferedReader.lines().collect(Collectors.joining("\n"));
            System.out.println(data);
        }
    }

    private static String generateBasicPassword(String login, String password) {
        String input = login + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }
}
