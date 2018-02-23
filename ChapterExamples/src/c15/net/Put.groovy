package c15.net

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel


import jcsp.lang.*
import groovyJCSP.*

class Put implements CSProcess { 
	 
  def ChannelOutput outChannel  
  
  void run() {
    def i = 1
    while (true) {
      outChannel.write ( i )
      i = i + 1
    }
  }
}

      
  
