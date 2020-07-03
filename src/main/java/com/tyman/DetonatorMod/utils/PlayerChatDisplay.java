package com.tyman.DetonatorMod.utils;

import com.tyman.DetonatorMod.utils.models.Profile;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PlayerChatDisplay {

    ICommandSender sender;
    Profile profile;

    public PlayerChatDisplay(ICommandSender sender, Profile profile) {
        this.sender = sender;
        this.profile = profile;
    }

    public void displayStats() {

        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + EnumChatFormatting.BOLD + "General stats of " + EnumChatFormatting.AQUA + profile.getUsername()));

    }}

}
