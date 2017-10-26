package com.record.codes.deconders;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import com.zgy.model.MessageBody;
import com.zgy.model.MessageCommand;
import com.zgy.model.MessageHeader;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class ServerDecoder extends ByteToMessageDecoder {

	private MessageHeader msgHeader;
	public MessageBody msgBody;
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(in.readerIndex());
		//如果消息头为空，且in,reabableBytes < 12,则说明还不足以解析消息头，需要等待
		if(msgHeader ==null && in.readableBytes() < 12){
			return;
		}
		
		if(msgHeader==null){ //说明消息头还没有被解析
			boolean waiting = decodeHeader(in); //解析消息头
			if(!waiting){  //此时说明，还不能解析消息头
				return;
			}
		}else if(in.readableBytes() < LEN_BODY){
			return;
		}
		decodeBody(in);  //执行到此，说明有足够的缓冲可以用来解析消息体
		msgHeader = null; //将消息体置为空
		out.add(msgBody);
		
	}
	/**
	 * 解析消息头
	 * @param in
	 * @return
	 */
	private void decodeBody(ByteBuf in)throws Exception{
		if (msgHeader.getMessageType() == MessageCommand.MESSAGETYPE_GPS) {
			msgBody = GpsInfoDeconder.decode(in);
		}
	}
	
	private boolean decodeHeader(ByteBuf headerIn) {
		msgHeader = new MessageHeader(headerIn.readInt());
		LEN_BODY = headerIn.readInt() - LEN_MESSAGEHEADER;  //消息体的长度：由消息的总长度减去消息头的长度
		msgHeader.setMessageSequence(headerIn.readShort());
		msgHeader.setMessageVersion(headerIn.readShort());
		if(LEN_BODY > headerIn.readableBytes()){ //当前可读bytebuf的缓冲小于消息体的大小，则继续等待消息的到来
			return false;
		}
		return true;
	}
	
	private static final int LEN_MESSAGEHEADER = 12;  //定义消息头的长度
	private int LEN_BODY;  //消息头的长度

}
