package SackCastellon.core.handler;

import SackCastellon.core.reference.Reference;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ChatMessageHandler {

    private static final IChatComponent SkcChatComponent = createSckChatComponent(Reference.ID.toUpperCase());

    public static void iCommandSenderReply(ICommandSender player, String message) {
        sendChatToPlayer((EntityPlayer)player, message);
    }

    private static IChatComponent createSckChatComponent(String string) {
        ChatComponentText Component = new ChatComponentText(string);
          return Component;
    }

    public static IChatComponent createChatComponent(String message) {
        ChatComponentText component = new ChatComponentText(message);
        return SkcChatComponent.func_150257_a(component);
    }

    public static void sendChatToPlayer(EntityPlayer player, String message) {
        player.func_146105_b(createChatComponent(message));
    }

    public static void broadcastMessageToPlayers(String message){
        MinecraftServer.getServer().getConfigurationManager().func_148539_a(createChatComponent(message));
    }
}