/**
 * SKC-Core Mod
 * Copyright © 2013-2014 SackCastellon
 * This modification and his resources are licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 Unported License.
 * 
 * 		http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package com.sackcastellon.core.handler;

import java.io.File;

import com.sackcastellon.core.helper.LogHelper;
import com.sackcastellon.core.lib.Config;
import com.sackcastellon.core.lib.Reference;

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