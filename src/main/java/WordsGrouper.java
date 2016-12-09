import java.util.*;


/**
Группировщик слов.
 */
public class WordsGrouper {

    private static List<Character> wordToCharList(String word) {
        List<Character> list = new ArrayList<>();
        for(char c : word.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    private static boolean isWordsEqual(List<Character> word1, List<Character> word2) {
        return word1.subList(1, word1.size()).containsAll(word2.subList(1, word2.size())) &&
                word2.subList(1, word2.size()).containsAll(word1.subList(1, word1.size()));
    }

    private String charsToString (List<Character> chars) {
        StringBuilder result = new StringBuilder(chars.size());
        for (Character c : chars.subList(1, chars.size())) {
            result.append(c);
        }
        return result.toString();
    }

    public List<List<String>> arrayToList (String[][] words) {
        List<String[]> list = Arrays.asList(words);
        List result = new ArrayList();
        for(String[] array : list){
            result.add( Arrays.asList(array) );
        }
        return result;
    }

    public List<List<String>> groupWords (List<String> words) {

        List<List<Character>> list1 = new ArrayList<>();

        for (String word : words) {
            list1.add(wordToCharList("\u0000" + word));
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (isWordsEqual(list1.get(i), list1.get(j))) {
                    list1.get(i).set(0, (char) j);
                    break;
                } else {
                    list1.get(i).set(0, (char) i);
                }
            }
        }

        Map<String, List<String>> map = new HashMap<>();
        for (List<Character> s : list1) {
            String group = s.get(0).toString();
            if (map.get(group) == null) {
                List<String> groupList = new ArrayList<>();
                groupList.add(charsToString(s));
                map.put(group, groupList);
            } else {
                map.get(group).add(charsToString(s));
            }
        }

        return new ArrayList<>(map.values());
    }
}
