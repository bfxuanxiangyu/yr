package com.weeds.utils;

/**
 * Created by Administrator on 2016/2/12.
 */
public interface SmsConstants {

    /**
     * 校验码
     * 【野草科技】验证码:{0}，请在5分钟内按页面提示提交验证码，欢迎注册野草科技
     */
    String VALIDATE_CODE = "validate_code";

    /**
     * 加急预约请求
     * 【野草科技】您有1个加急预约请求，预约时间为{0}{1}，如果您接受该次预约请求请访问以下链接：{2}
     */
    String URGENT_APPOINT_REQUEST = "urgent_appoint_request";

    /**
     * 特殊预约码
     * 【野草科技】医生同意了您的预约请求，您的特殊预约码为{0}
     */
    String URGENT_SPECIAL_CODE = "urgent_special_code";

    /**
     * 患者支付成功通知
     * 【野草科技】您已经预约成功！订单号：{orderNo}，订单金额：{price}元，
     * 就诊时间：{appointDate} {appointHourRange}，请等待医生联系。
     */
    String PATIENT_PAY_SUCCESS_NOTICE = "patient_pay_success_notice";

    /**
     * 订单支付成功后医生通知
     * 【野草科技】新单提醒！订单号：{orderNo}，就诊人：{patientName}，
     * 电话：{patientMobile}，预约时间：{appointDate} {appointHourRange}，
     * 支付金额：{price}元,请主动与患者联系！
     */
    String ORDER_PAY_SUCCESS_EXPERT_NOTICE = "order_pay_success_expert_notice";

    /**
     * 退款请求
     * 【野草科技】有患者“{patientName}”要求退款取消预约，订单号：{orderNo}，
     * 患者手机：{patientMobile}，退款验证码：{captchaCode}，请尽快与该患者联系
     */
    String PATIENT_REFUNDS_REQUEST = "patient_refunds_request";

    /**
     * 医生订单取消提醒
     * 【野草科技】订单取消提醒！订单编号：{orderNo}，就诊人：{patientName}，就诊时间：{appointDate}，订单已取消，请知悉！
     */
    String EXPERT_CANCEL_APPOINT = "expert_cancel_appoint";

    /**
     * 订单被取消通知患者
     * 【野草科技】订单取消提醒！订单编号：{orderNo}，就诊时间：{appointDate}，订单被取消了，请知悉！
     */
    String PATIENT_APPOINT_CANCELLED_REMIND_PATIENT = "patient_appoint_cancelled_remind_patient";

    /**
     * 订单被医生取消通知客服
     * 【野草科技】订单编号：{orderNo}，被医生取消了，请尽快办理退款手续！
     */
    String PATIENT_APPOINT_CANCELLED_REMIND_CUSTOMER_SERVICE = "patient_appoint_cancelled_remind_customer_service";

    /**
     * 订单预约时间变更通知医生
     * 【野草科技】订单编号：{orderNo}，预约时间由{oldAppointDate} {oldAppointHourRange}
     * 变更为{newAppointDate} {newAppointHourRange}，到时请主动与患者联系！
     */
    String UPDATE_APPOINT_REMIND_EXPERT = "update_appoint_remind_expert";

    /**
     * 订单预约时间变更通知患者
     * 【野草科技】订单编号：{orderNo}预约时间已被医生修改，预约时间{oldAppointDate} {oldAppointHourRange}变
     * 更为{newAppointDate} {newAppointHourRange}，请等待医生联系，有任何问题请联系客服!
     */
    String UPDATE_APPOINT_REMIND_PATIENT = "update_appoint_remind_patient";

    /**
     * 患者特殊预约通知客服
     * 【野草科技】患者“{patientName}”希望特殊预约，时间“{appointDate} {hourArrange}”，
     * 医生{expertName}电话{expertMobile},如果可以，请您回复患者电话{patientMobile}
     * “特殊预约号：{specialCode}”。否则，请回复“不能”或回复适合的时间段。
     */
    String URGENT_APPOINT_REQUEST_OLD = "urgent_appoint_request_old";

}
