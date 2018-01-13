package c16.net
 
// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel

import jcsp.lang.*
import groovyJCSP.*
import jcsp.net.*

class PrintJob  implements Serializable{
	
  def int userId
  def NetChannelLocation useLocation
}
