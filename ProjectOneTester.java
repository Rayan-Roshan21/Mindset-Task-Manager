/* Name: Rayan Roshan
 * Date: March 11th, 2025
 * Course Code: CPS209
 * Project name: Mindset
 * 
 * Project description:
 * Mindset is a java applicaiton that allows people to manage their personal and work tasks. 
 * It would allow individuals to focus on the things that matter in their day-to-day life. 
 * Specifically, this platform allows individuals to do the following: set their priority for work tasks,
 * give a brief description and set their task type for all tasks. The tasks are divided into two categories:
 * personal and work tasks. The personal tasks are divided into four categories: mental health, house chores, studying, and other.
 * The work tasks are divided into four categories: work on project, working meetings, work sessions, and other.
 * 
 * Features:
 * - Adding tasks
 * - Removing tasks
 * - Viewing all tasks
 * - Marking a task as complete
 * - Exiting the program
 * 
 * Classes and methods:
 * 1. TaskManager.java: This class is for managing all the tasks. It has the following methods:
    - AddPersonalTasks. 
    - addWorkTask
    - removePersonalTask
    - removeWorkTask
    - completePersonalTask
    - completeWorkTask
    - spacing
    - displayPersonalTasks
    - displayWorkTasks
    - getPersonalTaskCount
    - getWorkTaskCount
    - getPersonalTasksList
    - getWorkTasksList
    - getWorkTask
    - getPersonalTask

   2. PersonalTasks.java: This class is for personal tasks. It has the following methods:
    - getTaskType
    - setTaskType
    - getDescription
    - setDescription
    - getCompleted
    - setCompleted
    - toString

    3. workTasks.java: This class is for work tasks. It has the following methods:
    - getPriority
    - completeTask
    - toString
    - compareTo

    4. ProjectOneTester.java: This class is for testing the application. It has the following methods:
    - spacing
    - main

    5. Task.java: This class is for the task. his is the parent class for the PersonalTasks.java and workTasks.java It has the following methods:
    - getDescription
    - setDescription
    - getIsCompleted
    - setCompleted
    - toString
    - compareTo

 */
import java.util.*;
public class ProjectOneTester {
    
