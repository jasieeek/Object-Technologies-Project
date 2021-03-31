package pl.jasiek.app.controller;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.exit(1);
    }

    @Override
    public String getLabel() {
        return "Exit";
    }
}
