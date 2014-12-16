package com.yao.logger;

import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class HandlerDemo {
	public static void main(String[] args) throws SecurityException, IOException {
		Logger log = Logger.getLogger(HandlerDemo.class.getName());
		log.setLevel(Level.CONFIG);
		
		FileHandler handler = new FileHandler("%h/config%g.log");//%h表示在用户的根目录下 windows 为 C:\Users\Kangjun 下，%g表示自动为文档编号
		handler.setLevel(Level.CONFIG);
		handler.setFormatter(new Formatter(){
			public String format(LogRecord logRecord){
				return logRecord.getSourceClassName()+"\t"+
						logRecord.getLevel()+"\t"+
						logRecord.getMessage()+"\t"+
						logRecord.getMillis()+"\n";
			}
		});
		
		//log.setUseParentHandlers(false);不使用父处理器
		log.addHandler(handler);
		log.config("Log 组态完成。");
		//log.log(Level.INFO, "Info 信息");
	}
}
