package c14

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel

import jcsp.lang.*
import groovyJCSP.*


class BarrierManager implements CSProcess{
	
  def AltingBarrier timeAndHitBarrier
  def AltingBarrier finalBarrier
  def Barrier goBarrier
  def Barrier setUpBarrier

  void run() {
    def timeHitAlt = new ALT ([timeAndHitBarrier])
    def finalAlt = new ALT ([finalBarrier])
    setUpBarrier.sync()
	
    while (true){
      goBarrier.sync()
      def t = timeHitAlt.select()
      def f = finalAlt.select()
    }
  }
}
