package ru.sharphurt.cronrssreader.service.rss;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sharphurt.cronrssreader.client.NewsStorageClient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static ru.sharphurt.cronrssreader.constants.AliasConstants.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetLastPublicationTimeService {

    @Value("${application.rss.timezone}")
    private String rssTimezone;

    private final NewsStorageClient newsStorageClient;

    public static final String serviceName = "get-last-publication-time-service";

    public ZonedDateTime getLastPublicationTime() {
        try {
            log.info(LOG_FEIGN_CLIENT_GET_LAST_PUBLICATION.formatted(serviceName));
            var lastNews = newsStorageClient.getLastToday();

            log.info(LOG_FEIGN_CLIENT_GOT_LAST_PUBLICATION.formatted(serviceName, lastNews));
            return lastNews.getResult().getPublicationDate();
        } catch (FeignException.NotFound e) {
            log.info(LOG_FEIGN_CLIENT_LAST_PUBLICATION_NOT_FOUND.formatted(serviceName, e.getMessage()));
            return ZonedDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT, ZoneId.of(rssTimezone));
        }
    }
}
