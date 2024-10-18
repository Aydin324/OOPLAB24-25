package week3.task2;

enum TaskStatus{
    TO_DO, IN_PROGRESS, COMPLETED, CANCELLED
}

public class TaskItem {
    private int id;
    private String taskDescription;
    private TaskStatus taskStatus;

    TaskItem(int _id, String _taskDescription, TaskStatus _taskStatus){
        id = _id;
        taskDescription = _taskDescription;
        taskStatus = _taskStatus;
    }

    public void printInfo(){
        System.out.println("ID: "+id+" | Task Description: "+taskDescription+" | Task Status: "+taskStatus);
    }

    public int getId(){
        return id;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public TaskStatus getTaskStatus(){
        return taskStatus;
    }
}
