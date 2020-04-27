package fr.fingarde.mineandglory.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils
{
    public static boolean matching(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.find();
    }

    public static List<String> getMatches(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        List<String> result = new LinkedList<>();
        matcher.results().forEach(matchResult -> result.add(matchResult.group()));

        return result;
    }
}
