package com.tyman.DetonatorMod.utils;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class FetchPlayerDataThread implements Runnable {
	static ICommandSender iCommandSender = null;
	static String[] strings;
	public void run(){  
		iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[DetonatorMod] Fetching data for user " + strings[0] + "..."));
        String response = HttpRequest.get("https://detonatorapi.glitch.me/?name="+strings[0]).body();
        if (response.contains("Error")) {
        	iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[DetonatorMod]" + response));
        }
        else {
        	iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[DetonatorMod]" + response));
        }
	}
	public static void main(ICommandSender iiCommandSender, String[] stringss){
		iCommandSender = iiCommandSender;
		strings = stringss;
	    FetchPlayerDataThread obj=new FetchPlayerDataThread();  
	    Thread tobj =new Thread(obj);  
	    tobj.start();
	} 
}
