package c10

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel


import jcsp.lang.*
import groovyJCSP.*

class ExtraElementv2 implements CSProcess { 
	
  def ChannelInput fromRing
  def ChannelOutput toRing
  
  void run () {
    println "Extra Element v2 starting ..."
    while (true) {
      toRing.write( fromRing.read() )   
    }
  }
}
 
      
