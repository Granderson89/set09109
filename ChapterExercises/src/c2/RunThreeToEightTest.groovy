package c2

import jcsp.lang.*
import groovyJCSP.*

class RunThreeToEightTest extends GroovyTestCase {
	
	void testMessage() {
		One2OneChannel connect1 = Channel.createOne2One()
		One2OneChannel connect2 = Channel.createOne2One()

		def three = new GenerateSetsOfThree ( outChannel: connect1.out() )
		def to = new ListToStream ( inChannel: connect1.in(), 
                    		        outChannel: connect2.out() ) 
		def eight = new CreateSetsOfEight ( inChannel: connect2.in(), 
											size: 8 )
		def processList = [ three, to, eight ]
		new PAR (processList).run()
		def expected = " Eight Object is [1, 2, 3, 4, 5, 6, 7, 8]\n Eight Object is [9, 10, 11, 12, 13, 14, 15, 16]\n Eight Object is [17, 18, 19, 20, 21, 22, 23, 24]\nFinished"
		def actual = eight.message
		assertTrue(expected == actual)
	}

}
