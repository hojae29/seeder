package com.seeder.naver;

import com.seeder.naver.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverClient {

    @Value("${naver.url.search.image}")
    private String imageSearchUrl;

    @Value("${naver.url.search.local}")
    private String localSearchUrl;

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;

    public SearchImageRes searchImage(String localName) {
        var uri = UriComponentsBuilder.fromUriString(imageSearchUrl)
                .queryParams(new SearchImageReq(localName).toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<>(getHeaders()), SearchImageRes.class);

        return responseEntity.getBody();
    }

    public SearchLocalRes searchLocal() {
        var uri = UriComponentsBuilder.fromUriString(localSearchUrl)
                .queryParams(new SearchLocalReq().toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<>(getHeaders()), SearchLocalRes.class);

        return responseEntity.getBody();
    }


    public List<PlaceDto> searchPopularPlace() {
        var localRes = searchLocal();

        List<PlaceDto> placeDtoList = new ArrayList<>();

        for (var item : localRes.getItems()) {
            var res = searchImage(item.getTitle());

            placeDtoList.add(PlaceDto.builder()
                    .name(item.getTitle())
                    .imageUrl(res.getItems().get(0).getLink())
                    .address(item.getRoadAddress())
                    .build());
        }

        return placeDtoList;
    }

    public HttpHeaders getHeaders(){
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }
}
