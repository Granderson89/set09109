package c15.net

import jcsp.lang.*
import groovyJCSP.*
import jcsp.net.*
import jcsp.net.tcpip.*
import phw.util.*


def v= Ask.Int ("Sender identity number 2-9 ? ", 2, 9)

def senderNodeIPbase = "127.0.0."
def senderNodeIP = senderNodeIPbase + v
def senderNode = new TCPIPNodeAddress(senderNodeIP, 3000)
Node.getInstance().init (senderNode)

def receiverNodeIP = "127.0.0.1"
def receiverNode = new TCPIPNodeAddress(receiverNodeIP, 3000)

def comms = NetChannel.any2net(receiverNode, 100)
def pList = [ new Sender ( outChannel: comms, id: v ) ]

new PAR ( pList ).run()
