package com.example.hello.api.impl;

import com.example.hello.api.FileApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件管理API控制器
 *
 * @author Aaric, created on 2020-12-04T11:57.
 * @version 0.1.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/file")
public class FileController implements FileApi {

    @Override
    @GetMapping("/page/{index}/{size}")
    public String page(@PathVariable Integer index, @PathVariable Integer size) {
        return "null";
    }
}
