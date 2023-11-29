import java.io.*;
import java.util.*;

public class FilterOfFile {
  List<String> linesFromStartFile = new ArrayList<>();
  List<String> filterWords = new ArrayList<>();

  public FilterOfFile(List<String> linesFromStartFile, List<String> filterWords) {
    this.linesFromStartFile = linesFromStartFile;
    this.filterWords = filterWords;
  }

  public List<String> filter() {
    List<String> resultLines = linesFromStartFile.stream()
        .filter(this::lineNotContainsOneOfFilterWords)
        .toList();
    return resultLines;
  }

  public boolean lineNotContainsOneOfFilterWords(String line) {
    boolean flag = true;
    for (String filterWord : filterWords) {
      if (line.contains(filterWord)) {
        flag = false;
        break;
      }
    }
    return flag;
  }
}
