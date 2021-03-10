package com.example.hello.approve.impl;

import com.example.hello.approve.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ApproveService
 *
 * @author Aaric, created on 2021-03-04T18:05.
 * @version 0.6.0-SNAPSHOT
 */
@Slf4j
@Service
public class ApproveServiceImpl implements ApproveService {

    @Autowired
    private PageaService pageaService;

    @Autowired
    private BudgetService budgetService;

    @Override
    public Integer deal(String id, String dealId, Integer status, String remark) throws Exception {
        // id -> workflow_id, bizId
        String workflowId = null;
        String bizId = null;

        BaseApproveCallbackService callbackService = null;
        switch (workflowId) {
            case BaseApproveService.WORKFLOW_PAGEA:
                callbackService = pageaService;
                break;

            case BaseApproveService.WORKFLOW_BUDGET:
                callbackService = budgetService;
                break;
            default:
        }

        if (null != callbackService) {
            Integer flag = 0;
            switch (status) {
                case 1:
                    // Agree
                    flag = callbackService.agree(bizId, dealId, remark);
                    break;
                case 2:
                    // Refuse
                    flag = callbackService.refuse(bizId, dealId, remark);
                    break;
                case 3:
                    // Withdraw
                    flag = callbackService.withdraw(bizId, dealId, remark);
                    break;
                default:
            }

            // TODO flag
            if (0 != flag) {
                // update status
                log.info("flag: {}", flag);
            }
        }

        return null;
    }
}
