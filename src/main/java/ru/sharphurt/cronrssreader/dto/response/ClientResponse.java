package ru.sharphurt.cronrssreader.dto.response;

import lombok.Getter;

@Getter
public class ClientResponse<T> {
    private final Boolean successful;
    private final T result;
    private final String error;

    public ClientResponse(T result) {
        this.result = result;
        this.successful = true;
        this.error = null;
    }

    public ClientResponse(String error) {
        this.result = null;
        this.successful = false;
        this.error = error;
    }
}
