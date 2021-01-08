package com.example.hello.json.jackson;

import com.example.hello.utils.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * 日期转秒时间戳反序列化器
 *
 * @author Aaric, created on 2020-12-22T16:29.
 * @version 0.4.0-SNAPSHOT
 */
public class WriteDateAsSecondsDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        return DateUtil.secondsFrom(parser.getText());
    }
}
