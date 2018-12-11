package com.efruit.micro.arkmanager.exception;

public class YouzanOrderSyncException extends Exception  {
    private static final long serialVersionUID = -2150676756981854188L;

    public YouzanOrderSyncException() {
    }

    public YouzanOrderSyncException(String message) {
        super(message);
    }

    public YouzanOrderSyncException(String message, Throwable cause) {
        super(message, cause);
    }

    public YouzanOrderSyncException(Throwable cause) {
        super(cause);
    }

}
