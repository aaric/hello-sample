package com.example.hello.api.impl;

import com.example.common.utils.RandomUtil;
import com.example.hello.api.FileApi;
import org.springframework.web.bind.annotation.*;

/**
 * 文件管理API控制器
 *
 * @author Aaric, created on 2020-12-04T11:57.
 * @version 0.1.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/v1/file")
public class FileController implements FileApi {

    @Override
    @GetMapping("/{id}")
    public String get(@PathVariable Integer id) {
        return "get-" + RandomUtil.nextInt(10);
    }

    @Override
    @PostMapping("/{index}/{size}")
    public String page(@PathVariable Integer index, @PathVariable Integer size) {
        return "page-" + RandomUtil.nextInt(10);
    }
}
