/**
 * SKC-Core Mod
 * Copyright © 2013-2014 SackCastellon
 * This modification and his resources are licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * 
 * 		http://creativecommons.org/licenses/by-nc-sa/3.0/
 */
package com.sackcastellon.core.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class VersionHelper {

	private static String LatestVersion;
	private static String ThreadUrl;
	private static String ModVersion;
	private static String ModName;

	private static String VersionUrl = "https://dl.dropboxusercontent.com/u/184200482/Minecraft/Mods/";
	
	public static String MessageCore;
	public static String MessageCHA;
	public static String MessageBW;

    public static void check(String ID, String Name, String Version, String Url)
    {        
    	String ModID = ID.substring(4);
    	
    	ThreadUrl = Url;
    	ModVersion = Version;
    	ModName = Name;

		try
		{
			URL url = new URL(VersionUrl + ModID + "/Versions/1.7.2.version");
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        LatestVersion = in.readLine();
	        in.close();
	        
	        int newVersion = Integer.parseInt(LatestVersion.substring(LatestVersion.lastIndexOf(".") + 1));
	        int oldVersion = Integer.parseInt(ModVersion.substring(ModVersion.lastIndexOf(".") + 1));

			if (oldVersion < newVersion)
			{
				if (ModName == "SKC Core")
				{
					setMessageCore(Message.getOutMsg(ModName, ModVersion, ThreadUrl, LatestVersion));
				}
				if (ModName == "Craftable Horse Armor")
				{
					setMessageCHA(Message.getOutMsg(ModName, ModVersion, ThreadUrl, LatestVersion));
				}
				if (ModName == "Better Wood")
				{
					setMessageBW(Message.getOutMsg(ModName, ModVersion, ThreadUrl, LatestVersion));
				}
				
				LogHelper.error("SKC Version Checker", ModName + " (" + ModVersion + ") is out of date! Please visit " + ThreadUrl + " to get the latest version (" + LatestVersion +")");
				
			}
			
			else if (oldVersion == newVersion)
			{
				if (ModName == "SKC Core")
				{
					setMessageCore(Message.getOkMsg(ModName, ModVersion));
				}
				if (ModName == "Craftable Horse Armor")
				{
					setMessageCHA(Message.getOkMsg(ModName, ModVersion));
				}
				if (ModName == "Better Wood")
				{
					setMessageBW(Message.getOkMsg(ModName, ModVersion));
				}
				
				LogHelper.info("SKC Version Checker", "You are using the latest version of " + ModName + " (" + ModVersion + ")");
			}
			
			else if (oldVersion > newVersion)
			{
				if (ModName == "SKC Core")
				{
					setMessageCore(Message.getOverMsg(ModName, ModVersion));
				}
				if (ModName == "Craftable Horse Armor")
				{
					setMessageCHA(Message.getOverMsg(ModName, ModVersion));
				}
				if (ModName == "Better Wood")
				{
					setMessageBW(Message.getOverMsg(ModName, ModVersion));
				}
				
				LogHelper.info("SKC Version Checker", "You are using a version of " + ModName + " (" + ModVersion + ") which has not been released yet");
			}
			
			else
			{
				if (ModName == "SKC Core")
				{
					setMessageCore(Message.getErrorMsg(ModName));
				}
				if (ModName == "Craftable Horse Armor")
				{
					setMessageCHA(Message.getErrorMsg(ModName));
				}
				if (ModName == "Better Wood")
				{
					setMessageBW(Message.getErrorMsg(ModName));
				}
				
				LogHelper.warning("SKC Version Checker", "Could not check version of " + ModName + "!");
			}
		}
		
		catch (Exception e)
		{
			if (ModName == "SKC Core")
			{
				setMessageCore(Message.getErrorMsg(ModName));
			}
			if (ModName == "Craftable Horse Armor")
			{
				setMessageCHA(Message.getErrorMsg(ModName));
			}
			if (ModName == "Better Wood")
			{
				setMessageBW(Message.getErrorMsg(ModName));
			}
			
			LogHelper.warning("SKC Version Checker", "Could not check version of " + ModName + "!");
		}
    }
    
	private static void setMessageCore(String par1)
	{
    	MessageCore = par1;
    }
    
    private static void setMessageCHA(String par1)
    {
    	MessageCHA = par1;
	}
    
    private static void setMessageBW(String par1)
    {
    	MessageBW = par1;
	}
    
    public static String getMessageCore()
    {
    	return MessageCore;
    }
    
    public static String getMessageCHA()
    {
    	return MessageCHA;
    }
    
    public static String getMessageBW()
    {
    	return MessageBW;
    }
    
	public static class Message
	{
		private static final EnumChatFormatting reset = EnumChatFormatting.RESET;
		private static final EnumChatFormatting italic = EnumChatFormatting.ITALIC;
		private static final EnumChatFormatting d_red = EnumChatFormatting.DARK_RED;
		private static final EnumChatFormatting red = EnumChatFormatting.RED;
		private static final EnumChatFormatting green = EnumChatFormatting.GREEN;
		private static final EnumChatFormatting blue = EnumChatFormatting.BLUE;
		
		private static final String preErrorMsg = StatCollector.translateToLocal("message.version.error");
		private static final String preOutMsg = StatCollector.translateToLocal("message.version.outdated");
		private static final String preOkMsg = StatCollector.translateToLocal("message.version.updated");
		private static final String preOverMsg = StatCollector.translateToLocal("message.version.over");
		
		private static String getErrorMsg(String ModName)
		{
			return d_red + String.format(preErrorMsg, ModName).replace(" ", " " + d_red);
		}
		
		private static String getOutMsg(String ModName, String ModVersion, String ThreadUrl, String LatestVersion)
		{
			return red + String.format(preOutMsg, ModName, ModVersion, ThreadUrl, LatestVersion).replace(" ", " " + red).replace("http", reset + "" + italic + "http");
		}
		
		private static String getOkMsg(String ModName, String ModVersion)
		{
			return green + String.format(preOkMsg, ModName, ModVersion).replace(" ", " " + green);
		}
		
		private static String getOverMsg(String ModName, String ModVersion)
		{
			return blue + String.format(preOverMsg, ModName, ModVersion).replace(" ", " " + blue);
		}
	}
}