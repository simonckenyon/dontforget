package ie.koala.dontforget

class DebugFilters {

  private static final log = org.apache.commons.logging.LogFactory.getLog(this)

  def filters = {
	all(controller: '*', action: '*') {
	  before = {
		log.debug "request params: $params"
	  }
	}
  }
}