    // This method is used to add spacing between lines.
    public static void spacing() {
        System.out.println("*-----------------------------------------------------*");
    }
    public static void main(String[] args) throws Exception {
        // This is used to get the users input and would be called.
        Scanner scan = new Scanner(System.in);

        // This is used to manage all of the tasks and used to do the following: add/remove tasks, mark tasks as completed, and display all tasks.
        TaskManager tm = new TaskManager();

        // These are some basic variables that are used to grab the user's information.
        String type, description;
        // This is used to introduce the user to the program.
        System.out.println("Welcome to Mindset!");
        // This while loop will continue until the user decides to stop.
        while (true) {
            // This is used to show the options.
            spacing();
            System.out.println("Please choose the following by entering the number:\n 1. Adding a task. \n 2. Removing a task. \n 3. View all tasks. \n 4. Mark a task as completed. \n -1. Exit.");
            spacing();
            // This is used to get the users choice for deciding what to do with the program.
            System.out.print("Please input a choice: ");
            int choice = scan.nextInt();

            // This if-statement block is used to add a personal or work tasks.
            if (choice == 1) {
                
                // This is asking the user if the task is personal or for work.
                System.out.print("Please tell us if it's a personal task (1) or work task (2) by entering the number: ");
                type = scan.next();
                scan.nextLine();

                // This is used to get the description of the task.
                System.out.print("Give us a brief description of task: ");
                description = scan.nextLine();

                // This is used to check if the user is creating a personal task.
                if (type.equalsIgnoreCase("1")) {
                    spacing();
                    // This is used to show what the task is specifically for.
                    System.out.println("Please choose the type of a personal task is this by typing the number: ");
                    System.out.println("1. Mental health.");
                    System.out.println("2. House chores.");
                    System.out.println("3. Studying.");
                    System.out.println("4. Other.");

                    // This is used to get the users input for the menu above.
                    System.out.print("Type your choice: ");
                    int typeChoice = scan.nextInt();
                    scan.nextLine();
                    // This is used to create the personal task.
                    PersonalTasks pt = new PersonalTasks(typeChoice, description, false);
                    // This is used to check if the personal task has already been added.
                    boolean exists = false;
                    for (PersonalTasks tempTask : tm.getPersonalTasksList()) {
                        if (tempTask.equals(pt)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("You already have this task in your list!");
                        spacing();
                        continue;
                    } 
                    else {
                        tm.addPersonalTask(pt);
                    }
                    spacing();
                }
                // This is used to check if the user is creating a personal task.
                else if (type.equalsIgnoreCase("2")) {
                    
                    spacing();
                    // This is used to show what the task is specifically for.
                    System.out.println("Please choose the type of a work task is this by typing the number: ");
                    System.out.println("1. Work on project.");
                    System.out.println("2. Working meetings.");
                    System.out.println("3. Work sessions.");
                    System.out.println("4. Other.");

                    // This is used to get the users input for the menu above.
                    System.out.print("Type your choice: ");
                    int typeChoice = scan.nextInt();
                    scan.nextLine();
                    spacing();

                    spacing();
                    // This used to check the task's priority.
                    System.out.println("Please tell us about the priority of the task by typing the number: ");
                    System.out.println("1. High.");
                    System.out.println("2. Medium.");
                    System.out.println("3. Low.");
                    spacing();

                    // This is used to get the users input for the menu above.
                    System.out.print("Type your choice: ");
                    int priorityChoice = scan.nextInt();

                    // This is used to create a work tasks.
                    workTasks wt = new workTasks(typeChoice, description, false, priorityChoice);
                    // This is used to check if the personal task has already been added.
                    boolean exists = false;
                    for (workTasks tempTask : tm.getWorkTasksList()) {
                        if (tempTask.equals(wt)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("You already have this task in your list!");
                        spacing();
                        continue;
                    } 
                    else {
                        tm.addWorkTask(wt);
                    }
                }
                else {
                    // If the user has entered a value that's out of bounds, its execute this else-statement block.
                    System.out.println("Sorry I don't understand. Please try again!");
                    spacing();
                }
            }
            // If the else-if statement block executes, then this means that the user would like to remove any tasks.
            else if (choice == 2) {
                // This would check if the user has no tasks to remove.
                if (tm.getPersonalTaskCount() == 0 && tm.getWorkTaskCount() == 0) {
                    spacing();
                    System.out.println("You have no tasks to remove!");
                    spacing();
                    continue;
                }
                // This would else-statement block would execute if they do have personal and work tasks to remove.
                else {
                    spacing();
                    // This would ask the user what kind of task they would like to remove.
                    System.out.println("Please choose the type of task you would like to remove by typing the number: ");
                    System.out.println("1. Personal task.");
                    System.out.println("2. Work task.");
                    spacing();

                    // This would grab the user's choice from the menu above.
                    System.out.print("Type your choice: ");
                    int removeChoice = scan.nextInt();
                    spacing();

                    // This would allow the user to remove a personal task.
                    if (removeChoice == 1) {
                        // This would check if the user has no personal tasks to remove.
                        if (tm.getPersonalTaskCount() == 0) {
                            System.out.println("You have no personal tasks to remove!");
                            spacing();
                        }  
                        else {
                            // This would print all of the personal tasks for the user to see.
                            System.out.println("Here are all of your personal tasks: ");
                            tm.displayPersonalTasks();
                            // This would grab the tasks position that they would like to remove.
                            System.out.print("Please choose what task you would like to remove: ");
                            int removeIndex = scan.nextInt();
                            spacing();
                            if (removeIndex-1 < 0 || removeIndex-1 >= tm.getPersonalTaskCount()) {
                                System.out.println("Sorry I don't understand that's out of bounds. Please try that again!");
                                spacing();
                                continue;
                            }
                            else {
                                // This would remove the personal task.
                                spacing();
                                tm.removePersonalTask(removeIndex);
                                spacing();
                            }
                        }
                    }
                    else if (removeChoice == 2) {
                        // This would check if the user has no work tasks to remove.
                        if (tm.getWorkTaskCount() == 0) {
                            System.out.println("You have no work tasks to remove!");
                            spacing();
                        }
                        else {
                            // This would print all of the work tasks for the user to see.
                            System.out.println("Here are all of your work tasks: ");
                            tm.displayWorkTasks();
                            // This would grab the tasks position that they would like to remove.
                            System.out.print("Please choose what task you would like to remove: ");
                            int removeIndex = scan.nextInt();
                            spacing();
                            if (removeIndex-1 < 0 || removeIndex-1 >= tm.getWorkTaskCount()) {
                                System.out.println("Sorry I don't understand that's out of bounds. Please try that again!");
                                spacing();
                                continue;
                            }
                            else {
                                // This would remove the work task.
                                spacing();
                                tm.removeWorkTask(removeIndex);
                                spacing();
                            }
                        }
                    }
                    else {
                        System.out.println("Sorry I don't understand that. Please try that again!");
                    }
                }
            }
            // This else-if statement block would execute if the user would like to see all of the tasks.
            else if (choice == 3) {
                spacing();
                // This would display all of the tasks.
                tm.displayPersonalTasks();
                spacing();
                tm.displayWorkTasks();
            }
            else if (choice == 4) {
                spacing();
                // This would ask the user what kind of task they would like to mark as complete.
                System.out.println("Please choose the type of task you would like to mark as complete by typing the number: ");
                System.out.println("1. Personal task.");
                System.out.println("2. Work task.");
                spacing();

                // This would grab the user's choice from the menu above.
                System.out.print("Type your choice: ");
                int removeChoice = scan.nextInt();
                spacing();

                // This would allow the user to mark a personal task as completed.
                if (removeChoice == 1) {
                    // This would check if the user has no personal tasks.
                    if (tm.getPersonalTaskCount() == 0) {
                        System.out.println("You have no personal tasks to mark as complete!");
                        spacing();
                    }  
                    else {
                        // This would print all of the personal tasks for the user to see.
                        System.out.println("Here are your uncompleted personal tasks: ");
                        tm.displayPersonalTasks();
                        System.out.print("Please choose what task you would like to mark as complete by entering the number: ");
                        // This would grab the tasks position that they would like to mark as complete
                        int completeIndex = scan.nextInt();
                        // This would check if the user's choice can be used to grab a task from an arraylist that's in the task manager.
                        if (completeIndex-1 < 0 || completeIndex-1 >= tm.getPersonalTaskCount()) {
                            System.out.println("Sorry I don't understand that's out of bounds. Please try that again!");
                            spacing();
                        }
                        else {
                            // This would mark the personal task as completed.
                            tm.completePersonalTask(completeIndex);
                            spacing();
                        }
                    }
                }
                else if (removeChoice == 2) {
                    // This would check if the user has no work tasks.
                    if (tm.getWorkTaskCount() == 0) {
                        System.out.println("You have no work tasks to mark as complete!");
                        spacing();
                    }
                    else {
                        // This would print all of the work tasks for the user to see.
                        System.out.println("Here are of uncompleted work tasks: ");
                        tm.displayWorkTasks();
                        spacing();
                        // This would grab the tasks position that they would like to mark as complete
                        System.out.print("Please choose what task you would like to mark as complete by entering the number: ");
                        int completeIndex = scan.nextInt();
                        // This would check if the user's choice can be used to grab a task from an arraylist that's in the task manager.
                        if (completeIndex-1 < 0 || completeIndex-1 >= tm.getWorkTaskCount()) {
                            System.out.println("Sorry I don't understand that's out of bounds. Please try that again!");
                            spacing();
                        }
                        else {
                           // This would remove the work task.
                            tm.completeWorkTask(completeIndex);
                            spacing();
                        }
                    }
                }
                else {
                    System.out.println("Sorry I don't understand that. Please try that again!");
                }
            }
            // If the user's choice is -1, this means they would like to exit the program.
            else if (choice == -1) {
                spacing();
                System.out.println("Thank you for using Mindset. Stay organized!");
                spacing();
                break;
            }
            // If this else-statement block executes, then it means that the user has entered a value that can't be used.
            else {
                System.out.println("Sorry I don't understand that. Please try that again!");
                spacing();
            }
        }
        // This would be used to close the scanner.
        scan.close();
    }
}
