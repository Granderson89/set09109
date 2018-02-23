package c12.canteen

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel

import jcsp.lang.*
import groovyJCSP.*
import groovyJCSP.plugAndPlay.*

class ClockedQueuingServery implements CSProcess{

  def ChannelInput service    
  def ChannelOutput deliver    
  def ChannelInput supply   
   
  void run() {
    
    def console = Channel.any2one()
    
    def clock = new Clock ( toConsole: console.out() )
    
    def servery = new QueuingCanteen ( service: service,
                                        deliver: deliver,
                                        supply: supply,
                                        toConsole: console.out() )
    def serveryConsole = new GConsole ( toConsole: console.in(),
                                        frameLabel: "Clocked Queuing Servery")
    new PAR([servery, serveryConsole, clock ]).run()
  }

}