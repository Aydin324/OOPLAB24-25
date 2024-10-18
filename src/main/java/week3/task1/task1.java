package week3.task1;

import java.util.ArrayList;
import java.util.Collections;

public class task1 {
    public static void main(String[] args) {

        ArrayList<TaskItem> tasks = new ArrayList<TaskItem>();

        Collections.addAll(tasks,
                new TaskItem(1,"Push lab code to the github", TaskStatus.TO_DO),
                new TaskItem(2,"Prepare for the quiz", TaskStatus.IN_PROGRESS),
                new TaskItem(3,"Go over tasks from lab2", TaskStatus.COMPLETED));

        getAllObjects(tasks); //get all objects
        getByStatus(tasks, TaskStatus.COMPLETED); //get only those with specific status
        getByConditionalId(tasks, 2); //get only those with id equal to or greater than parameter
        getTaskDescriptions(tasks); //get description of each task

    }

    public static void getAllObjects(ArrayList<TaskItem> tasks){
        for(TaskItem t : tasks){
            t.printInfo();
        }
    }

    public static void getByStatus(ArrayList<TaskItem> tasks, TaskStatus status){
        for(TaskItem t : tasks){
            if(t.getTaskStatus() == status){
                t.printInfo();
            }
        }
    }

    public static void getByConditionalId(ArrayList<TaskItem> tasks, int id){
        for(TaskItem t : tasks){
            if(t.getId()>=id){
                t.printInfo();
            }
        }
    }

    public static void getTaskDescriptions(ArrayList<TaskItem> tasks){
        for(TaskItem t : tasks){
            System.out.println(t.getTaskDescription());
        }
    }
}
