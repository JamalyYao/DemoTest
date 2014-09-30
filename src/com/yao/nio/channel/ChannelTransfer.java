package com.yao.nio.channel;

import java.io.FileInputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Test channel transfer. This is a very simplistic concatenation program. It
 * takes a list of file names as arguments, opens each in turn and transfers
 * (copies) their content to the given WritableByteChannel (in this case,
 * stdout).
 * 
 * 使用通道传输进行文件连结
 * 
 */
public class ChannelTransfer {
	public static void main(String[] argv) throws Exception {
		/*if (argv.length == 0) {
			System.err.println("Usage: filename ...");
			return;
		}*/
		String[] files = {"files/test_channel.txt"};
		catFiles(Channels.newChannel(System.out), files);
		//catFiles(Channels.newChannel(System.out), argv);
	}

	// Concatenate the content of each of the named files to
	// the given channel. A very dumb version of 'cat'.
	private static void catFiles(WritableByteChannel target, String[] files) throws Exception {
		for (int i = 0; i < files.length; i++) {
			FileInputStream fis = new FileInputStream(files[i]);
			FileChannel channel = fis.getChannel();
			channel.transferTo(0, channel.size(), target);
			channel.close();
			fis.close();
		}
	}
}
