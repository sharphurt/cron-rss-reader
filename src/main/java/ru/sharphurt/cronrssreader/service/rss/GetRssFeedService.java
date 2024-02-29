package ru.sharphurt.cronrssreader.service.rss;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sharphurt.cronrssreader.exception.RssFeedUnavailable;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetRssFeedService {

    @Value("${application.rss.url}")
    private String rssUrl;

    private final static String serviceName = "read-rss-cron-service";

    public List<Item> getRssFeed() {
        try {
            return new RssReader().read(rssUrl).toList();
        } catch (IOException e) {
            throw new RssFeedUnavailable(serviceName, rssUrl);
        }
    }
}
