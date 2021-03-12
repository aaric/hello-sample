package com.example.hello.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 商品信息
 *
 * @author Aaric, created on 2021-03-11T16:31.
 * @version 0.8.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "商品信息")
@Document(indexName = "test_goods", shards = 3, replicas = 0)
public class Goods {

    @ApiModelProperty(position = 1, value = "ID", example = "1")
    @Id
    private Long id;

    @ApiModelProperty(position = 2, value = "商品名称", example = "自动铅笔")
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;

    @ApiModelProperty(position = 3, value = "分类", example = "文具")
    @Field(type = FieldType.Keyword)
    private String category;

    @ApiModelProperty(position = 4, value = "品牌", example = "晨光")
    @Field(type = FieldType.Keyword)
    private String brand;

    @ApiModelProperty(position = 5, value = "价格", example = "2.00")
    @Field(type = FieldType.Double)
    private Double price;

    @ApiModelProperty(position = 2, value = "商品描述", example = "该商品供应充足。")
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String remark;
}
