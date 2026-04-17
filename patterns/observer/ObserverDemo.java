package com.patterns.observer;

import java.util.ArrayList;
import java.util.List;

// Observer example
public class ObserverDemo {
    public static void main(String[] args) {
        SchedulePublisher publisher = new SchedulePublisher();
        publisher.subscribe(new EmailNotifier("Observer1"));
        publisher.subscribe(new AppNotifier("Observer2"));

        publisher.updateSchedule("Lịch thi mới: 2026-04-30 09:00");
    }
}

interface Observer { void update(String scheduleDetails); }

class EmailNotifier implements Observer {
    private String name;
    public EmailNotifier(String name) { this.name = name; }
    public void update(String scheduleDetails) { System.out.println(name + " gửi Email lịch thi: " + scheduleDetails); }
}
class AppNotifier implements Observer {
    private String name;
    public AppNotifier(String name) { this.name = name; }
    public void update(String scheduleDetails) { System.out.println(name + " Báo Notification App: " + scheduleDetails); }
}

class SchedulePublisher {
    private List<Observer> students = new ArrayList<>();
    public void subscribe(Observer student) { students.add(student); }
    public void updateSchedule(String newSchedule) {
        for(Observer student : students) {
            student.update(newSchedule);
        }
    }
}

