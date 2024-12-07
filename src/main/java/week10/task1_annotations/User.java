package week10.task1_annotations;

public abstract class User {
    private String username;

    public User(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
