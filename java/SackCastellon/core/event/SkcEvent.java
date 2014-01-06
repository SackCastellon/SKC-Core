package SackCastellon.core.event;

import SackCastellon.core.helper.LogHelper;
import SackCastellon.core.reference.Reference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class SkcEvent {
	
    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    	
        PlayerLoginEvent.playerLogin(event.player);
        
        LogHelper.info(Reference.ID, event.player.getDisplayName() + " logged In!");
        
    }

}
