package com.example.hello.json.jackson;

import com.example.hello.utils.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * 日期转秒时间戳序列化器
 *
 * @author Aaric, created on 2020-12-22T16:31.
 * @version 0.4.0-SNAPSHOT
 */
public class WriteDateAsSecondsSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (null != value) {
            gen.writeNumber(String.valueOf(DateUtil.secondsTo(value)));
        }
    }
}
