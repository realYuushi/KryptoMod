package com.tyman.KryptoMod.events;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class OnServerJoin {
    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
    	Logger log = LogManager.getLogger(Loader.instance().activeModContainer().getModId());
    	log.info("Entify Joined world!");
    	log.info(event.entity instanceof EntityPlayer);
    	log.info(event.entity != null);
        if (event.entity != null && event.entity instanceof EntityPlayer) {
        	String updateStatus = ForgeVersion.getResult(Loader.instance().activeModContainer()).status.toString();
        	if (updateStatus == "OUTDATED") {
        		Minecraft.getMinecraft().thePlayer.sendChatMessage(EnumChatFormatting.BLACK + "---------------------------");
        		Minecraft.getMinecraft().thePlayer.sendChatMessage(EnumChatFormatting.RED + "A new version of KryptoMod is availible! Go to KryptoMod in the mod options to update!");
        		Minecraft.getMinecraft().thePlayer.sendChatMessage(EnumChatFormatting.BLACK + "---------------------------");
        	}
        }
    }
    
}
