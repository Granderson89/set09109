package c19.net.UniversalClient

import jcsp.lang.*
import jcsp.net.*;
import jcsp.net.tcpip.*
import groovyJCSP.*
import jcsp.util.*


def ipChannel = Channel.one2one(new OverWriteOldestBuffer(5))

new PAR([ new UCInterface(sendNodeIdentity: ipChannel.out()), 
				  new UCCapability(receiveNodeIdentity: ipChannel.in() )]).run()
					
	