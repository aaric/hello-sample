package com.example.hello.approve;

import java.util.List;

/**
 * BaseApproveService
 *
 * @author Aaric, created on 2021-03-04T17:42.
 * @version 0.6.0-SNAPSHOT
 */
public interface BaseApproveService {

    /**
     * 发布审批/A面发布单
     */
    String WORKFLOW_PAGEA = "111111111111111111111111";

    /**
     * 消息审批/消息通知
     */
    String WORKFLOW_MSG = "222222222222222222222222";

    /**
     * 财务审批/启动单
     */
    String WORKFLOW_BUDGET = "333333333333333333333333";

    /**
     * 创建审批记录
     *
     * @param typeId      工作流类型ID，参考saic_approve_workflows表
     * @param bizId       业务ID
     * @param sponsorId   申请/发起人
     * @param approverIds 审批人列表
     * @param informerIds 知会/抄送人列表
     * @return 审批编码
     */
    String createRecord(String typeId, String bizId, String sponsorId,
                        List<String> approverIds, List<String> informerIds)
            throws Exception;

}
