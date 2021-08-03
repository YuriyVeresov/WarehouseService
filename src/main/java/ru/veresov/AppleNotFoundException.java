package ru.veresov;

public class AppleNotFoundException extends Throwable {
    public AppleNotFoundException(String message) {
        super(message);
    }
}
