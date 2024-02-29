package ru.sharphurt.cronrssreader.exception;

import static ru.sharphurt.cronrssreader.constants.AliasConstants.EXCEPTION_EXTERNAL_SERVICE_ERROR;

public class ExternalServiceException extends BaseException {

    public ExternalServiceException(String serviceName, String message) {
        super(EXCEPTION_EXTERNAL_SERVICE_ERROR.formatted(serviceName, message), new Throwable());
    }
}
