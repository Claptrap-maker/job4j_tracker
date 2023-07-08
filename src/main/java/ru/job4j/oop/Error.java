package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        Error outOfBoundException = new Error(true, -1, "ArrayOutOfBoundException");
        Error arithmeticException = new Error(false, -2, "ArithmeticException");
        Error nullPointerException = new Error(true, -3, "NullPointerException");
        defaultError.printInfo();
        outOfBoundException.printInfo();
        arithmeticException.printInfo();
        nullPointerException.printInfo();
    }
}
