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

@Slf4j
@Service
@RequiredArgsConstructor
public class GetLastPublicationTimeService {

    @Value("${application.rss.timezone}")
    private String rssTimezone;

    private final NewsStorageClient newsStorageClient;

    public ZonedDateTime getLastPublicationTime() {
        try {
            var lastNews = newsStorageClient.getLastToday();
            return lastNews.getResult().getPublicationDate();
        } catch (FeignException.NotFound e) {
            return ZonedDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT, ZoneId.of(rssTimezone));
        }
    }
}
