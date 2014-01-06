/*
 * SKC-Core Mod created by SackCastellon is licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * 
 * 		http://creativecommons.org/licenses/by-nc-sa/3.0/
 * 
 * The source code of SKC-Core Mod created by SackCastellon is
 * licensed under a Creative Commons Attribution 3.0 Unported License,
 * 
 * 		http://creativecommons.org/licenses/by/3.0/
 * 
 * The source code of SKC-Core Mod created by SackCastellon can be found at:
 * 
 * 		https://github.com/SackCastellon/SKC-Core
 */

package SackCastellon.core.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogHelper {

	public static void log(String mod, Level logLevel, String message) {
		Logger.getLogger(mod).log(logLevel, message);
	}
	
	public static void info(String mod, String message) {
		Logger.getLogger(mod).log(Level.INFO, message);
	}
	
	public static void severe(String mod, String message) {
		Logger.getLogger(mod).log(Level.SEVERE, message);
	}
	
	public static void warning(String mod, String message) {
		Logger.getLogger(mod).log(Level.WARNING, message);
	}

}
