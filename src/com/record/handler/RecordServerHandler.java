package com.record.handler;

import com.app.record.record2.model.GPS;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class RecordServerHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg) {
		GPS gps = (GPS)msg;
		System.out.println("��ȡ����ά��Ϊ:"+gps.getLatitude());
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx){
		System.out.println("ͨ��������");
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
		System.out.println("exceptionCaught");
		cause.printStackTrace();
		ctx.close();
	}
}
