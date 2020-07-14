package com.tyman.DetonatorMod.utils;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class FetchDataThread implements Runnable {
	static ICommandSender iCommandSender = null;
	static String[] strings;
	public void run(){  
		iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[DetonatorMod] Fetching data for user " + strings[0] + "..."));
        String response = HttpRequest.get("https://detonatorapi.glitch.me/?name="+strings[0]).body();
        iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + response)); 
	}
	public static void main(ICommandSender iiCommandSender, String[] stringss){
		iCommandSender = iiCommandSender;
		strings = stringss;
	    FetchDataThread obj=new FetchDataThread();  
	    Thread tobj =new Thread(obj);  
	    tobj.start();
	} 
}
