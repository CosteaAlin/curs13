package ro.fasttrackit.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaySchedule {
    private DaysOfTheWeek daysOfTheWeek;
    private List<String> activities;

    public DaySchedule(DaysOfTheWeek daysOfTheWeek, List<String> activities) {
        this.daysOfTheWeek = daysOfTheWeek;
        this.activities = activities;
    }

    public DaysOfTheWeek getDaysOfTheWeek() {
        return daysOfTheWeek;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void addActivity(String activity) {
        this.activities.add(activity);
    }

    public void removeActivity(String activity) {
        this.activities.remove(activity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaySchedule that = (DaySchedule) o;
        return daysOfTheWeek == that.daysOfTheWeek && Objects.equals(activities, that.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(daysOfTheWeek, activities);
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "daysOfTheWeek=" + daysOfTheWeek +
                ", activities=" + activities +
                '}';
    }
}
