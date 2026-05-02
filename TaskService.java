package model;

import java.io.File;
import java.util.List;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.time.LocalDateTime;



//service of task tracker like adding the task,updating the task ,delete the task
public class TaskService{
    //creating a json file to store the task data
    private File file = new File("tasks.json");

    public TaskService() {
        // Initialize the JSON file with an empty tasks array if it doesn't exist
        if (!file.exists()) {
            try {
                file.createNewFile();
                JSONObject jobj = new JSONObject();
                jobj.put("tasks", new JSONArray());
                FileWriter writer = new FileWriter(file);
                writer.write(jobj.toJSONString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //method to add task in json file
    public void addTask(Task task){
        
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader(file);
            Object obj = parser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray taskList = (JSONArray) jobj.get("tasks");

            JSONObject newTask = new JSONObject();
            newTask.put("id",task.getId());
            newTask.put("descritpion",task.getDescription());
            newTask.put("status",task.getStatus());
            newTask.put("createdAt",task.getCreatedAt().toString());
            newTask.put("updatedAt",task.getUpdatedAt().toString());

            taskList.add(newTask);
            //reader.flush();
            reader.close();
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(jobj.toJSONString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to update task in json file
    public void updateTask(int id,String description){
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader(file);
            Object obj = parser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray taskList = (JSONArray) jobj.get("tasks");
            if(taskList.size() == 0){
                System.out.println("No task found in the task list.");
                return;
            }
            else{
                for(int i=0;i<taskList.size();i++){
                    JSONObject task = (JSONObject) taskList.get(i);
                    if((long)task.get("id") == id){
                        task.put("descritpion",description);
                        task.put("updatedAt",java.time.LocalDateTime.now().toString());
                        break;
                    }
                    else{
                        System.out.println("No task found with the given id.");
                    }
                }
            }
            
            
            //reader.flush();
            reader.close();
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(jobj.toJSONString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to delete task in json file
    public void deleteTask(int id){
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader(file);
            Object obj = parser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray taskList = (JSONArray) jobj.get("tasks");
            if(taskList.size() == 0){
                System.out.println("No task found in the task list.");
                return;
            }
            else{
                for(int i=0;i<taskList.size();i++){
                    JSONObject task = (JSONObject) taskList.get(i);
                    if((long)task.get("id") == id){
                        taskList.remove(i);
                        break;
                    }else{
                        System.out.println("No task found with the given id for delete.");
                    }
                }
            }
            
            //reader.flush();
            reader.close();
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(jobj.toJSONString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to mark task as done in json file
    public void markTaskDone(int id){
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader(file);
            Object obj = parser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray taskList = (JSONArray) jobj.get("tasks");
            if(taskList.size() == 0){
                System.out.println("No task found in the task list.");
                return;
            }
            else{
                for(int i=0;i<taskList.size();i++){
                    JSONObject task = (JSONObject) taskList.get(i);
                    if((long)task.get("id") == id){
                        task.put("status","done");
                        task.put("updatedAt",java.time.LocalDateTime.now().toString());
                        break;
                    }else{
                        System.out.println("No task found with the given id for marking done.");
                    }
                }
            }
            
            //reader.flush();
            reader.close();
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(jobj.toJSONString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void markTaskInProgress(int id){
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader(file);
            Object obj = parser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray taskList = (JSONArray) jobj.get("tasks");
            if(taskList.size() == 0){
                System.out.println("No task found in the task list.");
                return;
            }
            else{
                for(int i=0;i<taskList.size();i++){
                    JSONObject task = (JSONObject) taskList.get(i);
                    if((long)task.get("id") == id){
                        task.put("status","in-progress");
                        task.put("updatedAt",java.time.LocalDateTime.now().toString());
                        break;
                    }else{
                        System.out.println("No task found with the given id for marking in-progress.");
                    }
                }
            }
            
            //reader.flush();
            reader.close();
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(jobj.toJSONString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //list by status

    public List<Task> getTasksByStatus(String status){
        //method to get task by status in json file
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader(file);
            Object obj = parser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray taskList = (JSONArray) jobj.get("tasks");
            if(taskList.size() == 0){
                System.out.println("No task found in the task list.");
                return null;
            }
            else{
                List<Task> filteredTasks = new ArrayList<>();
                for(int i=0;i<taskList.size();i++){
                    JSONObject task = (JSONObject) taskList.get(i);
                    if(task.get("status").equals(status)){
                        int id = ((Long)task.get("id")).intValue();
                        String description = (String) task.get("descritpion");
                        String taskStatus = (String) task.get("status");
                        LocalDateTime createdAt = LocalDateTime.parse((String) task.get("createdAt"));
                        LocalDateTime updatedAt = LocalDateTime.parse((String) task.get("updatedAt"));
                        filteredTasks.add(new Task(id,description,taskStatus));
                    }
                }
                reader.close();
                return filteredTasks;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //method to get all task in json file
    public List<Task> getAllTasks(){
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader(file);
            Object obj = parser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray taskList = (JSONArray) jobj.get("tasks");
            if(taskList.size() == 0){
                System.out.println("No task found in the task list.");
                return null;
            }
            else{
                List<Task> allTasks = new ArrayList<>();
                for(int i=0;i<taskList.size();i++){
                    JSONObject task = (JSONObject) taskList.get(i);
                    int id = ((Long)task.get("id")).intValue();
                    String description = (String) task.get("descritpion");
                    String status = (String) task.get("status");
                    LocalDateTime createdAt = LocalDateTime.parse((String) task.get("createdAt"));
                    LocalDateTime updatedAt = LocalDateTime.parse((String) task.get("updatedAt"));
                    allTasks.add(new Task(id,description,status));
                }
                reader.close();
                return allTasks;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}