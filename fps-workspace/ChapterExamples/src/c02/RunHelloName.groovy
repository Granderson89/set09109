package c02

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel


import jcsp.lang.*
import groovyJCSP.*

def connect = Channel.one2one()

def processList = [ new ProduceHN ( outChannel: connect.out() ),
                    new ConsumeHello ( inChannel: connect.in() )
                  ]
new PAR (processList).run()   
                