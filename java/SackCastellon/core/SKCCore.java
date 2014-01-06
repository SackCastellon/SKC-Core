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

package SackCastellon.core;

import java.io.File;

import SackCastellon.core.handler.ConfigHandler;
import SackCastellon.core.handler.SkcEventHandler;
import SackCastellon.core.helper.Version;
import SackCastellon.core.proxy.CommonProxy;
import SackCastellon.core.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.ID, name=Reference.NAME, version=Reference.VERSION, dependencies=Reference.DEPENDENCIES)
public class SKCCore {
	
	@Instance(Reference.ID)
	public static SKCCore instance;
	
	@SidedProxy(clientSide=Reference.CLPROXY, serverSide=Reference.CMPROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)  {
		
		SkcEventHandler.init();
		
		ConfigHandler.loadConfig(new File(event.getModConfigurationDirectory(), Reference.ConfigPath));
		
		if (ConfigHandler.CheckVersion) {
			Version.check(Reference.ID, Reference.VERSION, Reference.URL);
		}
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)  {}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)  {}

}