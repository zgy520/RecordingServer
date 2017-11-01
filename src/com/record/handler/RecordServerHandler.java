package com.record.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.record.record2.model.GPS;
import com.zgy.data.MongodbUtil;
import com.zgy.model.mobile.GPSMessage;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class RecordServerHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(RecordServerHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg) {
		GPSMessage gps = (GPSMessage)msg;
		//logger.info(gps.toString());
		ReferenceCountUtil.release(msg);
		logger.info(gps.toString());
		MongodbUtil.insertDocument(gps);
		ctx.write(Unpooled.copiedBuffer("接受到了消息",CharsetUtil.UTF_8));
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx){
		ctx.flush();
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx){
		System.out.println(ctx.channel().remoteAddress()+"通道建立了");
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx){
		System.out.println("通道"+ctx.channel().remoteAddress()+"断开了");
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
		System.out.println("exceptionCaught");
		cause.printStackTrace();
		ctx.close();
	}
}
