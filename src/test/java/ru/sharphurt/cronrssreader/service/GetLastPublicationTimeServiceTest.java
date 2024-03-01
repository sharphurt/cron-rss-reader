package ru.sharphurt.cronrssreader.service;

import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import ru.sharphurt.cronrssreader.client.NewsStorageClient;
import ru.sharphurt.cronrssreader.dto.response.ClientResponse;
import ru.sharphurt.cronrssreader.service.rss.impl.GetLastPublicationTimeServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.sharphurt.cronrssreader.sample.RssFeedSample.parsedRssFeed;

@ExtendWith(MockitoExtension.class)
public class GetLastPublicationTimeServiceTest {

    @Mock
    private NewsStorageClient httpClient;

    @InjectMocks
    private GetLastPublicationTimeServiceImpl service;

    @Test
    public void getLastPublication_successTest() {
        when(httpClient.getLastToday()).thenReturn(new ClientResponse<>(parsedRssFeed.getFirst()));

        var lastPublication = service.getLastPublicationTime();
        assertEquals(parsedRssFeed.getFirst().getPublicationDate(), lastPublication);
    }

    @Test
    public void getLastPublication_exceptionTest() {
        ReflectionTestUtils.setField(service, "rssTimezone", "+03:00");
        when(httpClient.getLastToday()).thenThrow(FeignException.NotFound.class);

        var lastPublication = service.getLastPublicationTime();
        var midnight = ZonedDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT, ZoneId.of("+03:00"));
        assertEquals(midnight, lastPublication);
    }

}
