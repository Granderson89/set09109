package c03

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel
import groovyJCSP.plugAndPlay.*
import groovyJCSP.examples.*
import jcsp.lang.*
import groovyJCSP.*

def F2P = Channel.one2one()

def testList = [ new FibonacciV1 ( outChannel: F2P.out() ),
                 new GPrint ( inChannel: F2P.in(), 
                              heading: "Fibonacci V1" )
               ]

new PAR ( testList ).run()  
                        