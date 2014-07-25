/**
 * SKC-Core Mod
 * Copyright © 2013-2014 SackCastellon
 * This modification and his resources are licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 Unported License.
 * 
 * 		http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package com.sackcastellon.core.helper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class LogHelper {

	public static void log(String mod, Level level, String message) {
		LogManager.getLogger("SKC Logger").log(level, "[" + mod + "] " + message);
	}
	
	public static void info(String mod, String message)
	{    	
		LogManager.getLogger("SKC Logger").info("[" + mod + "] " + message);
	}
	
	public static void error(String mod, String message) {
		LogManager.getLogger("SKC Logger").error("[" + mod + "] " + message);
	}
	
	public static void warning(String mod, String message) {
		LogManager.getLogger("SKC Logger").warn("[" + mod + "] " + message);
	}

}
