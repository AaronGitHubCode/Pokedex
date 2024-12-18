package app.go.utils;

public interface INotificationService {
    void onNotify(String title, String content, int icon);
    void onNotify(String title, String content, int smallIcon, int largeIcon);
}
