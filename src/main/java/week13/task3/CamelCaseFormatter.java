package week13.task3;

public class CamelCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        String result = "";
        String[] words = text.split(" ");
        for(String word : words){
            char[] chars = word.toCharArray();
            for(int i=0; i<chars.length; i++){
                if(i==0) {
                    chars[0] = Character.toUpperCase(chars[0]);
                    continue;
                }
                chars[i] = Character.toLowerCase(chars[i]);
            }
            result += new String(chars);
        }
        return result;
    }
}
