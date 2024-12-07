package week10.task1_annotations;

@UserPermission()
public class RegularUser extends User{
    public RegularUser(String username){
        super(username);
    }
}
