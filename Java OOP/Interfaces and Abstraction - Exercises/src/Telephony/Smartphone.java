package Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;


    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("^[^0-9]+$");
        for (String url : this.urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                result.append(String.format("Browsing: %s!", url));
            } else {
                result.append(String.format("Invalid URL!"));
            }
            result.append(System.lineSeparator());

        }
        return result.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("^[0-9]+$");
        for (String number : this.numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                result.append(String.format("Calling... %s", number));
            } else {
                result.append(String.format("Invalid number!"));
            }
            result.append(System.lineSeparator());

        }
        return result.toString().trim();
    }
}
