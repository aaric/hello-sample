package com.example.hello.es.repository;

import com.example.hello.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * GoodsRepository
 *
 * @author Aaric, created on 2021-03-15T11:30.
 * @version 0.8.0-SNAPSHOT
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods, Long> {

    List<Goods> findByTitle(String title);

    List<Goods> findByPriceBetween(Double min, Double max);
}
