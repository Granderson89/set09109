package c21.net
 
  
import jcsp.lang.*
import jcsp.net.*
import jcsp.net.tcpip.*
import groovyJCSP.*
import phw.util.*

def dataGenIP = "127.0.0.1"
def gathererIP = "127.0.0.2"

def pList = [ new Type3Process()]
def vList = [ new Type3Process()]
              
def processList = new NodeProcess ( nodeId: 3,
									                   nodeIPFinalPart: 5,
                                     toGathererIP: gathererIP,
                                     toDataGenIP: dataGenIP,
                                     processList: pList,
                                     vanillaList: vList
                                   )

new PAR ([ processList]).run()
