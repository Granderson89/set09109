package c09
  
// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel

import jcsp.lang.*
import groovyJCSP.*
import groovyJCSP.plugAndPlay.*

def eg2h = Channel.one2one()
def h2t = Channel.one2one()
def t2udd = Channel.one2one()
def udd2prn = Channel.one2one()

def eventTestList = [ 
      new EventGenerator ( source: 1, 
                           initialValue: 100, 
                           iterations: 100, 
                           outChannel: eg2h.out(), 
                           minTime: 100, 
                           maxTime:200 ),
					   
      new EventHandler ( inChannel: eg2h.in(), 
                         outChannel: h2t.out() ),
					 
	  new EventTest ( inChannel: h2t.in(),
		  			  outChannel: t2udd.out() ),
					 
      new UniformlyDistributedDelay ( inChannel:t2udd.in(), 
                                      outChannel: udd2prn.out(), 
                                      minTime: 1000, 
                                      maxTime: 2000 ), 
								  
      new GPrint ( inChannel: udd2prn.in(),
    		        heading : "Event Output",
    		        delay: 0)
      ]

new PAR ( eventTestList ).run() 
             