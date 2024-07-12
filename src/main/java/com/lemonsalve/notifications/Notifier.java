package lib.notifications;

import java.awt.*;

public interface Notifier {
    void send(String title, String message);
    void send(String title, String message, TrayIcon.MessageType messageType);
    void send(String title, String message, String tooltip, TrayIcon.MessageType messageType);
    void send(String title, String message, String tooltip, TrayIcon.MessageType messageType, String iconPath);
}
