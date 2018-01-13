package c19.net.accessServer

import jcsp.lang.*
import jcsp.net.*
import c19.net.netObjects.*




class AccessCapability implements CSProcess {

	def ChannelInput buttonEvents
	def NetChannelLocation processReceiveLocation
	def NetChannelLocation accessRequestLocation
	
	void run (){
		def serviceRequired = buttonEvents.read()
		def clientRequest  = new ClientRequestData(processReceiveLocation: processReceiveLocation,
																							 serviceRequired: serviceRequired)
		def toAccess = NetChannel.any2net(accessRequestLocation)
		toAccess.write(clientRequest)
	}
}
