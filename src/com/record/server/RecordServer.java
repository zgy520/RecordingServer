package com.record.server;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;

import com.record.handler.RecordServerHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class RecordServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new RecordServer().start();
	}
	
	public void start() throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(group)
					 .channel(NioServerSocketChannel.class)
					 .localAddress(new InetSocketAddress(port))
					 .childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// TODO Auto-generated method stub
							ch.pipeline().addLast(new RecordServerHandler());
						}
					});
			ChannelFuture future = bootstrap.bind().sync();
			future.channel().closeFuture().sync();
		} finally {
			// TODO: handle finally clause
			group.shutdownGracefully();
		}
	}

	private final static int port = 8089;  //ÉèÖÃ¼àÌýµÄ¶Ë¿ÚºÅ
}
