package c05

import groovyJCSP.*
import jcsp.lang.*
import phw.util.*
import jcsp.awt.*
import java.awt.*

class UserInterface implements CSProcess {
	
	def ActiveCanvas controllerCanvas
	def int canvasSize
	def ChannelInput scaleValueConfig
	def ChannelInput suspendButtonConfig
	def ChannelOutput buttonEvent
	
	void run() {
		def root = new ActiveClosingFrame ("Scale Controller")
		def mainFrame = root.getActiveFrame()
		def scaleLabel = new Label ("Scale")
		def scaleValue = new ActiveLabel (scaleValueConfig)
		def newScale = new TextField()
		scaleValue.setAlignment(Label.CENTER)
		def suspendButton = new ActiveButton(suspendButtonConfig, buttonEvent, "START")
		def scaleContainer = new Container()
		scaleContainer.setLayout(new GridLayout (1, 5))
		scaleContainer.add(suspendButton)
		scaleContainer.add(scaleLabel)
		scaleContainer.add(scaleValue)
		scaleContainer.add(newScale)
		controllerCanvas.setSize(canvasSize, canvasSize)
		mainFrame.setLayout(new BorderLayout())
		mainFrame.add(controllerCanvas, BorderLayout.CENTER)
		mainFrame.add(scaleContainer, BorderLayout.SOUTH)
		mainFrame.pack()
		mainFrame.setVisible(true)
		def network = [ root, controllerCanvas, scaleValue, suspendButton]
		new PAR (network).run()
	}
}