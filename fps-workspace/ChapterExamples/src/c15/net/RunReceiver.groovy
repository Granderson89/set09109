package c15.net

import jcsp.lang.*
import groovyJCSP.*
import jcsp.net.*
import jcsp.net.tcpip.*
import phw.util.*


def receiverNodeIP = "127.0.0.1"
def receiverNode = new TCPIPNodeAddress(receiverNodeIP, 3000)
Node.getInstance().init (receiverNode)

def comms = NetChannel.numberedNet2One(100)
def pList = [ new Receiver ( inChannel: comms ) ]

new PAR ( pList ).run()
