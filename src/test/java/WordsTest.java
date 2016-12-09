import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


/**
Тесты ддя проверки группировки слов.
 */
public class WordsTest {

    WordsGrouper wordsGrouper = new WordsGrouper();

    @Test()
    public void EmptyList() {
        List<String> words = Arrays.asList();
        String[][] expectedList = {};;
        assertEquals("Пустой список слов, нет групп",
                wordsGrouper.arrayToList(expectedList), wordsGrouper.groupWords(words));
    }


    @Test()
    public void OneWord() {
        List<String> words = Arrays.asList("kxe");
        String[][] expectedList = {{"kxe"}};;
        assertEquals("Одно слово, одна группа",
                wordsGrouper.arrayToList(expectedList), wordsGrouper.groupWords(words));
    }

    @Test()
    public void TwoWordsTwoGroups() {
        List<String> words = Arrays.asList("abc", "kxe");
        String[][] expectedList = {{"abc"}, {"kxe"}};;
        assertEquals("Два слова, две группы",
                wordsGrouper.arrayToList(expectedList), wordsGrouper.groupWords(words));
    }

    @Test()
    public void TwoWordsOneGroup() {
        List<String> words = Arrays.asList("abc", "abc");
        String[][] expectedList = {{"abc", "abc"}};;
        assertEquals("Два одинаковых слова, одна группа",
                wordsGrouper.arrayToList(expectedList), wordsGrouper.groupWords(words));
    }


    @Test()
    public void ThreeWordsTwoGroups() {
        List<String> words = Arrays.asList("abc", "kxe", "abc");
        String[][] expectedList = {{"abc", "abc"}, {"kxe"}};;
        assertEquals("Три слова, две группы",
                wordsGrouper.arrayToList(expectedList), wordsGrouper.groupWords(words));
    }


    @Test
    public void ManyWords() {
        List<String> words = Arrays.asList("kxe", "cccc", "cdba", "ccd", "dcc", "qwert", "abcd", "bcda", "exk", "cccc");
        String[][] expectedList = {{"kxe", "exk"}, {"cccc", "cccc"}, {"cdba", "abcd", "bcda"}, {"ccd", "dcc"}, {"qwert"}};;
        assertEquals("Много слов, много групп",
                wordsGrouper.arrayToList(expectedList), wordsGrouper.groupWords(words));
    }

}
