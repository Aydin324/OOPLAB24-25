package week6.task_libraryInformationSystem;

public class StringUtils {
    public static boolean included(String word, String searched){
        word = word.toLowerCase();
        searched = searched.toLowerCase();
        searched = searched.trim();
        return word.contains(searched);
    }
}
