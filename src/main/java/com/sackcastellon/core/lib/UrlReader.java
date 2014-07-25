/**
 * SKC-Core Mod
 * Copyright © 2013-2014 SackCastellon
 * This modification and his resources are licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 Unported License.
 * 
 * 		http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package com.sackcastellon.core.lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlReader {

	public static String toString(String string) {
		
		URL url;
        BufferedReader in;
        String Result = "";
        
		try {
			url = new URL(string);
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			Result = in.readLine();
			in.close();
		} catch (Exception e) {}
        
		return Result;
		
	}
	
	public static String toString(URL url) {
		
        BufferedReader in;
        String Result = "";
        
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			Result = in.readLine();
			in.close();
		} catch (Exception e) {}
        
		return Result;
		
	}
}