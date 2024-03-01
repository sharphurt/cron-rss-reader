package ru.sharphurt.cronrssreader.service.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.sharphurt.cronrssreader.client.NewsStorageClient;
import ru.sharphurt.cronrssreader.service.rss.GetActualNewsService;

import static ru.sharphurt.cronrssreader.constants.AliasConstants.LOG_CRON_SERVICE_START;
import static ru.sharphurt.cronrssreader.constants.AliasConstants.LOG_CRON_SERVICE_UPLOADING_NEWS;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReadRssCronService {

    private final GetActualNewsService actualNewsService;
    private final NewsStorageClient newsStorageClient;

    public static final String serviceName = "read-rss-cron-service";

    @Scheduled(cron = "*/10 */1 * * * *")
    public void updateNewsCollection() {
        log.info(LOG_CRON_SERVICE_START.formatted(serviceName));

        var actualNews = actualNewsService.getActualNews();
        log.info(LOG_CRON_SERVICE_UPLOADING_NEWS.formatted(serviceName, actualNews.size()));

        newsStorageClient.uploadNews(actualNews);
    }
}
