import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("Empty input");
    } else {
      String nameOfStartFile = args[0];
      String nameOfFilterFile = args[1];
      String nameOfResultFile = args[2];
      String line;
      List<String> linesFromStartFile = new ArrayList<>();
      List<String> filterWords = new ArrayList<>();
      try (var startFile = new BufferedReader(new FileReader(nameOfStartFile))) {
        while ((line = startFile.readLine()) != null) {
          linesFromStartFile.add(line);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try (var filterFile = new BufferedReader(new FileReader(nameOfFilterFile))) {
        while ((line = filterFile.readLine()) != null) {
          filterWords.add(line);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      FilterOfFile filterOfFile = new FilterOfFile(linesFromStartFile, filterWords);
      try (var resultFile = new FileWriter(nameOfResultFile)) {
        List<String> resultLines = filterOfFile.filter();
        for (String resultLine : resultLines) {
          resultFile.write(resultLine + "\n");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
