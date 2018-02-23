package c07
 
// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel

import jcsp.lang.*
import groovyJCSP.*
import groovyJCSP.plugAndPlay.*

def a = Channel.one2one()
def b = Channel.one2one()

def pList = [ new BadP ( inChannel: a.in(), outChannel: b.out() ),
              new BadC ( inChannel: b.in(), outChannel: a.out() )
            ]

new PAR (pList).run()