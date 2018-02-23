package c05

import groovyJCSP.*
import jcsp.lang.*
import phw.util.*
import jcsp.awt.*
import java.awt.*

class ControllerManager implements CSProcess {
	
	def ChannelInput fromScale
	def ChannelOutput toScaleSuspend
	def ChannelOutput toScaleInject
	def int CANVASSIZE
	def int START_SCALE
	def ChannelInput fromUIButtons
	def ChannelOutput toUILabel
	def ChannelOutput toUISuspend
	
	void run() {
		def scale = START_SCALE
				
		def initScale = scale
		toUILabel.write( initScale.toString() )
		
		def direction = fromUIButtons.read()
		while (direction != "START") {
			direction = fromUIButtons.read()
		}
		toUISuspend.write("SUSPEND")
		
		while (true) {
			direction = fromUIButtons.read()
			if (direction == "SUSPEND") {
				toUISuspend.write("INJECT")
				toScaleSuspend.write(0)
				scale = fromScale.read()
				direction = fromUIButtons.read()
				while (direction != "INJECT") {
					direction = fromUIButtons.read()
				}
				toUISuspend.write("SUSPEND")
				//scale = (int)direction
				toUILabel.write(scale.toString())
				toScaleInject.write(scale)
			}
		}
	}	
}