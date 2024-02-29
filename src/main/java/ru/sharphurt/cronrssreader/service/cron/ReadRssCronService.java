package ru.sharphurt.cronrssreader.service.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.sharphurt.cronrssreader.client.NewsStorageClient;
import ru.sharphurt.cronrssreader.service.rss.GetActualNewsService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReadRssCronService {

    private final GetActualNewsService actualNewsService;
    private final NewsStorageClient newsStorageClient;

    @Scheduled(cron = "*/10 */1 * * * *")
    public void updateNewsCollection() {
        var actualNews = actualNewsService.getActualNews();

        log.info("Got new %d news".formatted(actualNews.size()));
        for (var news : actualNews) {
            log.info(news.toString());
        }
        newsStorageClient.uploadNews(actualNews);
    }
}
