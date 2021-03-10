package com.example.hello.approve.impl;

import com.example.hello.approve.BaseApproveService;
import com.example.hello.approve.PageaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PageaServiceImpl
 *
 * @author Aaric, created on 2021-03-04T17:51.
 * @version 0.6.0-SNAPSHOT
 */
@Service
public class PageaServiceImpl implements PageaService {

    @Autowired
    private BaseApproveService baseApproveService;

    @Override
    public String createApprove() throws Exception {
        return baseApproveService.createRecord(BaseApproveService.WORKFLOW_PAGEA,
                null, null, null, null);
    }

    @Override
    public Integer agree(String bizId, String dealId, String remark) throws Exception {
        return null;
    }

    @Override
    public Integer refuse(String bizId, String dealId, String remark) throws Exception {
        return null;
    }

    @Override
    public Integer withdraw(String bizId, String dealId, String remark) throws Exception {
        return null;
    }
}
