package com.concurrent.stateMod.mod.impl;

import com.concurrent.stateMod.ActivityService;
import com.concurrent.stateMod.Result;
import com.concurrent.stateMod.Status;
import com.concurrent.stateMod.mod.State;

public class EditingState extends State {

	public Result arraignment(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Check);
        return new Result("0000", "活动提审成功");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可审核通过");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可审核拒绝");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可撤销审核");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动关闭成功");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "非关闭活动不可开启");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中活动不可执行活动中变更");
    }

}
