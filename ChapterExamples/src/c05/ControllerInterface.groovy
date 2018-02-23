package c05

import groovyJCSP.*
import jcsp.lang.*
import phw.util.*
import jcsp.util.*
import jcsp.awt.*

class ControllerInterface implements CSProcess {
	
  def ChannelInput inChannel
  def ChannelOutput suspend
  def ChannelOutput inject
  def int canvasSize = 100
  def int initialScale
  
  void run() {
    def controllerCanvas = new ActiveCanvas()
    def scaleConfig = Channel.one2one()
    def suspendConfig = Channel.one2one()
    def uiEvents = Channel.any2one( new OverWriteOldestBuffer(5) )
    def network = [ new ControllerManager ( fromScale: inChannel, 
                                          toScaleSuspend: suspend,
										  toScaleInject: inject,
                                          fromUIButtons: uiEvents.in(),
                                          toUISuspend: suspendConfig.out(),
                                          toUILabel: scaleConfig.out(),
                                          CANVASSIZE: canvasSize,
                                          START_SCALE: initialScale ),
                    new UserInterface   ( controllerCanvas: controllerCanvas, 
                                          canvasSize: canvasSize,
                                          scaleValueConfig: scaleConfig.in(),
                                          suspendButtonConfig: suspendConfig.in(),
                                          buttonEvent: uiEvents.out()  )
                  ]
    new PAR ( network ).run()
  }
}
   