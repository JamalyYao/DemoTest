package com.yao.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo2 {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(LoggerDemo2.class.getName());
		log.setLevel(Level.FINER);
		
		for(Handler handler : log.getParent().getHandlers()){
			handler.setLevel(Level.FINE);
		}
		log.log(Level.SEVERE, "Severe 信息");
		log.log(Level.WARNING, "Warning 信息");
		log.log(Level.INFO, "Info 信息");
		
		log.log(Level.CONFIG,"Config 信息");
		log.log(Level.FINE, "Fine 信息");
	}

}
