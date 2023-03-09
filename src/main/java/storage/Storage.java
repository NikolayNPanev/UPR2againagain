package storage;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class Storage {


    private  static int id = 0;
    private static Storage instance;
    private List<Task> tasks = new ArrayList<>();

    //Storage singleton
    private Storage(){

    }
    public static Storage getInstance(){
        if(instance==null)
            instance = new Storage();
        return instance;
    }

    public void addTask(Task task){
        if(instance==null)
            return;
        tasks.add(task);
    }

    public List getTasks(){
        return tasks;
    }

}
