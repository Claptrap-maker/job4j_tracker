package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("lelik575435@gmail.com", "Иванова Юлия Николаевна");
        map.put("fabulousNick337@yandex.ru", "Иванова Юлия Николаевна");
        map.put("lelik575435@gmail.com", "Петров Николай Иванович");
        map.put("petrov@mail.com", "Иванова Юлия Николаевна");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " | " + value);
        }
    }
}
