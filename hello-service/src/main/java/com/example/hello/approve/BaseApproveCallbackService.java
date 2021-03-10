package com.example.hello.approve;

/**
 * BaseApproveCallbackService
 *
 * @author Aaric, created on 2021-03-04T17:48.
 * @version 0.6.0-SNAPSHOT
 */
public interface BaseApproveCallbackService {

    /**
     * 同意
     *
     * @param bizId  业务ID
     * @param dealId 审批人ID
     * @param remark 审批建议
     * @return 最终审批状态：0-待审批，1-已同意，2-已拒绝
     */
    Integer agree(String bizId, String dealId, String remark)
            throws Exception;

    /**
     * 拒绝
     *
     * @param bizId  业务ID
     * @param dealId 审批人ID
     * @param remark 审批建议
     * @return 最终审批状态：0-待审批，1-已同意，2-已拒绝
     */
    Integer refuse(String bizId, String dealId, String remark)
            throws Exception;

    /**
     * 退回修改
     *
     * @param bizId  业务ID
     * @param dealId 审批人ID
     * @param remark 审批建议
     * @return 最终审批状态：0-待审批，1-已同意，2-已拒绝
     */
    Integer withdraw(String bizId, String dealId, String remark)
            throws Exception;

}
