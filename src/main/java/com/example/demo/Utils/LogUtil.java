package com.example.demo.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

//	private static StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//	static	String className = new Throwable().getStackTrace()[1].getClassName(); 
	private static final Logger logger = LoggerFactory.getLogger("mylog");
	
	public static void Info(Class<?> abc ,String msg) {
		LoggerFactory.getLogger(abc).info(msg);
		  }
	public static void Debug(Class<?> abc ,String msg) {
		LoggerFactory.getLogger(abc).debug(msg);
		  }
	public static void Error(Class<?> abc ,String msg) {
		LoggerFactory.getLogger(abc).error(msg);
		  }
	public static void Warning(Class<?> abc ,String msg) {
		LoggerFactory.getLogger(abc).warn(msg);
		  }
	public static void mylog(String msg) {
		logger.debug(msg);
		  }
}
