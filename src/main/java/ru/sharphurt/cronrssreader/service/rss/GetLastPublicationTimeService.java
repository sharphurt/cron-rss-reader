package ru.sharphurt.cronrssreader.service.rss;

import java.time.ZonedDateTime;

public interface GetLastPublicationTimeService {

    ZonedDateTime getLastPublicationTime();
}
