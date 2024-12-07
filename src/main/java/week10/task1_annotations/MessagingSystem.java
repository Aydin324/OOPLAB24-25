package week10.task1_annotations;

public class MessagingSystem {

    @CanSendMessage()
    @RequiresPermission(requiresAdminPermission = true)
    public void sendMessage(User user){
        Class<? extends User> argClass = user.getClass();

        if(argClass.isAnnotationPresent(UserPermission.class)){
            UserPermission userPermission = argClass.getAnnotation(UserPermission.class);
            boolean hasAdminPermission = userPermission.adminPermission();

            if(hasAdminPermission){
                System.out.println(user.getUsername() + " (Admin) sent a message.");
            }
            else{
                System.out.println(user.getUsername() + " (Regular User) cannot send a message.");
            }
        }
        else{
            System.out.println("User of unknown permissions - " + user.getUsername());
        }
    }

}
