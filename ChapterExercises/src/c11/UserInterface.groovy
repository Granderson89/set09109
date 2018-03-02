package c11

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
	def ChannelInput printConfig
	def ChannelOutput buttonEvent
	
	void run() {
		def root = new ActiveClosingFrame ("Scale Controller")
		def mainFrame = root.getActiveFrame()
		
		
		// Suspend button
		def suspendButton = new ActiveButton(suspendButtonConfig, buttonEvent, "SUSPEND")
		
		// Current scale
		def scaleLabel = new Label ("Current Scale")
		def scaleValue = new ActiveLabel (scaleValueConfig)
		
		// New scale
		def newScaleLabel = new Label("Enter New Scale")
		def newScale = new ActiveTextEnterField(null, buttonEvent)
		Panel newScalePanel = new Panel (new GridLayout (1, 1));
		newScalePanel.add (newScale.getActiveTextField ());
		
		// Set up container, canvas and frame
		def scaleContainer = new Container()
		scaleContainer.setLayout(new GridLayout (2, 5))
		scaleContainer.add(suspendButton)
		scaleContainer.add(scaleLabel)
		scaleContainer.add(scaleValue)
		scaleContainer.add(newScaleLabel)
		scaleContainer.add(newScalePanel)
		controllerCanvas.setSize(canvasSize, canvasSize)
		mainFrame.setLayout(new BorderLayout())
		mainFrame.add(controllerCanvas, BorderLayout.CENTER)
		mainFrame.add(scaleContainer, BorderLayout.SOUTH)
		mainFrame.pack()
		mainFrame.setVisible(true)
		
		def network = [ root, controllerCanvas, scaleValue, newScale, suspendButton]
		new PAR (network).run()
	}
}