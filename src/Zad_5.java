import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Zad_5 {

    public static void main(String[] args) {

        String web = "https://onet.pl/";
        String File = "popular_words.txt";
        String words = getPopularWords(web);
        saveToFile(words, File);
        String filtered = filteredWords(File);
        saveToFile(filtered, "filtered_popular_words.txt");
        System.out.println("Done :)");

    }

    private static String getPopularWords(String url) {
        Connection connect = Jsoup.connect(url);
        String buffer = "";

        try {
            Document document = connect.get();
            Elements links = document.select("span.title");

            for (Element elem : links) {
                buffer += elem.text() + " ";
            }
            buffer = buffer.replaceAll("[\"?!;:,.\']", "");

        } catch (IOException e) {
            System.out.println("Data couldn't be downloaded");
        }
        return buffer;
    }

    private static void saveToFile(String text, String filename) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("Data couldn't be saved");
        }
    }

    private static String filteredWords(String filename) {
        String[] excludedWords = {"oraz", "ponieważ", "się", "więc", "i", "a", "o", "że"};
        String word = "";
        String result = "";

        try {
            Scanner file = new Scanner(new File(filename));

            while (file.hasNext()) {
                word = file.next();
                int i = 0;
                for (i = 0; i < excludedWords.length; i++) {
                    if (word.equals(excludedWords[i]) || word.length() < 3) {
                        break;
                    }
                }
                if (i == excludedWords.length) {
                    result += word + " ";
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
