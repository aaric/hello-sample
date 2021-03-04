package com.example.hello.approve.impl;

import com.example.hello.approve.BaseApproveCallbackService;
import com.example.hello.approve.BaseApproveService;
import com.example.hello.approve.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BudgetServiceImpl
 *
 * @author Aaric, created on 2021-03-04T17:59.
 * @version 0.6.0-SNAPSHOT
 */
@Service
public class BudgetServiceImpl implements BudgetService, BaseApproveCallbackService {

    @Autowired
    private BaseApproveService baseApproveService;

    @Override
    public String createApprove() throws Exception {
        return baseApproveService.createRecord(BaseApproveService.WORKFLOW_BUDGET,
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
