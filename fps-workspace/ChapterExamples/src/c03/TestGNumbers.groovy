package c03

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel

import groovyJCSP.plugAndPlay.*
import jcsp.lang.*
import groovyJCSP.*

def N2P = Channel.one2one()

def testList = [ new GNumbers ( outChannel: N2P.out() ),
                 new GPrint ( inChannel: N2P.in(),
                              heading : "Numbers" )
               ]
new PAR ( testList ).run()
                                               