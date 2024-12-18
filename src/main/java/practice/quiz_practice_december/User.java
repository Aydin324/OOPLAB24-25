package practice.quiz_practice_december;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String username;
    private String password;
    private int id;
    private String email;

    public User(String username, String password, int id, String email) {
        if(password.length()<5){ throw new PasswordSmallerThanFiveCharactersException("Pass ex");}
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
    }

    public void writeToFile(){
        try(BufferedWriter br = new BufferedWriter(new FileWriter("userDetails.txt"))){
            br.write(username+"\n"+password);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //getters
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public int getId() {return id;}
    public String getEmail() {return email;}
}
