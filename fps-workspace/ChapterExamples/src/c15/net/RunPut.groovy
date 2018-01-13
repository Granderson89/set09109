package c15.net

import jcsp.lang.*
import groovyJCSP.*
import jcsp.net.*
import jcsp.net.tcpip.*
import jcsp.net.mobile.*;
import phw.util.*

def putNodeIP = "127.0.0.1"
def getNodeIP = "127.0.0.2"

def nodeAddr = new TCPIPNodeAddress(putNodeIP,3000)
Node.getInstance().init (nodeAddr)

def getNode = new TCPIPNodeAddress(getNodeIP, 3000)
def comms = NetChannel.one2net(getNode, 50)

def pList = [ new Put ( outChannel: comms ) ]

new PAR ( pList ).run()
