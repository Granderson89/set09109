package c2

import jcsp.lang.*

class ListToStream implements CSProcess{
	
	def ChannelInput inChannel
	def ChannelOutput outChannel
	
	void run (){
		def inList = inChannel.read()
		while (inList[0] != -1) {
			// hint: output	list elements as single integers
			outChannel.write(inList[0])
			outChannel.write(inList[1])
			outChannel.write(inList[2])
			inList = inChannel.read()
		}
		outChannel.write(-1)
	}
}