package c20.net
// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel
import jcsp.lang.*
import jcsp.net.*
import jcsp.net.tcpip.*
import groovyJCSP.*
import phw.util.*
// must be run after the other elements have been run
def rootIP = "127.0.0.1"
def rootAddress = new TCPIPNodeAddress(rootIP, 3000)
Node.getInstance().init(rootAddress)
def fromRing = NetChannel.net2one()

def nextNodeIP = "127.0.0.2"
def nextNodeAddress = new TCPIPNodeAddress(nextNodeIP, 3000)
def toRing = NetChannel.one2net(nextNodeAddress, 50)

toRing.write(0)
fromRing.read()

def processNode = new AgentExtraElement ( fromRing: fromRing,
                                           toRing: toRing )

new PAR ([ processNode]).run()
