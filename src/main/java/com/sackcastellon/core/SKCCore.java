/**
 * SKC-Core Mod
 * Copyright © 2013-2014 SackCastellon
 * This modification and his resources are licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 Unported License.
 * 
 * 		http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package com.sackcastellon.core;

import java.io.File;

import com.sackcastellon.core.event.SKCEvents;
import com.sackcastellon.core.handler.ConfigHandler;
import com.sackcastellon.core.helper.VersionHelper;
import com.sackcastellon.core.lib.Reference;
import com.sackcastellon.core.proxy.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.ID, name=Reference.NAME, version=Reference.VERSION, dependencies=Reference.DEPENDENCIES)
public class SKCCore
{
	@Instance(Reference.ID)
	public static SKCCore instance;
	
	@SidedProxy(clientSide=Reference.CLPROXY, serverSide=Reference.CMPROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new SKCEvents());
		
		ConfigHandler.loadConfig(new File(event.getModConfigurationDirectory(), Reference.ConfigPath));
		
		if (ConfigHandler.CheckVersion)
		{
			VersionHelper.check(Reference.CheckParams);
		}
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)  {}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)  {}
} 