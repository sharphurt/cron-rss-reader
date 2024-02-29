package ru.sharphurt.cronrssreader.exception;

public class EmptyDatabaseException extends BaseException {

    public EmptyDatabaseException(String serviceName) {
        super(serviceName, new Throwable());
    }
}
