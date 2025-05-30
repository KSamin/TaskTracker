import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaskManager manager = new TaskManager();

        System.out.println("Welcome to Task Tracker CLI!");

        while (true) {
            System.out.println("\nCommands: add,delete,update,listAll,listDone,listInProgress,listUnDone,exit");
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if(input.equalsIgnoreCase("exit")){
                break;
            }else if(input.equalsIgnoreCase("add")){
                System.out.println("Enter description:");
                String description = scanner.nextLine();
                System.out.println("Enter status (todo,done,in-progress): ");
                String status = scanner.nextLine();
                manager.addTask(description, status);
            }else if(input.equalsIgnoreCase("delete")){
                System.out.println("Enter task id for deletion: ");
                int id = scanner.nextInt();
                manager.deleteTask(id);
            }else if(input.equalsIgnoreCase("update")){
                System.out.println("Enter status (todo,done,in-progress): ");
                String status = scanner.nextLine();
                System.out.println("Enter task id for update: ");
                int id = scanner.nextInt();
                
                manager.updateTask(id, status);
            }else if(input.equalsIgnoreCase("listAll")){
                manager.ListTasks();
            }else if(input.equalsIgnoreCase("listDone")){
                manager.ListDoneTasks();
            }else if(input.equalsIgnoreCase("listInProgress")){
                manager.ListinProgressTasks();
            }else if(input.equalsIgnoreCase("listUnDone")){
                manager.ListNotDoneTasks();
            }else{
                System.out.println("Unknown command");
            }
        }
        scanner.close();
        System.out.println("GoodBye!");
    }
    
}
