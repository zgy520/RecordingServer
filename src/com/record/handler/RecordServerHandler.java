package com.record.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zgy.data.MongodbUtil;
import com.zgy.model.business.gps.Z_GPS;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class RecordServerHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(RecordServerHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg) {
		Z_GPS gps = (Z_GPS)msg;
		//logger.info(gps.toString());
		ReferenceCountUtil.release(msg);
		logger.info(gps.toString());
		MongodbUtil.insertDocument(gps);
		
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx){
		
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx){
		System.out.println("通道建立了");
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx){
		System.out.println("通道"+ctx.channel().id()+"断开了");
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
		System.out.println("exceptionCaught");
		cause.printStackTrace();
		ctx.close();
	}
}
