package com.example.hello;

import com.example.hello.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * ElasticsearchTests
 *
 * @author Aaric, created on 2021-03-11T17:20.
 * @version 0.8.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest(classes = TestApp.class)
@ExtendWith(SpringExtension.class)
public class ElasticsearchTests {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void testCreateIndex() {
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(Goods.class);
        indexOperations.create();
        indexOperations.createMapping();
    }
}
