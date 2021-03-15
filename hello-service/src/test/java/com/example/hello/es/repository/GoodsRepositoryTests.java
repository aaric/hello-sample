package com.example.hello.es.repository;

import com.example.hello.TestApp;
import com.example.hello.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
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
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods(1L, "自动铅笔", "文具", "晨光", 2.00, "该商品供应充足。"));
        goodsList.add(new Goods(2L, "橡皮擦", "文具", "晨光", 1.00, "该商品供应充足。"));
        goodsList.add(new Goods(3L, "钢笔", "文具", "得力", 5.00, "该商品暂时缺货。"));
        goodsList.add(new Goods(4L, "文具盒", "文具", "得力", 10.00, "该商品暂时缺货。"));
        goodsList.add(new Goods(5L, "笔记本", "文具", "真彩", 15.00, "该商品供应充足。"));
    }

    @Test
    public void testFindAll() {
        Iterable<Goods> goodsIt = goodsRepository.findAll();
        goodsIt.forEach(o -> {
            log.info("id: {}, title: {}", o.getId(), o.getTitle());
        });
    }

    @Test
    public void testDeleteById() {
        goodsRepository.deleteById(1L);
    }

    @Test
    public void testFindByTitle() {
        List<Goods> goodsList = goodsRepository.findByTitle("文具");
        goodsList.forEach(o -> {
            log.info("id: {}, title: {}", o.getId(), o.getTitle());
        });
    }

    @Test
    public void testFindByPriceBetween() {
        List<Goods> goodsList = goodsRepository.findByPriceBetween(2.00, 5.00);
        goodsList.forEach(o -> {
            log.info("id: {}, title: {}", o.getId(), o.getTitle());
        });
    }

    @Test
    public void testFindByTitleOperator() {
        List<Goods> goodsList = goodsRepository.findByTitleOperator("文具", "or");
        goodsList.forEach(o -> {
            log.info("id: {}, title: {}", o.getId(), o.getTitle());
        });
    }
}
