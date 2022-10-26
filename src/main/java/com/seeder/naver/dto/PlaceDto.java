package com.seeder.naver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDto {

    private String name;
    private String imageUrl;
    private String address;

}
