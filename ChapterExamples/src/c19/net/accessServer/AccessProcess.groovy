package c19.net.accessServer

import jcsp.lang.*
import jcsp.util.*
import groovyJCSP.*
import jcsp.net.*



class AccessProcess implements CSProcess, Serializable {

	def NetChannelLocation processReceiveLocation
	def NetChannelLocation accessRequestLocation
	
	void run (){
		def buttonChannel = Channel.one2one(new OverWriteOldestBuffer(5))
		new PAR ([new AccessInterface( buttonEvents: buttonChannel.out()),
			        new AccessCapability( buttonEvents: buttonChannel.in(),
								                    processReceiveLocation: processReceiveLocation,
																		accessRequestLocation:accessRequestLocation)]).run()
	}
}
