package com.example.hello.api.test.impl;

import com.example.hello.api.test.TestApi;
import com.example.hello.data.ApiData;
import com.example.hello.data.ApiException;
import com.example.hello.emqx.MqttPublishService;
import com.example.hello.pojo.ValidBean;
import com.example.hello.validation.groups.Other;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

/**
 * 测试模块API控制器
 *
 * @author Aaric, created on 2020-12-18T15:13.
 * @version 0.2.0-SNAPSHOT
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/admin/test/test")
public class TestController implements TestApi {

    @Override
    @GetMapping("/hello")
    public ApiData<String> hello(@RequestParam(required = false) String msg) throws Exception {
        if (StringUtils.isBlank(msg)) {
            throw new ApiException(10001, "fake!!!");
        }

        return new ApiData<String>()
                .setData(msg);
    }

    @Override
    @GetMapping(value = "/text2json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String text2json() throws Exception {
        return "{\"application\": \"hello-web-admin\",\"version\": \"0.4.0-SNAPSHOT\"}";
    }

    @Override
    @PostMapping("/form")
    public ApiData<Date> form(@RequestParam Date creationTime) throws Exception {
        log.info("form | creationTime={}", creationTime);
        creationTime = new Date();
        return new ApiData<Date>()
                .setData(creationTime);
    }

    @Override
    @PostMapping("/upLoadFile")
    public ApiData<String> upLoadFile(@RequestPart MultipartFile uploadFile) {
        String path = "error";
        try {
            String storagePath = System.getProperty("java.io.tmpdir");
            String fileName = uploadFile.getOriginalFilename();
            File storageFile = new File(storagePath, fileName);

            uploadFile.transferTo(storageFile);
            log.info("upLoadFile -> storagePath: {}, fileName: {}, fileSize: {}, fileHash256: {}",
                    storagePath,
                    fileName,
                    storageFile.getTotalSpace(),
                    DigestUtils.sha256Hex((new FileInputStream(storageFile))));

            path = storageFile.getAbsolutePath();

        } catch (IOException e) {
            log.error("upLoadFile exception", e);
        }

        return new ApiData<String>()
                .setData(path);
    }

    @Override
    @PostMapping("/valid")
    public ApiData<Long> valid(@Valid @RequestBody ValidBean validBean) throws Exception {
        log.info("valid | validBean={}", validBean);
        return new ApiData<Long>()
                .setData(1L);
    }

    @Override
    @PostMapping("/valid/custom")
    public ApiData<Long> validCustom(@RequestBody ValidBean validBean) throws Exception {
        log.info("validCustom | validBean={}", validBean);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ValidBean>> validateResults = validator.validate(validBean, Other.class);
        if (null != validateResults && 0 != validateResults.size()) {
            throw new ConstraintViolationException(validateResults);
        }

        return new ApiData<Long>()
                .setData(1L);
    }

    @Autowired
    private MqttPublishService mqttPublishService;

    @Override
    @PostMapping("/mqtt")
    public ApiData<String> mqtt(@RequestParam String topic,
                                @RequestParam String content) throws Exception {
        boolean flag = mqttPublishService.publish(topic, content);
        return new ApiData<String>()
                .setData(String.valueOf(flag));
    }

    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    @PostMapping("/ldap")
    public ApiData<Boolean> ldap(String account, String secret) throws Exception {
        ldapTemplate.setIgnorePartialResultException(true);

        EqualsFilter filter = new EqualsFilter("cn", account);
        boolean flag = ldapTemplate.authenticate("ou=testdc", filter.toString(), secret);
        log.debug("{} login: {}", account, flag);

        return new ApiData<Boolean>()
                .setData(flag);
    }
}
