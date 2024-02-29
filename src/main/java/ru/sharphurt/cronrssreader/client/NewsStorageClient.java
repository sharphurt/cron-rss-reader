package ru.sharphurt.cronrssreader.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sharphurt.cronrssreader.dto.NewsInformationDto;
import ru.sharphurt.cronrssreader.dto.response.ClientResponse;

import java.util.List;

@FeignClient(name = "NewsStorageClient", url = "${application.external-storage-url}")
public interface NewsStorageClient {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ClientResponse<String> uploadNews(List<NewsInformationDto> news);

    @GetMapping(value = "/last", consumes = MediaType.APPLICATION_JSON_VALUE)
    ClientResponse<NewsInformationDto> getLastToday();
}
