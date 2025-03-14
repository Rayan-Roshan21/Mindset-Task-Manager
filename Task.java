public class Task {
    // These are instances variables.
    private String description;
    private int type;
    private boolean isCompleted;
    
    // Creating the task constructor.
    public Task(int typeChoice, String description, boolean isCompleted) {
        type = typeChoice;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    // This is for constructor overloading.
    public Task(int typeChoice, String description) {
        this.description = description;
        this.type = typeChoice;
        this.isCompleted = false;
    }
    
    // This is used to get the description of the task.
    public String getDescription() {
        return description;
    }

    // This is used to return what kind of the task it is.
    public int getType() {
        return type;
    }
    
    // This is used to check what is completed.
    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted() {
        this.isCompleted = true;
    }

    // This is used to print out the given task.
    @Override
    public String toString() {
        return "Type: " + type + "\nDescription: " + description;
    }
    
    // This is used to check if two tasks are the same class and task itself.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Task task = (Task) obj;
        return type == task.type && description.equals(task.description) && isCompleted == task.isCompleted;
    }
}
