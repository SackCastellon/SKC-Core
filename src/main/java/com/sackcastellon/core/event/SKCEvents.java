/**
 * SKC-Core Mod
 * Copyright © 2013-2014 SackCastellon
 * This modification and his resources are licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 Unported License.
 * 
 * 		http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package com.sackcastellon.core.event;

import java.util.Iterator;

import com.sackcastellon.core.helper.VersionHelper;

import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class SKCEvents {
	
    @SubscribeEvent
    public void onPlayerLogin(PlayerLoggedInEvent event) {
    	
    	Iterator<String> iterator = VersionHelper.ModsChecked.iterator();
    	while(iterator.hasNext())
    	{
    		event.player.addChatMessage(new ChatComponentText(iterator.next()));
    		event.player.addChatMessage(new ChatComponentText(""));
    	}
    	
    	/*    	
    	// Version Check Message    	
    	event.player.addChatMessage(new ChatComponentText(VersionHelper.getMessageCore()));
    	
    	if(VersionHelper.getMessageCHA() != null)
    	{
        	event.player.addChatMessage(new ChatComponentText(""));
        	event.player.addChatMessage(new ChatComponentText(VersionHelper.getMessageCHA()));
    	}
    	
    	if(VersionHelper.getMessageBW() != null)
    	{
        	event.player.addChatMessage(new ChatComponentText(""));
        	event.player.addChatMessage(new ChatComponentText(VersionHelper.getMessageBW()));
    	}
    	
    	if(VersionHelper.getMessagePixel() != null)
    	{
        	event.player.addChatMessage(new ChatComponentText(""));
        	event.player.addChatMessage(new ChatComponentText(VersionHelper.getMessagePixel()));
    	}
    	
    	if(VersionHelper.getMessageSS() != null)
    	{
        	event.player.addChatMessage(new ChatComponentText(""));
        	event.player.addChatMessage(new ChatComponentText(VersionHelper.getMessageSS()));
    	}
    	
    	if(VersionHelper.getMessageSW() != null)
    	{
        	event.player.addChatMessage(new ChatComponentText(""));
        	event.player.addChatMessage(new ChatComponentText(VersionHelper.getMessageSW()));
    	}
    	
    	*/
    }
}