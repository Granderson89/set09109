package c2

import jcsp.lang.*

class CreateSetsOfEight implements CSProcess{
	
	def ChannelInput inChannel
	def int size
	def String message = ""

	void run(){
		def outList = []
		def v = inChannel.read()
		while (v != -1){
			// clear outList
			outList = []
			for ( i in 0 .. size - 1 ) {
				// put v into outList and read next input
				outList.add(v)
				v = inChannel.read()
			}
			message += " Eight Object is ${outList}\n"
			 
			
		}
		message += "Finished"
	}
}