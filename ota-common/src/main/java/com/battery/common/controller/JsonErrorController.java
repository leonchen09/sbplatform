package com.battery.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battery.common.Constant;
import com.battery.common.vo.AjaxResponse;

@ControllerAdvice
public class JsonErrorController {

	Logger log = LoggerFactory.getLogger(JsonErrorController.class);
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public AjaxResponse<String> handlerException(Exception e){
		log.error("exception unhandled.", e);
		AjaxResponse<String> ajaxResponse = new AjaxResponse<>(Constant.RS_CODE_ERROR, e.getMessage());
		return ajaxResponse;
	}
	

}
