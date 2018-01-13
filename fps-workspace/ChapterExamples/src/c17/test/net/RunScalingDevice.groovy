package c17.test.net

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel
import jcsp.lang.*
import groovyJCSP.*
import jcsp.net.*
import jcsp.net.tcpip.*

def testPartIP = "127.0.0.1"  
def deviceIP = "127.0.0.2"
def testPartAddr = new TCPIPNodeAddress(testPartIP, 3000)
def deviceAddr = new TCPIPNodeAddress(deviceIP, 3000)
Node.getInstance().init(deviceAddr)

def ordinaryInput = NetChannel.net2one()
println "ordinaryInput location = ${ordinaryInput.getLocation()}"
ordinaryInput.read()
def scaledOutput = NetChannel.one2net(testPartAddr, 51)
println "scaledOutput location = ${scaledOutput.getLocation()}"

new PAR(new ScalingDevice (inChannel: ordinaryInput, outChannel: scaledOutput) ).run()
 