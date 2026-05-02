package model;
import java.util.List;
public class TaskTracker {
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Please provide a task name as an argument.");
            return;
        }

        String task = args[0];
        TaskService taskService = new TaskService();
        switch (task.toLowerCase()) {
            case "add" :
                //add task
                int id = Integer.parseInt(args[1]);
                String description = args[2];
                String status = args[3];
                taskService.addTask(new Task(id, description, status));
                System.out.println("Task added successfully.");
                break;
            case "update":
                //update task
                int updateId = Integer.parseInt(args[1]);
                String updateDescription = args[2];
                taskService.updateTask(updateId, updateDescription);
                System.out.println("Task updated successfully.");
                break;
            case "delete":
                //delete task
                int deleteId = Integer.parseInt(args[1]);
                taskService.deleteTask(deleteId);
                System.out.println("Task deleted successfully.");
                break;
            case "mark-done":
                //done task marking
                int doneId = Integer.parseInt(args[1]);
                taskService.markTaskDone(doneId);
                System.out.println("Task marked as done successfully.");
                break;
            case "mark-in-progress":
                //in progress marking
                int inProgressId = Integer.parseInt(args[1]);
                taskService.markTaskInProgress(inProgressId);
                System.out.println("Task marked as in progress successfully.");
                break;
            case "list":

                //listing task
                if(args.length == 1){
                    List<Task> allTasks = taskService.getAllTasks();
                    System.out.println("All Tasks:");
                    for (Task t : allTasks) {
                        System.out.println("ID: " + t.getId() + ", Description: " + t.getDescription() + ", Status: " + t.getStatus() + ", Created At: " + t.getCreatedAt() + ", Updated At: " + t.getUpdatedAt());
                    }
                    break;
                }
                else{
                    String filter = args[1];
                    switch (filter.toLowerCase()) {
                        case "done":
                            //list done task
                            List<Task> doneTasks = taskService.getTasksByStatus("done");
                            System.out.println("Done Tasks:");
                            for (Task t : doneTasks) {
                                System.out.println("ID: " + t.getId() + ", Description: " + t.getDescription() + ", Status: " + t.getStatus() + ", Created At: " + t.getCreatedAt() + ", Updated At: " + t.getUpdatedAt());
                            }
                            break;
                        case "in-progress":
                            //list in-progress task
                            List<Task> inProgressTasks = taskService.getTasksByStatus("in-progress");
                            System.out.println("In-Progress Tasks:");
                            for (Task t : inProgressTasks) {
                                System.out.println("ID: " + t.getId() + ", Description: " + t.getDescription() + ", Status: " + t.getStatus() + ", Created At: " + t.getCreatedAt() + ", Updated At: " + t.getUpdatedAt());
                            }
                            break;
                        case "todo":
                            //list todo task
                            List<Task> todoTasks = taskService.getTasksByStatus("TODO");
                            System.out.println("TODO Tasks:");
                            for (Task t : todoTasks) {
                                System.out.println("ID: " + t.getId() + ", Description: " + t.getDescription() + ", Status: " + t.getStatus() + ", Created At: " + t.getCreatedAt() + ", Updated At: " + t.getUpdatedAt());
                            }
                            break;
                        default:
                            System.out.println("Invalid filter for listing tasks. Use 'done', 'in-progress', or 'TODO'.");
                            break;
                    }
                }
                break;
            default:
                System.out.println("invalid command for task");
                break;
        }
    }
}