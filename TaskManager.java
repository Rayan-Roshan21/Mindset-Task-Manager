import java.util.ArrayList;
import java.util.Collections;

public class TaskManager {
    // Here are the instances variables that are for the arraylist.
    private ArrayList<PersonalTasks> personalTasksList;
    private ArrayList<workTasks> workTasksList;
    private ArrayList<PersonalTasks> compledtedPersonalTasks;
    private ArrayList<workTasks> completedWorkTasks;

    // Here is the constructor for this class.
    public TaskManager() {
        // These are the arraylist that we will be using to hold the different tasks.
        personalTasksList = new ArrayList<PersonalTasks>();
        workTasksList = new ArrayList<workTasks>();
        compledtedPersonalTasks = new ArrayList<PersonalTasks>();
        completedWorkTasks = new ArrayList<workTasks>();
    }

    // This is used add spacing.
    public void spacing() {
        System.out.println("*-----------------------------------------------------*");
    }

    // This is used get the 
    public ArrayList<PersonalTasks> getPersonalTasksList() {
        return personalTasksList;
    }

    public ArrayList<workTasks> getWorkTasksList() {
        return workTasksList;
    }

    // This is used to add a personal task to the personalTasksList.
    public void addPersonalTask(PersonalTasks pt) {
        personalTasksList.add(pt);
        Collections.sort(personalTasksList);
        System.out.println("Task added: " + pt.getDescription());
    }

    // This is used to get a personal task from the list.
    public PersonalTasks getPersonalTask(int index) {
        return personalTasksList.get(index - 1);
    }

    // This is used to get how many personal tasks have been added.
    public int getPersonalTaskCount() {
        return personalTasksList.size();
    }

    // This is used to add a work task to the workTasksList.
    public void addWorkTask(workTasks wt) {
        workTasksList.add(wt);
        Collections.sort(workTasksList);
        System.out.println("Task added: " + wt.getDescription());
    }

    // This is used to return a work task.
    public workTasks getWorkTask(int index) {
        return workTasksList.get(index - 1);
    }

    // This is used to return the amount of work tasks.
    public int getWorkTaskCount() {
        return workTasksList.size();
    }

    // This is used to check if there are any duplicates objects.
    @Override
    public boolean equals(Object o) {
        // This would check if its the same object.
        if (this == o) return true;
        // This would check if one personal task is the same as the parameter. To do we will use a for-loop and manual checking
        // using a for-loop.
        for (int i = 0; i < personalTasksList.size(); i++) {
            if (!personalTasksList.get(i).equals(o)) {
                return false;
            }
        }
        // This would check if one work task is the same as the parameter. To do we will use a for-loop and manual checking
        // using a for-loop.
        for (int i = 0; i < workTasksList.size(); i++) {
            if (!workTasksList.get(i).equals(o)) {
                return false;
            }
        }
        return true;
    }

    // This is used to remove any specific personal tasks.
    public void removePersonalTask(int index) {
        // This would get the necessary task to remove.
        PersonalTasks removed = personalTasksList.get(index - 1);
        spacing();
        // Prints the task that's being removed.
        System.out.println("Removed task: " + removed.getDescription());
        spacing();
        // Removes the task.
        personalTasksList.remove(index - 1);
    }

    // This is used to remove any specific work tasks.
    public void removeWorkTask(int index) {
        // This would get the necessary task to remove.
            workTasks removed = workTasksList.get(index - 1);
            spacing();
            // Prints the task that's being removed.
            System.out.println("Removed task: " + removed.getDescription());
            spacing();
            // Removes the task.
            workTasksList.remove(index-1);
    }

