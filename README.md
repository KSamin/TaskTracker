
# 📝 Java CLI Task Tracker
Project Task URL : https://roadmap.sh/projects/task-tracker
This is a simple Command Line Interface (CLI) based **Task Tracker** project built using **Java**, **Maven**, and **Jackson** for JSON file handling. It allows users to manage tasks with features like adding, listing, updating, and deleting tasks.

## 🚀 Features

- ✅ Add a new task
- 📋 List all tasks
- 🔍 Filter tasks by status (`done`, `not-done`, `in-progress`)
- ✏️ Update the status of a task
- ❌ Delete a task by ID
- 💾 Tasks are stored persistently in a `tasks.json` file


---

## 🛠️ Tech Stack

- Java 20
- Maven
- Jackson (for JSON serialization)
  

---



## ⚙️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/KSamin/TaskTracker.git
cd task-tracker-cli-java
```
### 2. Compile the project
```bash
mvn clean install
```
### 3. Run the CLI
```bash
java -cp target/classes Main
```
## tasks.json
```bash
[
  {
    "id": 1,
    "description": "Buy groceries",
    "status": "done",
    "createdAt": "2025-05-28T15:30:12.453",
    "updatedAt": "2025-05-28T15:45:00.123"
  }
]
```
## Example
```bash
Welcome to Task Tracker CLI!

Commands: add,delete,update,listAll,listDone,listInProgress,listUnDone,exit
> add
Enter description:
POTD
Enter status (todo,done,in-progress): 
todo
Task Added: 1 | POTD | todo | 2025-05-31T23:06:57.766442800 | 2025-05-31T23:06:57.766442800

Commands: add,delete,update,listAll,listDone,listInProgress,listUnDone,exit
> add
Enter description:
system Design
Enter status (todo,done,in-progress): 
in-progress
Task Added: 2 | system Design | in-progress | 2025-05-31T23:07:15.117528800 | 2025-05-31T23:07:15.117528800

Commands: add,delete,update,listAll,listDone,listInProgress,listUnDone,exit
> update
Enter status (todo,done,in-progress): 
done
Enter task id for update: 
1

Commands: add,delete,update,listAll,listDone,listInProgress,listUnDone,exit
> Unknown command

Commands: add,delete,update,listAll,listDone,listInProgress,listUnDone,exit
> listAll
id | description | status       | createdAt                             | updatedAt                             | 
1 | POTD | done | 2025-05-31T23:06:57.766442800 | 2025-05-31T23:07:24.328516
2 | system Design | in-progress | 2025-05-31T23:07:15.117528800 | 2025-05-31T23:07:15.117528800

Commands: add,delete,update,listAll,listDone,listInProgress,listUnDone,exit
> listDone
id | description | status       | createdAt                             | updatedAt                             | 
1 | POTD | done | 2025-05-31T23:06:57.766442800 | 2025-05-31T23:07:24.328516

Commands: add,delete,update,listAll,listDone,listInProgress,listUnDone,exit

```
