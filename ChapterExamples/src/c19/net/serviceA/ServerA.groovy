package c19.net.serviceA

import jcsp.lang.*
import jcsp.net.*;
import jcsp.net.tcpip.*
import groovyJCSP.*
import netObjects.*
def serverIP = "127.0.0.1"
// each service is located at a different port 	
def AServerAddress = new TCPIPNodeAddress(serverIP, 4567)
Node.getInstance().init(AServerAddress)
def initialChannel = NetChannel.numberedNet2One(1)
while (true) {
	def request = initialChannel.read()
	def processSendChannel =NetChannel.one2net(request.processReceiveLocation)
	def aProcess = new Aprocess()
	processSendChannel.write(aProcess)		
}
