package ro.fasttrackit.homework;

import static ro.fasttrackit.homework.DaysOfTheWeek.*;

public class Main {
    public static void main(String[] args) throws NoActivitiesForDayException{
        DailyPlanner person1 = new DailyPlanner();
        person1.addActivity(MONDAY, "run");
        person1.addActivity(MONDAY, "sleep");
        person1.removeActivity(MONDAY,"sleep");
        person1.addActivity(TUESDAY,"learn");
        person1.addActivity(WEDNESDAY,"walk");
        person1.addActivity(THURSDAY,"read");
        person1.addActivity(FRIDAY,"write");
        person1.addActivity(SATURDAY,"eat");
        person1.addActivity(SUNDAY,"play");
        try{
            System.out.println(person1.endPlanning());
        } catch(NoActivitiesForDayException e){
            System.out.println(e.getMessage());
        }
    }
}
