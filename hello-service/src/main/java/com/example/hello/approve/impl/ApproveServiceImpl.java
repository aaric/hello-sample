package com.example.hello.approve.impl;

import com.example.hello.approve.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PageaService pageaService;

    @Autowired
    private BudgetService budgetService;

    @Override
    public Integer agree(String id, String dealId, String remark) throws Exception {
        // id -> workflow_id, bizId
        String workflow_id = null;
        String bizId = null;

        Integer flag = 0;

        BaseApproveCallbackService callbackService = null;

        switch (workflow_id) {
            case BaseApproveService.WORKFLOW_PAGEA:
                callbackService = pageaService;
                break;

            case BaseApproveService.WORKFLOW_BUDGET:
                callbackService = budgetService;
                break;
        }

        if (null != callbackService) {
            // Agree
            flag = callbackService.agree(bizId, dealId, remark);

            // TODO flag
            if (0 != flag) {
                // update status
            }
        }

        return null;
    }
}
