package com.tyman.DetonatorMod.utils;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PlayerChatDisplay {

    ICommandSender sender;

    public PlayerChatDisplay(ICommandSender sender) {
        this.sender = sender;
    }

    public void displayStats() {

        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + EnumChatFormatting.BOLD + "General stats of " + EnumChatFormatting.AQUA + profile.getUsername()));

    }}

}
