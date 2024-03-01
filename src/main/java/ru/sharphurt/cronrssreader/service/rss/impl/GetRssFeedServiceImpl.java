package ru.sharphurt.cronrssreader.service.rss.impl;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sharphurt.cronrssreader.exception.RssFeedUnavailable;
import ru.sharphurt.cronrssreader.service.rss.GetRssFeedService;

import java.io.IOException;
import java.util.List;

import static ru.sharphurt.cronrssreader.constants.AliasConstants.LOG_RSS_GOT_FEED;
import static ru.sharphurt.cronrssreader.constants.AliasConstants.LOG_RSS_REQUEST;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetRssFeedServiceImpl implements GetRssFeedService {

    @Value("${application.rss.url}")
    private String rssUrl;

    private final static String serviceName = "read-rss-cron-service";

    public List<Item> getRssFeed() {
        log.info(LOG_RSS_REQUEST.formatted(serviceName, rssUrl));

        try {
            var rssFeed = new RssReader().read(rssUrl).toList();
            log.info(LOG_RSS_GOT_FEED.formatted(serviceName, rssFeed.size()));

            return rssFeed;
        } catch (IOException e) {
            throw new RssFeedUnavailable(serviceName, rssUrl, e);
        }
    }
}
