import java.time.LocalDateTime;

public class Task {

    private int id;
    private String description;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(){}
    public Task(int id,String description,String status){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }
    public void updateTaskTime(){
        this.updatedAt = LocalDateTime.now();
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public String getStatus(){
        return status;
    }
    public void updateStatus(String status){
        this.status = status;
    }
    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
    public int getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }

    
    public String toString(){
        return id + " | " + description + " | " + status + " | " + createdAt + " | " + updatedAt;
    }
    
}