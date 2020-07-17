package com.tyman.DetonatorMod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import com.tyman.DetonatorMod.DetonatorMod;
import com.tyman.DetonatorMod.utils.FetchRankUpdatesThread;

public class RankUpdatesCommand extends CommandBase {

    DetonatorMod detonatormod;

    public RankUpdatesCommand(DetonatorMod detonatormod) {
        this.detonatormod = detonatormod;
    }

    @Override
    public String getCommandName() {
        return "dstatsall";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "dstatsall";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }


    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if(strings.length > 1) {
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[DetonatorMod] Usage is /dstatsall"));
            return;
        } else {
           //execute user fetching procedure
        	FetchRankUpdatesThread.main(iCommandSender);
        }
    }


}