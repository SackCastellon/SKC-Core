package SackCastellon.core.handler;

import SackCastellon.core.event.SkcEvent;
import SackCastellon.core.helper.LogHelper;
import SackCastellon.core.reference.Reference;
import net.minecraftforge.common.MinecraftForge;

public class SkcEventHandler {

    public static void init(){
    	
        MinecraftForge.EVENT_BUS.register(new SkcEvent());
        
        LogHelper.info(Reference.ID, "Event Handler Initialized");
        
    }
}
