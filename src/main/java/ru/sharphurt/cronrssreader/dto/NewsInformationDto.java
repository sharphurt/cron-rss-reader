package ru.sharphurt.cronrssreader.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sharphurt.cronrssreader.serialization.ZonedDateTimeSerializer;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsInformationDto {

    private String guid;
    private String title;
    private String description;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    private ZonedDateTime publicationDate;
}
