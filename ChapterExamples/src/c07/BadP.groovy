package c07

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel


import jcsp.lang.*
import groovyJCSP.*

class BadP implements CSProcess {
	
  def ChannelInput inChannel
  def ChannelOutput outChannel  
  
  def void run() {
    println "BadP: Starting"
	
    while (true) {
      println "BadP: outputting"
      outChannel.write(1)
      println "BadP: inputting"
      def i = inChannel.read()
      println "BadP: looping"
    }
  }
}

      