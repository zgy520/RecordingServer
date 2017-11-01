package com.record.codes.deconders;

import com.zgy.model.MessageBody;
import com.zgy.model.mobile.GPSMessage;

import io.netty.buffer.ByteBuf;

public class GpsInfoDeconder {

	public static MessageBody decode(ByteBuf in)throws Exception {
		///System.out.println("还剩余的字节数为:"+in.readableBytes());
		MessageBody z_GPS = new GPSMessage(in.readDouble(), in.readDouble(), in.readFloat(), 
				in.readDouble(), in.readFloat(), in.readFloat(), in.readInt(), 
				in.readByte(),in.readLong());
		return z_GPS;
	}
}
