public class workTasks extends Task implements Comparable<workTasks> {

    // This is an instance variable that would show the priority for a task and the type of a work task.
    private int priorityChoice;
    private int typeChoice;
    private boolean isCompleted;
    
    // This is the constructor for this class.
    public workTasks(int typeChoice, String description, boolean isCompleted, int priorityChoice) {
        super(typeChoice, description, false); 
        this.priorityChoice = priorityChoice;
        this.typeChoice = typeChoice;
        this.isCompleted = isCompleted;
    }

    // This is used to return the priority choice for a work task.
    public int getPriorityChoice() {
        return priorityChoice;
    }

    // Here is used to show to the user what they have completed.
    public void completeTask() {
        System.out.println("Task completed: " + getDescription());
        setCompleted();
    }

    // This would return all of the workTasks.
    @Override
    public String toString() {
        String typeChoiceString = "";
        // With this if-else block, we will set the work task type description to the object itself.
        if (typeChoice == 1) {
            typeChoiceString = "Work on project";
        }
        else if (typeChoice == 2) {
            typeChoiceString = "Working meetings";
        }
        else if (typeChoice == 3) {
            typeChoiceString = "Work sessions";
        }
        else if (typeChoice == 4) {
            typeChoiceString = "Other";
        }
        // We will now return a string that would display the object itself.
        return  "typeChoice = " + typeChoiceString +
                ", description = '" + getDescription() + 
                ", isCompleted = " + getIsCompleted() +
                ", priorityChoice = " + getPriorityChoice();
    }

    // This is used to sort tasks by priority using an if-else statement block.
    @Override
    public int compareTo(workTasks o) {
        if (this.priorityChoice > o.priorityChoice) {
            return 1;
        }
        else if (this.priorityChoice < o.priorityChoice) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
