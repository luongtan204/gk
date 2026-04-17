package com.patterns.state;

// State example
public class StateDemo {
    public static void main(String[] args) {
        CourseContext course = new CourseContext();
        course.register(); // Pending -> Registered
        course.register(); // Already registered
        course.cancel();   // Cancel -> Pending
    }
}

interface CourseState {
    void registerCourse(CourseContext context);
    void cancelCourse(CourseContext context);
}

class PendingState implements CourseState {
    public void registerCourse(CourseContext context) {
        System.out.println("Đăng ký thành công!");
        context.setState(new RegisteredState());
    }
    public void cancelCourse(CourseContext context) { System.out.println("Chưa đăng ký, không thể hủy."); }
}

class RegisteredState implements CourseState {
    public void registerCourse(CourseContext context) { System.out.println("Bạn đã đăng ký môn này rồi!"); }
    public void cancelCourse(CourseContext context) {
        System.out.println("Hủy môn thành công.");
        context.setState(new PendingState());
    }
}

class CourseContext {
    private CourseState state = new PendingState();
    public void setState(CourseState state) { this.state = state; }
    public void register() { state.registerCourse(this); }
    public void cancel() { state.cancelCourse(this); }
}

