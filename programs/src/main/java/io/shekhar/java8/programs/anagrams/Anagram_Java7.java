package io.shekhar.java8.programs.anagrams;

import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Two or more words can be composed of the same characters, but in a different order.
 * Using the word list at http://www.puzzlers.org/pub/wordlists/unixdict.txt,
 * find the sets of words that share the same characters that contain the most words in them.
 */
public class Anagram_Java7 {

    public Map<String, List<String>> anagramGroups(String path) throws Exception {

        List<String> lines = Files.readAllLines(Paths.get(path));

        Map<String, List<String>> anagrams = new HashMap<>();
        int count = 0;
        for (String word : lines) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!anagrams.containsKey(key))
                anagrams.put(key, new ArrayList<>());
            anagrams.get(key).add(word);
            count = Math.max(count, anagrams.get(key).size());
        }
        return anagrams;
    }
}