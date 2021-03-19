package com.example.hello.es;

import com.example.hello.TestApp;
import com.example.hello.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * ElasticsearchTests
 *
 * @author Aaric, created on 2021-03-11T17:20.
 * @version 0.8.0-SNAPSHOT
 */
@Disabled
@Slf4j
@SpringBootTest(classes = TestApp.class)
@ExtendWith(SpringExtension.class)
public class ElasticsearchTests {

    public static final List<Goods> GOODS_LIST = new ArrayList<>();

    static {
        GOODS_LIST.add(new Goods(1L, "自动铅笔", "文具", "晨光", 2.00,
                "该商品供应充足。", new String[]{"小学", "初中", "高中", "大学"}));
        GOODS_LIST.add(new Goods(2L, "橡皮擦", "文具", "晨光", 1.00,
                "该商品供应充足。", new String[]{"小学", "初中", "高中", "大学"}));
        GOODS_LIST.add(new Goods(3L, "钢笔", "文具", "得力", 5.00,
                "该商品暂时缺货。", new String[]{"初中", "高中", "大学"}));
        GOODS_LIST.add(new Goods(4L, "文具盒", "文具", "得力", 10.00,
                "该商品暂时缺货。", new String[]{"小学", "初中", "高中"}));
        GOODS_LIST.add(new Goods(5L, "笔记本", "文具", "真彩", 15.00,
                "该商品供应充足。", new String[]{"初中", "高中", "大学"}));
        GOODS_LIST.add(new Goods(6L, "彩色铅笔", "文具", "晨光", 2.00,
                "该商品供应充足。", new String[]{"小学"}));
    }

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void testCreateIndex() {
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(Goods.class);
        if (!indexOperations.exists()) {
            indexOperations.create();
            Document mapping = indexOperations.createMapping();
            indexOperations.putMapping(mapping);
        }
    }

    @Test
    public void testSave() {
        GOODS_LIST.forEach(goods -> elasticsearchRestTemplate.save(goods));
    }

    @Test
    public void testQuery() {
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("members", "hello"))
                .build();
        SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(query, Goods.class);
        searchHits.forEach(searchHit -> {
            System.err.println(searchHit.getContent());
        });

    }
}
