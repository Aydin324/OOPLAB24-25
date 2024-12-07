package week10.task1_annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        User admin = new AdminUser("Aydin");
        User regular = new RegularUser("Nidya");

        MessagingSystem system = new MessagingSystem();

        try{
            Method method = system.getClass().getMethod("sendMessage", User.class);
            if(method.isAnnotationPresent(RequiresPermission.class) && method.isAnnotationPresent(CanSendMessage.class)){
                method.invoke(system, admin);
                method.invoke(system, regular);
            }
        }
        catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
