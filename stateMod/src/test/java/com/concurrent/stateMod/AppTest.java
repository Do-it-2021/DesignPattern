package com.concurrent.stateMod;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.concurrent.stateMod.mod.StateHandler;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	 private Logger logger = LoggerFactory.getLogger(AppTest.class);
	 
	/* @Test
	 public void test() {
		 
		  // 初始化数据
	        String activityId = "100001";
	        ActivityService.init(activityId, Status.Editing);

	        ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
	        Result resultRefuse = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Refuse);

	        logger.info("测试结果(编辑中To审核拒绝)：{}", JSON.toJSONString(resultRefuse));

	        Result resultCheck = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Check);
	        logger.info("测试结果(编辑中To提交审核)：{}", JSON.toJSONString(resultCheck));

		 
	 }*/
	 
	 @Test
	    public void test_Editing2Arraignment() {
	        String activityId = "100001";
	        ActivityService.init(activityId, Status.Editing);

	        StateHandler stateHandler = new StateHandler();
	        Result result = stateHandler.arraignment(activityId, Status.Editing);

	        logger.info("测试结果(编辑中To提审活动)：{}", JSON.toJSONString(result));
	        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
	    }

	    @Test
	    public void test_Editing2Open() {
	        String activityId = "100001";
	        ActivityService.init(activityId, Status.Editing);

	        StateHandler stateHandler = new StateHandler();
	        Result result = stateHandler.open(activityId, Status.Editing);

	        logger.info("测试结果(编辑中To开启活动)：{}", JSON.toJSONString(result));
	        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
	    }

	    @Test
	    public void test_Refuse2Doing() {
	        String activityId = "100001";
	        ActivityService.init(activityId, Status.Refuse);

	        StateHandler stateHandler = new StateHandler();
	        Result result = stateHandler.doing(activityId, Status.Refuse);

	        logger.info("测试结果(拒绝To活动中)：{}", JSON.toJSONString(result));
	        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
	    }

	    @Test
	    public void test_Refuse2Revoke() {
	        String activityId = "100001";
	        ActivityService.init(activityId, Status.Refuse);

	        StateHandler stateHandler = new StateHandler();
	        Result result = stateHandler.checkRevoke(activityId, Status.Refuse);

	        logger.info("测试结果(拒绝To撤审)：{}", JSON.toJSONString(result));
	        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
	    }
	 
	 
}
