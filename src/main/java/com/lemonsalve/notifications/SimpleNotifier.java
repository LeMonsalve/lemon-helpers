package lib.notifications;

import java.awt.*;

public class SimpleNotifier implements Notifier {

    @Override
    public void send(String title, String message) {
        send(title, message, "", TrayIcon.MessageType.NONE);
    }

    @Override
    public void send(String title, String message, TrayIcon.MessageType messageType) {
        send(title, message, "", messageType);
    }

    @Override
    public void send(String title, String message, String tooltip, TrayIcon.MessageType messageType) {
        send(title, message, tooltip, messageType, "");
    }

    @Override
    public void send(String title, String message, String tooltip, TrayIcon.MessageType messageType, String iconPath) {
        if (!SystemTray.isSupported()) return;

        Image image = Toolkit.getDefaultToolkit().createImage(iconPath);

        TrayIcon trayIcon = createTrayIcon(image, tooltip);

        addTryIconToSystemTray(trayIcon);

        trayIcon.displayMessage(title, message, messageType);
    }

    private TrayIcon createTrayIcon(Image image, String tooltip) {
        TrayIcon trayIcon = new TrayIcon(image, tooltip);
        trayIcon.setImageAutoSize(true);
        return trayIcon;
    }

    private void addTryIconToSystemTray(TrayIcon trayIcon) {
        SystemTray tray = SystemTray.getSystemTray();

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }
}
