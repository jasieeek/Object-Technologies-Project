package pl.jasiek.app.controller;

public interface Command {
    void execute();
    String getLabel();
}
