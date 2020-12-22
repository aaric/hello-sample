package com.example.hello.api.system.impl;

import com.example.hello.data.ApiData;
import com.example.hello.api.system.FileApi;
import org.springframework.web.bind.annotation.*;

/**
 * 文件管理API控制器
 *
 * @author Aaric, created on 2020-12-04T11:57.
 * @version 0.1.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/v1/admin/system/file")
public class FileController implements FileApi {

    @Override
    @GetMapping("/{id}")
    public ApiData<Integer> get(@PathVariable Integer id) {
        return new ApiData<Integer>()
                .setData(id);
    }

    @Override
    @PostMapping("/{index}/{size}")
    public ApiData<String> page(@PathVariable Integer index, @PathVariable Integer size) {
        return new ApiData<String>()
                .setData(String.format("%d-%d", index, size));
    }
}
