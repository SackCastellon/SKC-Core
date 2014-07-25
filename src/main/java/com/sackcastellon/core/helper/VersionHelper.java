package com.sackcastellon.core.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;

public class VersionHelper
{
	public static ArrayList<String> ModsChecked = new ArrayList<String>();
	
	private static Status State;
	
	private final static String Checker = "SKC Version Checker";
	
	/**
	 * @param checkparams
	 * <br>
	 * 0 - ID<br>
	 * 1 - NAME<br>
	 * 2 - VERSION<br>
	 * 3 - URL
	 */
	public static void check(String[] checkparams)
	{
		State = null;
		String LatestVersion = null;
		int[] LatestVersionSplit = new int[4];
		int[] ActualVersionSplit = new int[4];
		
		try
		{
			URL url = new URL("https://dl.dropboxusercontent.com/u/184200482/Minecraft/Mods/" + checkparams[0].substring(4) + "/Versions/" + MinecraftForge.MC_VERSION + ".version");
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        LatestVersion = in.readLine();
	        in.close();
		}
		
		catch (Exception e)
		{
			LogHelper.warning(Checker, "Could not check version of " + checkparams[1] + "!");
			LatestVersion = "0.0.0.0";
		}
		
		finally
		{
			String[] s1 = LatestVersion.split("\\.");
			String[] s2 = checkparams[2].split("\\.");
			
			for(int i = 0; i < 4; ++i)
			{
				LatestVersionSplit[i] = Integer.parseInt(s1[i]);
				ActualVersionSplit[i] = Integer.parseInt(s2[i]);
			}
			
			State = compareVersions(LatestVersionSplit, ActualVersionSplit);
			
			createMessages(checkparams, State, LatestVersion);
		}
	}
	
	private static Status compareVersions(int[] latest, int[] actual)
	{
		if(latest[0] == 0 && latest[1] == 0 && latest[2] == 0 && latest[3] == 0)
		{
			return Status.ERRORED;
		}
		
		else if(latest[0] == actual[0] && latest[1] == actual[1] && latest[2] == actual[2] && latest[3] == actual[3])
		{
			return Status.UPDATED;
		}
		
		else
		{
			return Status.OUTDATED;
		}
	}
	
	private static void createMessages(String[] str, Status state, String latestVersion)
	{
		switch(state)
		{
		case ERRORED:
			ModsChecked.add(String.format(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("message.version.error"), str[1]).replace(" ", " " + EnumChatFormatting.DARK_RED));
			break;
		case OUTDATED:
			ModsChecked.add(String.format(EnumChatFormatting.RED + StatCollector.translateToLocal("message.version.outdated"), str[1], str[2], str[3], latestVersion).replace(" ", " " + EnumChatFormatting.RED).replace("http", EnumChatFormatting.RESET + "http"));
			break;
		case UPDATED:
			ModsChecked.add(String.format(EnumChatFormatting.GREEN + StatCollector.translateToLocal("message.version.updated"), str[1], str[2]).replace(" ", " " + EnumChatFormatting.GREEN));
			break;
		default:
			break;
		}
	}
	
	public enum Status
	{
	//	CHECKING,
	//	CHECKED,
		UPDATED,
		OUTDATED,
		ERRORED;
	}
}