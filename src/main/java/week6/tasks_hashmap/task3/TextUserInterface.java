package week6.tasks_hashmap.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start(){
        String input = "";
        List<String> command = new ArrayList<String>();
        System.out.println("Welcome to the Dictionnary. You can use following commands:");
        System.out.println("\tquit, translate, add\n\nStatement:");
        while(true){
            input = reader.nextLine();
            command = asList(input.split(" "));
            if(command.getFirst().equals("quit")){
                System.out.println("Cheers!");
                break;
            }
            else if(command.getFirst().equals("translate")){
                System.out.println(dictionary.translate(command.get(1)));
            }
            else if(command.getFirst().equals("add")){
                dictionary.add(command.get(1), command.get(2));
            }
            else
                System.out.println("Unknown statement.");
            System.out.println("\nStatement: \n");
        }
    }
}
