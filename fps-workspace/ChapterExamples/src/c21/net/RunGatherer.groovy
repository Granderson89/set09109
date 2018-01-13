package c21.net
 
   
import jcsp.lang.*
import jcsp.net.*
import jcsp.net.tcpip.*
import groovyJCSP.*


def nodeIP = "127.0.0.2"
def nodeAddress = new TCPIPNodeAddress(nodeIP, 3000)
Node.getInstance().init(nodeAddress)
def fromNodesToGatherer = NetChannel.net2one() // cn 50

println "Gatherer Starting"
def processList = new Gatherer ( fromNodes: fromNodesToGatherer )

new PAR ([ processList]).run()
