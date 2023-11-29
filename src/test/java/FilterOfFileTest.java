import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.Stream;

public class FilterOfFileTest {
  List<String> linesFromStartFile = Stream.of("Необходимо реализовать класс, который будет делать",
      "фильтрацию данных в файле по специальному словарю - ",
      "если в строчке встречается слово из списка, то эта строка",
      " исключается.").toList();
  List<String> filterWords = Stream.of("Необходимо", "класс", "файле").toList();
  List<String> resultLines = new ArrayList<>(Stream.of("если в строчке встречается слово из списка, то эта строка",
      " исключается.").toList());
  FilterOfFile filterOfFile = new FilterOfFile(linesFromStartFile, filterWords);

  @Test
  public void lineNotContainsOneOfFilterWordsTest() {
    Assertions.assertFalse(filterOfFile.lineNotContainsOneOfFilterWords("Необходимо реализовать класс, который будет делать"));
    Assertions.assertTrue(filterOfFile.lineNotContainsOneOfFilterWords(" исключается."));
  }

  @Test
  public void filterTest() {
    Assertions.assertEquals(resultLines, filterOfFile.filter());
  }
}
