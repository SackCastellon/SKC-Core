package SackCastellon.core.event;

import SackCastellon.core.handler.ChatMessageHandler;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerLoginEvent {
	
    public static void playerLogin(EntityPlayer player) {
    	
    	ChatMessageHandler.broadcastMessageToPlayers(player.getDisplayName()+ " is testing chat messages");

    }
}