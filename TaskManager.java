import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int taskCounter = 1;

    private final File storageFile = new File("tasks.json");
    private final ObjectMapper mapper;

    {
        mapper = new ObjectMapper();
        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        mapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public void addTask(String description, String status){
        Task task = new Task(taskCounter++, description,status);
        tasks.add(task);
        saveTasksToFile();
        System.out.println("Task Added: "+ task);
    }
    public void updateTask(int id,String status){
        for(Task task:tasks){
            if(task.getId() == id){
                task.updateStatus(status);
                task.updateTaskTime();
                saveTasksToFile();
            }
        }
    }
    public void deleteTask(int id){
        Iterator<Task> iterator = tasks.iterator();

        while(iterator.hasNext()){
            Task task = iterator.next();
            if(task.getId()==id){
                iterator.remove();
                saveTasksToFile();
                System.out.println("Delete Task with id: "+ id);
                return;
            }
        }
        System.out.println("Task with Id"+id+" not found.");
    }
    public void ListTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("id" + " | " + "description" + " | " + "status" + "       | " + "createdAt" + "                             | " + "updatedAt" + "                             | ");
        for(Task task:tasks){
            System.out.println(task);
        }
    }
    public void ListDoneTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("id" + " | " + "description" + " | " + "status" + "       | " + "createdAt" + "                             | " + "updatedAt" + "                             | ");
        for(Task task:tasks){
            if(task.getStatus().equals("done")){
                System.out.println(task);
            }
        }
    }
    public void ListNotDoneTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("id" + " | " + "description" + " | " + "status" + "       | " + "createdAt" + "                             | " + "updatedAt" + "                             | ");        for(Task task:tasks){
            if(!task.getStatus().equals("done")){
                System.out.println(task);
            }
        }
    }
    public void ListinProgressTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("id" + " | " + "description" + " | " + "status" + "       | " + "createdAt" + "                             | " + "updatedAt" + "                             | ");
        for(Task task:tasks){
            if(task.getStatus().equals("in-progress")){
                System.out.println(task);
            }
        }
    }
    private void saveTasksToFile() {
        try {
            mapper.writeValue(storageFile, tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
    private void loadTasksFromFile() {
        if (!storageFile.exists()) {
            return;
        }
        try {
            CollectionType listType = mapper.getTypeFactory()
                    .constructCollectionType(ArrayList.class, Task.class);
            tasks = mapper.readValue(storageFile, listType);

            // update taskCounter to avoid ID collision
            for (Task task : tasks) {
                taskCounter = Math.max(taskCounter, task.getId() + 1);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}