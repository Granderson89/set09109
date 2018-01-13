package c10

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel


import jcsp.lang.*
import groovyJCSP.*

class Receiver implements CSProcess {
	
  def ChannelInput fromElement
  def ChannelOutput outChannel
  def int element
  
  void run() {
    while (true) {
      def packet = fromElement.read()
      outChannel.write ("Received: " + packet.toString() + "\n")
    }
  }
}

