package ru.sharphurt.cronrssreader.service.cron.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.sharphurt.cronrssreader.client.NewsStorageClient;
import ru.sharphurt.cronrssreader.service.cron.UpdateNewsCollectionCronService;
import ru.sharphurt.cronrssreader.service.rss.RelevantNewsFilterService;
import ru.sharphurt.cronrssreader.service.rss.GetRssFeedService;

import static ru.sharphurt.cronrssreader.constants.AliasConstants.LOG_CRON_SERVICE_START;
import static ru.sharphurt.cronrssreader.constants.AliasConstants.LOG_CRON_SERVICE_UPLOADING_NEWS;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateNewsCollectionCronServiceImpl implements UpdateNewsCollectionCronService {

    private final RelevantNewsFilterService actualNewsService;
    private final NewsStorageClient newsStorageClient;
    private final GetRssFeedService rssFeedService;

    public static final String serviceName = "read-rss-cron-service";

    @Scheduled(cron = "*/10 */1 * * * *")
    public void updateNewsCollection() {
        log.info(LOG_CRON_SERVICE_START.formatted(serviceName));

        var rssFeed = rssFeedService.getRssFeed();

        var actualNews = actualNewsService.filterRelevantNews(rssFeed);
        log.info(LOG_CRON_SERVICE_UPLOADING_NEWS.formatted(serviceName, actualNews.size()));

        newsStorageClient.uploadNews(actualNews);
    }
}
