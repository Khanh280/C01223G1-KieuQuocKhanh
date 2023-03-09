package Class_and_oop_java;

import java.time.LocalTime;
import java.util.Scanner;

class StopWatchSetting {
    int startTime, endTime;
    long start, stop;

    public StopWatchSetting() {

    }

    public StopWatchSetting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private int getStartTime() {
        return startTime;
    }

    private int getEndTime() {
        return endTime;
    }

    public LocalTime reset() {
        return java.time.LocalTime.now();
    }

    public LocalTime start() {
        start = System.currentTimeMillis();
        return java.time.LocalTime.now();
    }

    public LocalTime stop() {
        stop = System.currentTimeMillis();
        return java.time.LocalTime.now();
    }

    public long getElapsedTime() {
        return stop - start;
    }

}

public class StopWatch {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StopWatchSetting w = new StopWatchSetting();
        System.out.print("Nhập start để bắt đầu đếm giờ: ");
        String start = sc.nextLine();
        if (start.equals("start")) {
            dieuKien(start, w);
            stopOrReset(w);
        } else {
            System.out.println("Bạn đã không bắt đầu.");
        }

    }

    public static void stopOrReset(StopWatchSetting w) {
        System.out.print("Nhập stop để dừng đếm, reset để đặt lại thời gian hiện tại: ");
        String inputStopOrReset = sc.nextLine();
        dieuKien(inputStopOrReset, w);
    }

    public static void dieuKien(String startAndStop, StopWatchSetting w) {
        switch (startAndStop) {
            case "start":
                System.out.println("Thời gian bắt đầu đếm: " + w.start());
                break;
            case "stop":
                System.out.println("Thời gian dừng đếm: " + w.stop());
                System.out.println("Từ lúc bắt đầu đến lúc dừng là: " + w.getElapsedTime() + " milisecond.");
                break;
            case "reset":
                System.out.println("Thời gian sau khi reset là: " + w.reset());
                break;
            default:
                System.out.println("Hãy nhập đúng từ khóa để thực thi chương trình.");
                stopOrReset(w);
        }
    }
}
