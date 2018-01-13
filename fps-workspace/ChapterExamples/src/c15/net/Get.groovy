package c15.net

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel


import jcsp.lang.*
import groovyJCSP.*

class Get implements CSProcess { 
	 
  def ChannelInput inChannel
  def int id = 0  
  
  void run() {
    def timer = new CSTimer()
    while (true) {
      def v = inChannel.read()
      println "$id .. $v"
      timer.sleep(200 * v)
    }
  }
}

