package com.tyman.DetonatorMod.utils;

import java.util.List;

import io.github.reflxction.hypixelapi.guild.GuildMember;

public class FindMember {
	public static GuildMember findMember(String uuid, List<GuildMember> list) {
	    for(GuildMember member : list) {
	        if(member.getUUID().equals(uuid)) {
	            return member;
	        }
	    }
	    return null;
	}
}
