package com.seeder.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchImageReq {
    private String query;
    private Integer display = 4;
    private Integer start = 1;
    private String sort = "sim";
    private String filter = "all";

    public SearchImageReq(String query) {
        this.query = query;
    }

    public LinkedMultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();

        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);
        map.add("filter", filter);

        return map;
    }
}
