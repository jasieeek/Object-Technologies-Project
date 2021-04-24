package pl.jasiek.app.controller;

public interface Command extends Runnable {
    String getLabel();
}
