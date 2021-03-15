package com.example.hello.es.repository;

import com.example.hello.TestApp;
import com.example.hello.es.ElasticsearchTests;
import com.example.hello.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * GoodsRepositoryTests
 *
 * @author Aaric, created on 2021-03-15T11:32.
 * @version 0.8.0-SNAPSHOT
 */
@Disabled
@Slf4j
@SpringBootTest(classes = TestApp.class)
@ExtendWith(SpringExtension.class)
public class GoodsRepositoryTests {

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    public void testSaveAll() {
        List<Goods> goodsList = ElasticsearchTests.GOODS_LIST;
        goodsRepository.saveAll(goodsList);
    }

    @Test
    public void testFindAll() {
        Iterable<Goods> goodsIt = goodsRepository.findAll();
        goodsIt.forEach(goods -> {
            log.info("id: {}, title: {}", goods.getId(), goods.getTitle());
        });
    }

    @Test
    public void testDeleteById() {
        goodsRepository.deleteById(1L);
    }

    @Test
    public void testFindByTitle() {
        List<Goods> goodsList = goodsRepository.findByTitle("文具");
        goodsList.forEach(goods -> {
            log.info("id: {}, title: {}", goods.getId(), goods.getTitle());
        });
    }

    @Test
    public void testFindByPriceBetween() {
        List<Goods> goodsList = goodsRepository.findByPriceBetween(2.00, 5.00);
        goodsList.forEach(goods -> {
            log.info("id: {}, title: {}", goods.getId(), goods.getTitle());
        });
    }

    @Test
    public void testFindByTitleOperator() {
        List<Goods> goodsList = goodsRepository.findByTitleOperator("文具", "or");
        goodsList.forEach(goods -> {
            log.info("id: {}, title: {}", goods.getId(), goods.getTitle());
        });
    }
}
