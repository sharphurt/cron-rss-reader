package ru.sharphurt.cronrssreader.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import ru.sharphurt.cronrssreader.exception.RssFeedUnavailable;
import ru.sharphurt.cronrssreader.service.rss.impl.GetRssFeedServiceImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GetRssFeedServiceTest {


    @InjectMocks
    private GetRssFeedServiceImpl service;

    @Test
    public void readRss_successTest() {
        ReflectionTestUtils.setField(service, "rssUrl", "https://lenta.ru/rss");
        var result = service.getRssFeed();
        assertFalse(result.isEmpty());
    }

    @Test
    public void readRss_invalidUrlTest() {
        ReflectionTestUtils.setField(service, "rssUrl", "https://lenta.ru/invalid");
        assertThrows(RssFeedUnavailable.class, () -> service.getRssFeed());
    }
}
