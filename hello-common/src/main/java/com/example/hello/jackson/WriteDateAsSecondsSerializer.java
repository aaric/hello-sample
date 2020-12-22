package com.example.hello.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * 日期转毫秒时间序列化器
 *
 * @author Aaric, created on 2020-12-22T16:31.
 * @version 0.4.0-SNAPSHOT
 */
public class WriteDateAsSecondsSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (null != value) {
            gen.writeNumber(value.getTime() / 1000L);
        }
    }
}
