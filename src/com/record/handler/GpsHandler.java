package com.record.handler;

import com.zgy.model.business.gps.Z_GPS;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class GpsHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg) {
		Z_GPS z_GPS = (Z_GPS)msg;
		System.out.println("读取到了数据："+z_GPS.toString());
		ReferenceCountUtil.release(msg);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
