package com.example.hello.approve;

/**
 * PageaService
 *
 * @author Aaric, created on 2021-03-04T17:53.
 * @version 0.6.0-SNAPSHOT
 */
public interface PageaService extends BaseApproveCallbackService {

    /**
     * 创建审批
     *
     * @return
     * @throws Exception
     */
    String createApprove() throws Exception;
}
