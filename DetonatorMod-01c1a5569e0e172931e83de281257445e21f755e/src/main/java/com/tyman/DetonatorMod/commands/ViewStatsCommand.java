package com.tyman.DetonatorMod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import com.tyman.DetonatorMod.DetonatorMod;
import com.tyman.DetonatorMod.utils.FetchDataThread;

public class ViewStatsCommand extends CommandBase {

    DetonatorMod detonatormod;

    public ViewStatsCommand(DetonatorMod detonatormod) {
        this.detonatormod = detonatormod;
    }

    @Override
    public String getCommandName() {
        return "dstats";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "dstats <username>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }


    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if(strings.length < 1 || strings.length > 1) {
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[DetonatorMod] Usage is /dstats <username>"));
            return;
        } else {
           //execute user fetching procedure
        	FetchDataThread.main(iCommandSender, strings);
        }
    }


}
