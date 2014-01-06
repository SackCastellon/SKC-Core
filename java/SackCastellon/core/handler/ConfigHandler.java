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

package SackCastellon.core.handler;

import java.io.File;

import SackCastellon.core.helper.Config;
import SackCastellon.core.helper.LogHelper;
import SackCastellon.core.reference.Reference;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	private static Configuration config;
	public static boolean CheckVersion;

	public static void loadConfig(File file) {
		
		config = new Configuration(file);
		
		try {
			
			LogHelper.info(Reference.ID, "Loading config file.");
			
			config.load();
			
			CheckVersion = config.get(Config.GENERAL, "CheckVersion", true, "Will check the mod's version and will notity you if there are a new version of the mod.").getBoolean(true);
			
			if (config.hasChanged()) {
				
				config.save();
				
			}
			
			LogHelper.info(Reference.ID, "Config file succesfully loaded.");
			
		} catch (Exception e) {
			
			LogHelper.info(Reference.ID, "Could not load the config file.");
			
		}
	}
}