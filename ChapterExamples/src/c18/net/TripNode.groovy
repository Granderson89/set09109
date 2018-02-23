package c18.net

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel

import jcsp.lang.*
import jcsp.net.*


class TripNode implements CSProcess{
  
  def ChannelOutput toRoot
  def int nodeId
  

  void run() {
    def  N2A = Channel.one2one()
    def  A2N = Channel.one2one()  
    def ChannelInput toAgentInEnd = N2A.in()
    def ChannelInput fromAgentInEnd = A2N.in()
    def ChannelOutput toAgentOutEnd = N2A.out()
    def ChannelOutput fromAgentOutEnd = A2N.out()
    
    def agentInputChannel = NetChannel.net2one()
    toRoot.write ( agentInputChannel.getLocation())
    def theAgent = agentInputChannel.read()
    theAgent.connect ( [fromAgentOutEnd, toAgentInEnd] )
    def agentManager = new ProcessManager (theAgent)
    agentManager.start()
    def currentList = fromAgentInEnd.read()
    currentList << nodeId
    toAgentOutEnd.write (currentList)
    agentManager.join()
  }
}
