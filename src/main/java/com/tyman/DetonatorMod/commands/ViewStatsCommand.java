package com.tyman.DetonatorMod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.Collections;
import java.util.List;

import com.tyman.DetonatorMod.DetonatorMod;
import com.tyman.DetonatorMod.utils.PlayerFetcherThread;

public class ViewStatsCommand extends CommandBase {

    DetonatorMod skyblockStatistics;

    public ViewStatsCommand(DetonatorMod skyblockStatistics) {
        this.skyblockStatistics = skyblockStatistics;
    }

    @Override
    public String getCommandName() {
        return "sbstats";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "sbstats <username>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }


    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {

        //api key check
        if(skyblockStatistics.getApiKey().isEmpty()) {
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[SkyblockStats] Setup your API Key with /setkey <API Key> first"));
            return;
        }
        if(strings.length < 1 || strings.length > 1) {
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[SkyblockStats] Usage is /sbstats <username>"));
            return;
        } else {
           //execute user fetching procedure
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[SkyblockStats] Fetching data for user " + strings[0] + "..."));
            Thread thread = new Thread(new PlayerFetcherThread(iCommandSender, strings[0], skyblockStatistics));
            thread.start();
        }
    }


}
