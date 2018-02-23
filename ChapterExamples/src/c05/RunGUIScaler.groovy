package c05
 
import jcsp.lang.*
import groovyJCSP.*
import groovyJCSP.plugAndPlay.*

def data = Channel.one2one()
def timedData = Channel.one2one()
def scaledData = Channel.one2one()
def oldScale = Channel.one2one()
def newScale = Channel.one2one()
def pause = Channel.one2one() 

def network = [ new GNumbers ( outChannel: data.out() ),
                new GFixedDelay ( delay: 1000, 
                		          inChannel: data.in(), 
                		          outChannel: timedData.out() ),
							  
                new Scale ( inChannel: timedData.in(),
                            outChannel: scaledData.out(),
                            factor: oldScale.out(),
                            suspend: pause.in(),
                            injector: newScale.in(),
                            multiplier: 2,
                            scaling: 2 ),
						
                new ControllerInterface ( inChannel: oldScale.in(),
										  suspend: pause.out(),
										  inject: newScale.out(),
										  initialScale: 2 ),
							 
                new GPrint ( inChannel: scaledData.in(),
                		     heading: "Original      Scaled",
                		     delay: 0)
              ]

new PAR ( network ).run()                                                            
