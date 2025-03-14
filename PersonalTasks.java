public class PersonalTasks extends Task implements Comparable<PersonalTasks>{
    
    // Here are you instance variables for this class.
    private int typeChoice;
    private boolean isCompleted;

    // This is the constructor. Here we are grabbing necessary values and methods from Task.java
    public PersonalTasks(int typeChoice, String description, boolean isCompleted) {
        super(typeChoice, description, false); 
        this.typeChoice = typeChoice;
        this.isCompleted = isCompleted;
    }

    // Here is used to show to the user what they have completed.
    public void completeTask() {
        System.out.println("Task completed: " + getDescription());
        setCompleted();
    }

    // This is used to show all of the personal tasks that have been added and to see if they have been completed.
    @Override
    public String toString() {
        String typeChoiceString = "";
        // With this if-else block, we will set the personal task type description to the object itself.
        if (typeChoice == 1) {
            typeChoiceString = "Mental health";
        }
        else if (typeChoice == 2) {
            typeChoiceString = "House Chores";
        }
        else if (typeChoice == 3) {
            typeChoiceString = "Studying";
        }
        else if (typeChoice == 4) {
            typeChoiceString = "Other";
        }
        // We will now return a string that would display the object itself.
        return  "typeChoice = " + typeChoiceString + " task" +
                ", description = " + getDescription() + 
                ", isCompleted = " + getIsCompleted();
    }

    // This is used to sort tasks by priority.
    @Override
    public int compareTo(PersonalTasks o) {
        if (this.typeChoice > o.typeChoice) {
            return 1;
        }
        else if (this.typeChoice < o.typeChoice) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
