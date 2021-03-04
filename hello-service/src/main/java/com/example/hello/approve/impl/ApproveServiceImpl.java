package com.example.hello.approve.impl;

import com.example.hello.approve.ApproveService;
import com.example.hello.approve.BaseApproveCallbackService;
import com.example.hello.approve.BaseApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ApproveService
 *
 * @author Aaric, created on 2021-03-04T18:05.
 * @version 0.6.0-SNAPSHOT
 */
@Service
public class ApproveServiceImpl implements ApproveService {

    @Autowired
    @Qualifier("pageaService")
    private BaseApproveCallbackService pageaService;

    @Autowired
    @Qualifier("budgetService")
    private BaseApproveCallbackService budgetService;

    @Override
    public Integer agree(String id, String dealId, String remark) throws Exception {
        // id -> workflow_id, bizId
        String workflow_id = null;
        String bizId = null;

        Integer flag = 0;

        switch (workflow_id) {
            case BaseApproveService.WORKFLOW_PAGEA:
                flag = pageaService.agree(bizId, dealId, remark);
                break;

            case BaseApproveService.WORKFLOW_BUDGET:
                flag = budgetService.agree(bizId, dealId, remark);
                break;
        }

        // TODO flag
        if (0 != flag) {
            // update status
        }

        return null;
    }
}
