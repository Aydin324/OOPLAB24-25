package week13.task3;

public class Main {
    public static void main(String[] args) {
        //instantiate editor
        TextEditor textEditor = new TextEditor();

        //test
        textEditor.setFormatter(new UpperCaseFormatter());
        System.out.println("This is upper case: " + textEditor.formatText("abdaSfabsf"));

        textEditor.setFormatter(new LowerCaseFormatter());
        System.out.println("This is lower case: " + textEditor.formatText("fjsSDVVNSvkkv"));

        textEditor.setFormatter(new CamelCaseFormatter());
        System.out.println("This is camel case: " + textEditor.formatText("aydin Is BEST"));
    }
}
