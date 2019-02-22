package com.mypj.handle;

import com.mypj.domain.Result;
import com.mypj.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypj.utils.ResultUtils;

/**
 * @author kevinzcf
 */
@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if (e instanceof MyException) {
			MyException myException = (MyException) e;
			return ResultUtils.error(myException.getCode(), myException.getMessage());
		} else {
			logger.error("【系统异常】{}", e);
			return ResultUtils.error(-1, "未知错误");
		}
	}
}