    // This is used to indicate that a personal task is completed.
    public void completePersonalTask(int index) {
        // Check if the array list is empty.
        if (personalTasksList.isEmpty()) {
            System.out.println("No personal tasks available.");
        }
        // This would execute only if the user's index is within the bounds of indexing to grab an element from the array.
        else if (index >= 1 && index <= personalTasksList.size()) {
            // This would grab the element from the arraylist.
            PersonalTasks completed = personalTasksList.get(index - 1);
            // This would call a method that would be used to indicate that the task has been completed.
            completed.completeTask();
            // This would add the task to the completed personal task array list.
            compledtedPersonalTasks.add(completed);
            // This would remove the task from the regular task list.
            personalTasksList.remove(index - 1);
        } else {
            // This would print to the user that's there's an error with their index choice.
            System.out.println("Invalid task number.");
        }
    }

    // This is used to indicate that a work task is completed.
    public void completeWorkTask(int index) {
        // Check if the array list is empty.
        if (workTasksList.isEmpty()) {
            System.out.println("No work tasks available.");
        }
        // This would execute only if the user's index is within the bounds of indexing to grab an element from the array.
        else if (index >= 1 && index <= workTasksList.size()) {
            // This would grab the element from the arraylist.
            workTasks completed = workTasksList.get(index - 1);
            // This would call a method that would be used to indicate that the task has been completed.
            completed.completeTask();
            // This would add the task to the completed personal task array list.
            completedWorkTasks.add(completed);
            // This would remove the task from the regular task list.
            workTasksList.remove(index - 1);
        } else {
            // This would print to the user that's there's an error with their index choice.
            System.out.println("Invalid task number.");
        }
    }

    // This is used to show all of the personal tasks in each array.
    public void displayPersonalTasks() {
        // This would execute if there's nothing in the arraylist to begin with.
        if (personalTasksList.isEmpty()) {
            System.out.println("You have no personal tasks available.");
        } 
        else {
            // we would sort the array first its type of personal task.
            Collections.sort(personalTasksList);
            spacing();
            // We would use a for-loop to print all the non-completed personal tasks.
            System.out.println("Personal Tasks (Non-completed):");
            for (int i = 0; i < personalTasksList.size(); i++) {
                PersonalTasks pt = personalTasksList.get(i);
                System.out.println((i + 1) + ". " + pt.toString());
            }
        }
        spacing();
        // we would sort the array first its type of personal task.
        if (compledtedPersonalTasks.isEmpty()) {
            System.out.println("You have no personal tasks that have been completed.");
        } 
        else {
            // we would sort the array first its type of personal task.
            Collections.sort(compledtedPersonalTasks);
            spacing();
            // We would use a for-loop to print all the completed personal tasks.
            System.out.println("Personal Tasks (Completed)");
            for (int i = 0; i < compledtedPersonalTasks.size(); i++) {
                PersonalTasks pt = compledtedPersonalTasks.get(i);
                System.out.println((i + 1) + ". " + pt.toString());
            }
        }
    }

    // This is used to show all of the work tasks in each array.
    public void displayWorkTasks() {
        // This would execute if there's nothing in the arraylist to begin with.
        if (workTasksList.isEmpty()) {
            System.out.println("You have no work tasks available.");
        } 
        else {
            // We would use this to sort the arrayList.
            Collections.sort(workTasksList);
            spacing();
            // We would use a for-loop to print all the non-completed work tasks.
            System.out.println("Work Tasks (Non-completed):");
            for (int i = 0; i < workTasksList.size(); i++) {
                workTasks wt = workTasksList.get(i);
                System.out.println((i + 1) + ". " + wt.toString());
            }
        }
        spacing();
        // This would execute if there's nothing in this arraylist.
        if (completedWorkTasks.isEmpty()) {
                System.out.println("You have no work tasks that have been completed.");
        } 
        else {
            // We would use this to sort this specific arrayList.
            Collections.sort(completedWorkTasks);
            spacing();
            // We would use a for-loop to print all the completed work tasks.
            System.out.println("Work Tasks (Completed)");
            for (int i = 0; i < completedWorkTasks.size(); i++) {
                workTasks wt = completedWorkTasks.get(i);
                System.out.println((i + 1) + ". " + wt.toString());
            }
        }
    }
}
