package com.record.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class GpsHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg) {
		ByteBuf in = (ByteBuf)msg;
		System.out.println(in.toString(CharsetUtil.UTF_8));
		//ctx.writeAndFlush((ByteBuf)msg);
		//System.out.println("channelId="+ctx.channel().id());
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}