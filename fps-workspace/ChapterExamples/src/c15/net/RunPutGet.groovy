package c15.net

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel


import jcsp.lang.*
import groovyJCSP.*

def comms = Channel.one2one()

def network = [new Put (outChannel: comms.out()),
			   new Get (inChannel: comms.in())]

new PAR(network).run()
