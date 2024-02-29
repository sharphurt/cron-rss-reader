package ru.sharphurt.cronrssreader.mapper;

import com.apptasticsoftware.rssreader.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.sharphurt.cronrssreader.dto.NewsInformationDto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsInformationMapper {

    NewsInformationMapper NEWS_INFORMATION_MAPPER = Mappers.getMapper(NewsInformationMapper.class);

    @Mapping(target = "publicationDate", source = "pubDate", qualifiedByName = "stringToDate")
    NewsInformationDto map(Item source);

    default <T> T unwrap(Optional<T> optional) {
        return optional.orElse(null);
    }

    @Named("stringToDate")
    default ZonedDateTime stringToDate(Optional<String> pubDate) {
        return ZonedDateTime.parse(unwrap(pubDate), DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.UK));
    }
}
