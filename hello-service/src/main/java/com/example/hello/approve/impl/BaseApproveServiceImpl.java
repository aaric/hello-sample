package com.example.hello.approve.impl;

import com.example.hello.approve.BaseApproveService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BaseApproveServiceImpl
 *
 * @author Aaric, created on 2021-03-04T17:49.
 * @version 0.6.0-SNAPSHOT
 */
@Service
public class BaseApproveServiceImpl implements BaseApproveService {

    @Override
    public String createRecord(String typeId, String bizId, String sponsorId, List<String> approverIds, List<String> informerIds) throws Exception {
        return "20210304180000999";
    }
}
