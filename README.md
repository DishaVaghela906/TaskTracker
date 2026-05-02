# TaskTracker
This is a simple command-line interface (CLI) application for managing tasks. You can add, update, delete, mark, and list tasks directly from the terminal.

Features
Add a Task: Add a new task with a description.
Update a Task: Update the description of an existing task.
Delete a Task: Remove a task by its ID.
Mark a Task: Mark a task as "in progress" or "done."
List Tasks: List all tasks or filter them by status (e.g., todo, in progress, done).
Installation
Clone the repository:

git clone https://github.com/DishaVaghela906/TaskTracker.git
cd TaskTracker
Download the json-simple-1.1.1.jar file from the browser and put in size the folder
Compile the source code:

javac -cp ".;json-simple-1.1.1.jar" model/*.java  
Run the application:

java -cp ".;json-simple-1.1.1.jar" model.TaskTracker <command> [arguments]
Usage
# Adding a new task
java TaskCLIApp add 1 "Buy groceries" todo
# Output: Task added successfully (ID: 1)

# Updating a task
java -cp ".;json-simple-1.1.1.jar" model.TaskTracker update 1 "Buy groceries and cook dinner"
# Output: Task updated successfully (ID: 1)

# Deleting a task
java -cp ".;json-simple-1.1.1.jar" model.TaskTracker delete 1
# Output: Task deleted successfully (ID: 1)

# Marking a task as in progress
java -cp ".;json-simple-1.1.1.jar" model.TaskTracker mark-in-progress 1
# Output: Task marked as in progress (ID: 1)

# Marking a task as done
java -cp ".;json-simple-1.1.1.jar" model.TaskTracker mark-done 1
# Output: Task marked as done (ID: 1)

# Listing all tasks
java -cp ".;json-simple-1.1.1.jar" model.TaskTracker list
# Output: List of all tasks

# Listing tasks by status
java -cp ".;json-simple-1.1.1.jar" model.TaskTracker list todo
java -cp ".;json-simple-1.1.1.jar" model.TaskTracker list in-progress
java -cp ".;json-simple-1.1.1.jar" model.TaskTracker list done
