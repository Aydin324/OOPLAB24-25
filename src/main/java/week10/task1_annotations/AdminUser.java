package week10.task1_annotations;

@UserPermission(adminPermission = true)
public class AdminUser extends User{
    public AdminUser(String username){
        super(username);
    }
}
