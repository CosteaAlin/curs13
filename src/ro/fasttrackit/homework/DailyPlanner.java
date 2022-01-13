package ro.fasttrackit.homework;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ro.fasttrackit.homework.DaysOfTheWeek.*;

public class DailyPlanner {
    private final List<DaySchedule> daySchedules;

    public DailyPlanner() {
        daySchedules = List.of(new DaySchedule(MONDAY, new ArrayList<>()),
                new DaySchedule(TUESDAY, new ArrayList<>()),
                new DaySchedule(WEDNESDAY, new ArrayList<>()),
                new DaySchedule(THURSDAY, new ArrayList<>()),
                new DaySchedule(FRIDAY, new ArrayList<>()),
                new DaySchedule(SATURDAY, new ArrayList<>()),
                new DaySchedule(SUNDAY, new ArrayList<>()));
    }

    public void addActivity(DaysOfTheWeek day, String activity) {
        if (activity == null) {
            throw new NoActivityException("You are not allowed to insert null values");
        } else {
            for (DaySchedule daySchedule : daySchedules) {
                if (daySchedule.getDaysOfTheWeek() == day) {
                    daySchedule.addActivity(activity);
                    break;
                }
            }
        }
    }

    public void removeActivity(DaysOfTheWeek day, String activity) {
        for (DaySchedule daySchedule : daySchedules) {
            if (daySchedule.getDaysOfTheWeek() == day) {
                List<String> temp = daySchedule.getActivities();
                if (temp.contains(activity)) {
                    daySchedule.removeActivity(activity);
                } else {
                    throw new NoActivityException("Activity does not exists");
                }
            }
        }
    }

    public List<String> getActivities(DaysOfTheWeek day) {
        for (DaySchedule daySchedule : daySchedules) {
            if (daySchedule.getDaysOfTheWeek() == day) {
                return daySchedule.getActivities();
            }
        }
        return null;
    }

    public Map<DaysOfTheWeek, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<DaysOfTheWeek, List<String>> result = new HashMap<>();
        for (DaySchedule daySchedule : daySchedules) {
            if (daySchedule.getActivities().size() > 0) {
                result.put(daySchedule.getDaysOfTheWeek(), daySchedule.getActivities());
            } else {
                throw new NoActivitiesForDayException("You don`t have any activities planned for " + daySchedule.getDaysOfTheWeek());
            }
        }
        return result;
    }
}
