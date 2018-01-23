package c2

import jcsp.lang.*
import groovyJCSP.*

One2OneChannel connect1 = Channel.createOne2One()
One2OneChannel connect2 = Channel.createOne2One()

def processList = [ new GenerateSetsOfThree ( outChannel: connect1.out() ),
                    new ListToStream ( inChannel: connect1.in(), 
                    		           outChannel: connect2.out() ),
                    new CreateSetsOfEight ( inChannel: connect2.in(), 
											size: 8 )
                  ]
new PAR (processList).run()