package ru.sharphurt.cronrssreader.dto.response;

import lombok.Getter;

@Getter
public class ClientResponse<T> {
    private Boolean successful;
    private T result;
    private String error;
}
