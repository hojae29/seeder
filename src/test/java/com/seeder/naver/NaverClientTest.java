package com.seeder.naver;

import com.seeder.naver.dto.PlaceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NaverClientTest {

    @Autowired
    NaverClient naverClient;

    @Test
    public void searchImageTest()  {
        var res = naverClient.searchImage("프라임 스터디카페");
        System.out.println(res);
        assertEquals(res.getItems().size(), 10);
    }

    @Test
    public void searchLocalTest()  {
        var res = naverClient.searchLocal();
        System.out.println(res);
    }

    @Test
    public void searchPopularPlaceTest(){
        List<PlaceDto> placeDto = naverClient.searchPopularPlace();

        System.out.println(placeDto);
    }
}