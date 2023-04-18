package com.flowerchar.tliaswebmanagement;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
        List<Integer> list = new ArrayList<>();
        System.out.println(list instanceof Object);
    }



}
