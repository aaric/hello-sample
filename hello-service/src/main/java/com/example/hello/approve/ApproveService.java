package com.example.hello.approve;

/**
 * ApproveService
 *
 * @author Aaric, created on 2021-03-04T18:04.
 * @version 0.6.0-SNAPSHOT
 */
public interface ApproveService {

    /**
     * 同意审批
     *
     * @param id     审批ID
     * @param dealId 审批人ID
     * @param remark 审批建议
     * @return 最终审批状态：0-待审批，1-已同意，2-已拒绝
     */
    Integer agree(String id, String dealId, String remark)
            throws Exception;
}
