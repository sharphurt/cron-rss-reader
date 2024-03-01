package ru.sharphurt.cronrssreader.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClientResponse<T> {
    private Boolean successful;
    private T result;
    private String error;

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
