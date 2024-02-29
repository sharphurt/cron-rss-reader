package ru.sharphurt.cronrssreader.service.rss;

import com.apptasticsoftware.rssreader.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.cronrssreader.dto.NewsInformationDto;

import java.time.ZonedDateTime;
import java.util.List;

import static ru.sharphurt.cronrssreader.constants.AliasConstants.LOG_WARN_ITEM_NOT_PARSED;
import static ru.sharphurt.cronrssreader.mapper.NewsInformationMapper.NEWS_INFORMATION_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetActualNewsService {

    private final GetRssFeedService rssFeedService;
    private final GetLastPublicationTimeService lastPublicationTimeService;

    public List<NewsInformationDto> getActualNews() {
        var rssFeed = rssFeedService.getRssFeed();
        var lastPublicationTime = lastPublicationTimeService.getLastPublicationTime();

        return rssFeed.stream()
                .filter(item -> checkItemActuality(item, lastPublicationTime))
                .map(NEWS_INFORMATION_MAPPER::map)
                .toList();
    }

    private boolean checkItemActuality(Item item, ZonedDateTime lastNewsTime) {
        var publicationDate = item.getPubDateZonedDateTime();

        if (publicationDate.isEmpty()) {
            log.warn(LOG_WARN_ITEM_NOT_PARSED.formatted(item.getPubDate()));
            return false;
        }

        return publicationDate.get().isAfter(lastNewsTime);
    }
}
