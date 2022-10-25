package com.seeder.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLocalReq {
    private String query = "공부하기 좋은 장소";
    private Integer display = 5;
    private Integer start = 1;
    private String sort = "random";

    public SearchLocalReq(String query) {
        this.query = query;
    }

    public LinkedMultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();

        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);

        return map;
    }
}
