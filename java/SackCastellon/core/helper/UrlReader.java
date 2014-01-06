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