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
}
