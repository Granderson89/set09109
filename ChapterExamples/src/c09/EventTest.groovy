package c09

import jcsp.lang.*
import groovyJCSP.*

class EventTest implements CSProcess {
	def ChannelInput inChannel
	def ChannelOutput outChannel
	
	boolean test = true
	
	void run () {
		while (true) {
			def e = inChannel.read().copy()
			if (e.data != 100 && e.data != e.prev + e.missed + 1) {
				test = false
				println "Incorrect 'missed'"
			}
			outChannel.write(e)
		}
	}

}
