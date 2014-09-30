package com.yao.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(LoggerDemo.class.getName());
		log.log(Level.SEVERE, "Severe ��Ϣ");
		log.log(Level.WARNING, "Warning ��Ϣ");
		log.log(Level.INFO, "Info ��Ϣ");
		
		log.log(Level.CONFIG,"Config ��Ϣ");
		log.log(Level.FINE, "Fine ��Ϣ");
	}

}
