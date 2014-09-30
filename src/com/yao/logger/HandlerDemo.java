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
		
		FileHandler handler = new FileHandler("%h/config%g.log");//%h��ʾ���û��ĸ�Ŀ¼�� windows Ϊ C:\Users\Kangjun �£�%g��ʾ�Զ�Ϊ�ĵ����
		handler.setLevel(Level.CONFIG);
		handler.setFormatter(new Formatter(){
			public String format(LogRecord logRecord){
				return logRecord.getSourceClassName()+"\t"+
						logRecord.getLevel()+"\t"+
						logRecord.getMessage()+"\t"+
						logRecord.getMillis()+"\n";
			}
		});
		
		//log.setUseParentHandlers(false);��ʹ�ø�������
		log.addHandler(handler);
		log.config("Log ��̬��ɡ�");
		//log.log(Level.INFO, "Info ��Ϣ");
	}
}
