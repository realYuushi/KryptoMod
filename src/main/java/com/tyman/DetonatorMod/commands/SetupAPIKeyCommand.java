package com.tyman.DetonatorMod.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.tyman.DetonatorMod.DetonatorMod;

public class SetupAPIKeyCommand extends CommandBase{

    DetonatorMod skyblockStatistics;

    public SetupAPIKeyCommand(DetonatorMod skyblockStatistics) {
        this.skyblockStatistics = skyblockStatistics;
    }

    @Override
    public String getCommandName() {
        return "setkey";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/setkey <API Key>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {

        if(strings.length < 1 || strings.length > 1) {
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[SkyblockStats] Please use /setkey <API Key>"));
        } else {
            String key = strings[0];
            String apiFilePath = Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/sbapikey.config";

            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new FileWriter(apiFilePath));
                out.write(key);
                out.close();
                skyblockStatistics.setApiKey(key);
                iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[SkyblockStats] API Key successfully set"));
            } catch (IOException e) {
                iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[SkyblockStats] Something went wrong while saving your API key"));
            }
        }

    }
}
