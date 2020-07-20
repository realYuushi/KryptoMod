package com.tyman.DetonatorMod.events;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class OnServerJoin {
    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity != null && event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
        	String updateStatus = ForgeVersion.getResult(Loader.instance().activeModContainer()).status.toString();
        	if (updateStatus == "OUTDATED") {
        		Minecraft.getMinecraft().thePlayer.sendChatMessage(EnumChatFormatting.BLACK + "---------------------------");
        		Minecraft.getMinecraft().thePlayer.sendChatMessage(EnumChatFormatting.RED + "A new version of DetonatorMod is availible! Go to DetonatorMod in the mod options to update!");
        		Minecraft.getMinecraft().thePlayer.sendChatMessage(EnumChatFormatting.BLACK + "---------------------------");
        	}
        }
    }
    
}
