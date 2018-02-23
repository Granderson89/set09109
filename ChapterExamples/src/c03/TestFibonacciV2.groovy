package c03

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel
import groovyJCSP.plugAndPlay.*
import jcsp.lang.*
import groovyJCSP.*
import groovyJCSP.examples.*

def F2P = Channel.one2one()

def testList = [ new FibonacciV2 ( outChannel: F2P.out() ),
                 new GPrint ( inChannel: F2P.in(), 
                              heading: "Fibonacci V2" )
               ]

new PAR ( testList ).run()                          