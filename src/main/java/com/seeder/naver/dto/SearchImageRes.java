package com.seeder.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchImageRes {
    private Date lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;
    private List<SearchImageItem> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchImageItem {
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;
    }
}
