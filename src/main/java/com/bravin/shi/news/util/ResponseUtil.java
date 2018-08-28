package com.bravin.shi.news.util;

import com.bravin.shi.news.constant.CodeConstant;
import com.bravin.shi.news.constant.MessageConstant;
import com.bravin.shi.news.entity.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity success(Object obj){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeConstant.CODE_SUCCESS);
        responseEntity.setMessage(MessageConstant.MSG_SUCCESS);
        responseEntity.setData(obj);

        return responseEntity;
    }

    public static ResponseEntity success(){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(CodeConstant.CODE_SUCCESS);
        responseEntity.setMessage(MessageConstant.MSG_SUCCESS);

        return responseEntity;
    }

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
}
