package pl.jasiek.app.controller;

public class RefreshCommand implements Command {
    @Override
    public void run() {
        System.out.println("Refreshing view...");
    }

    @Override
    public String getLabel() {
        return "Refresh";
    }
}
