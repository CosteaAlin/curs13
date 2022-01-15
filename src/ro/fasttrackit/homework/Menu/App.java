package ro.fasttrackit.homework.Menu;

import ro.fasttrackit.homework.DailyPlanner;
import ro.fasttrackit.homework.DaysOfTheWeek;
import ro.fasttrackit.homework.NoActivitiesForDayException;

import java.util.List;
import java.util.Scanner;

import static ro.fasttrackit.homework.DaysOfTheWeek.*;

public class App {
    private final DailyPlanner person = new DailyPlanner();
    private final Scanner scanner = new Scanner(System.in);
    private final List<Integer> validSelection = List.of(1, 2, 3);

    public void run() {
        int input = 0;
        System.out.println("here");
        do {
            displayMenu();
            try {
                input = scanner.nextInt();
                switch (input) {
                    case 1: {
                        insertActivity();
                        break;
                    }
                    case 2: {
                        removeActivity();
                        break;
                    }
                    case 3: {
                        listAllActivities();
                        break;
                    }
                    case 4: {
                        endPlanning();
                        break;
                    }
                    default:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        } while (validSelection.contains(input));
    }

    private void endPlanning() {
        System.out.println("Planning:");
        try {
            System.out.println(person.endPlanning());
        } catch (NoActivitiesForDayException e) {
            e.printStackTrace();
        }
    }

    private void listAllActivities() {
        System.out.println("Select the day:");
        displayDays();
        int day = scanner.nextInt();
        DaysOfTheWeek daysSelected = selectDay(day);
        System.out.println(person.getActivities(daysSelected));
    }

    private void insertActivity() {
        System.out.println("Please insert the activity you want to add:");
        String activity = scanner.next();
        displayDays();
        int day = scanner.nextInt();
        DaysOfTheWeek daysSelected = selectDay(day);
        person.addActivity(daysSelected, activity);
        System.out.println("Activity added.");
    }

    private void removeActivity() {
        System.out.println("Please insert the activity you want to remove:");
        String activity = scanner.next();
        displayDays();
        int day = scanner.nextInt();
        DaysOfTheWeek daysSelected = selectDay(day);
        person.removeActivity(daysSelected, activity);
    }

    private DaysOfTheWeek selectDay(int day) {
        switch (day) {
            case 1: {
                return MONDAY;
            }
            case 2: {
                return TUESDAY;
            }
            case 3: {
                return WEDNESDAY;
            }
            case 4: {
                return THURSDAY;
            }
            case 5: {
                return FRIDAY;
            }
            case 6: {
                return SATURDAY;
            }
            case 7: {
                return SUNDAY;
            }
            default:
                System.out.println("Choose a valid day, operation failed");
                return null;
        }
    }

    private void displayMenu() {
        System.out.println("Please choose and option:");
        System.out.println(" 1) Add an activity");
        System.out.println(" 2) Remove an activity");
        System.out.println(" 3) List all activities");
        System.out.println(" 4) End planning");
    }

    private void displayDays() {
        System.out.println("1) Monday");
        System.out.println("2) Tuesday");
        System.out.println("3) Wednesday");
        System.out.println("4) Thursday");
        System.out.println("5) Friday");
        System.out.println("6) Saturday");
        System.out.println("7) Sunday");
        System.out.println("Please select the number corresponding to the day");
    }


}
