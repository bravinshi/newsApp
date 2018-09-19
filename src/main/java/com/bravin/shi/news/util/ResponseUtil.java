package com.bravin.shi.news.util;

import com.bravin.shi.news.constant.CodeConstant;
import com.bravin.shi.news.constant.MessageConstant;
import com.bravin.shi.news.entity.ResponseEntity;

public class ResponseUtil {

    /**
     * 创建一个成功的response
     *
     * @param obj 携带的参数
     * @return response
     */
    public static ResponseEntity success(Object obj){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeConstant.CODE_SUCCESS);
        responseEntity.setMessage(MessageConstant.MSG_SUCCESS);
        responseEntity.setData(obj);

        return responseEntity;
    }

    /**
     * 创建一个成功的不带data的response
     *
     * @return response
     */
    public static ResponseEntity success(){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeConstant.CODE_SUCCESS);
        responseEntity.setMessage(MessageConstant.MSG_SUCCESS);

        return responseEntity;
    }

    /**
     * 创建一个非法response
     *
     * @param msg 携带的参数
     * @return response
     */
    public static ResponseEntity illegalParam(String msg){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeConstant.CODE_ILLEGAL_PARAMETER);
        if (!StringUtil.isTrimEmpty(msg)){
            responseEntity.setMessage(msg);
        } else {
            responseEntity.setMessage("param is illegal!");
        }

        return responseEntity;
    }

    /**
     * 创建一个手机验证码不匹配的response
     *
     * @return response
     */
    public static ResponseEntity phoneVerifyCodeNotMatch() {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeConstant.CODE_PHONE_VERIFY_CODE_MISMATCH);
        responseEntity.setMessage("phone and verify code do not match");
        return responseEntity;
    }

    /**
     * 创建一个手机号已注册的reponse
     *
     * @return response
     */
    public static ResponseEntity phoneRegistered() {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeConstant.CODE_PHONE_REGISTERED);
        responseEntity.setMessage("phone number has been registered");
        return responseEntity;
    }
}
