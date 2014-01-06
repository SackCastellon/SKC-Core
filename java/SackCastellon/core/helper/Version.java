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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Version {
	
	private static String VersionUrl = "https://dl.dropboxusercontent.com/u/184200482/Minecraft/Mods/";

    public static void check(String ID, String Version, String Url){        

    	String ModName = ID.substring(4);

		try {
			
			URL url = new URL(VersionUrl + ModName + "/Versions/1.7.2.version");
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        String Result = in.readLine();
	        in.close();
	        
	        int newVersion = Integer.parseInt(Result.substring(6));
	        int oldVersion = Integer.parseInt(Version.substring(6));

			if (oldVersion < newVersion) {
				
				LogHelper.severe("SKC Version Checker", "[" + ID + "] " + ModName + " (" + Version + ") is out of date! Please visit " + Url + " to get the latest version (" + Result +")");
				
			} else if (oldVersion == newVersion) {
				
				LogHelper.info("SKC Version Checker", "[" + ID + "] You are using the latest version of " + ModName + " (" + Version + ") so you don't need to updated it");
				
			} else {
				
				LogHelper.warning("SKC Version Checker", "[" + ID + "] Could not check the version of " + ModName + "!");
				
			}
	        
		} catch (Exception e) {
			
			LogHelper.warning("SKC Version Checker", "[" + ID + "] Could not check the version of " + ModName + "!");

		}

    }
    
}
