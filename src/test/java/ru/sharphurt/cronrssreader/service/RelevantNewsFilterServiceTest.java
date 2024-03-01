package ru.sharphurt.cronrssreader.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sharphurt.cronrssreader.service.rss.impl.RelevantNewsFilterServiceImpl;
import ru.sharphurt.cronrssreader.service.rss.impl.GetLastPublicationTimeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.sharphurt.cronrssreader.sample.RssFeedSample.*;

@ExtendWith(MockitoExtension.class)
public class RelevantNewsFilterServiceTest {

    @Mock
    private GetLastPublicationTimeServiceImpl lastPublicationTimeService;

    @InjectMocks
    private RelevantNewsFilterServiceImpl service;

    @Test
    public void filterActualNews_successTest() {
        when(lastPublicationTimeService.getLastPublicationTime()).thenReturn(initialTime);

        var filteredNews = service.filterRelevantNews(rssFeed);
        assertEquals(4, filteredNews.size());
        assertEquals(parsedRssFeed.subList(1, 5), filteredNews);
    }

    @Test
    public void filterActualNews_allIrrelevantTest() {
        when(lastPublicationTimeService.getLastPublicationTime()).thenReturn(initialTime.plusMinutes(10));

        var filteredNews = service.filterRelevantNews(rssFeed);
        assertEquals(0, filteredNews.size());
    }

    @Test
    public void filterActualNews_allRelevantTest() {
        when(lastPublicationTimeService.getLastPublicationTime()).thenReturn(initialTime.minusMinutes(10));

        var filteredNews = service.filterRelevantNews(rssFeed);
        assertEquals(5, filteredNews.size());
        assertEquals(parsedRssFeed, filteredNews);
    }
}
