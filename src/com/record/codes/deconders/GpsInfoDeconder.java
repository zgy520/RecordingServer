package com.record.codes.deconders;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class GpsInfoDeconder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext arg0, ByteBuf in, List<Object> arg2) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("start parse GPS data from client");
		if(in.readableBytes() > 4){
			arg2.add(String.valueOf(in.readInt()));
		}
	}

}
