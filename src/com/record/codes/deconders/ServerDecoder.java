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
		//�����ϢͷΪ�գ���in,reabableBytes < 12,��˵���������Խ�����Ϣͷ����Ҫ�ȴ�
		if(msgHeader ==null && in.readableBytes() < 12){
			return;
		}
		
		if(msgHeader==null){ //˵����Ϣͷ��û�б�����
			boolean waiting = decodeHeader(in); //������Ϣͷ
			if(!waiting){  //��ʱ˵���������ܽ�����Ϣͷ
				return;
			}
		}else if(in.readableBytes() < LEN_BODY){
			return;
		}
		decodeBody(in);  //ִ�е��ˣ�˵�����㹻�Ļ����������������Ϣ��
		msgHeader = null; //����Ϣ����Ϊ��
		out.add(msgBody);
		
	}
	/**
	 * ������Ϣͷ
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
		LEN_BODY = headerIn.readInt() - LEN_MESSAGEHEADER;  //��Ϣ��ĳ��ȣ�����Ϣ���ܳ��ȼ�ȥ��Ϣͷ�ĳ���
		msgHeader.setMessageSequence(headerIn.readShort());
		msgHeader.setMessageVersion(headerIn.readShort());
		if(LEN_BODY > headerIn.readableBytes()){ //��ǰ�ɶ�bytebuf�Ļ���С����Ϣ��Ĵ�С��������ȴ���Ϣ�ĵ���
			return false;
		}
		return true;
	}
	
	private static final int LEN_MESSAGEHEADER = 12;  //������Ϣͷ�ĳ���
	private int LEN_BODY;  //��Ϣͷ�ĳ���

}
