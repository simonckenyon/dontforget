package ie.koala.dontforget

class Reminder {
	
	String description
	Date dateCreated
	boolean checked

	static belongsTo = [user: User]
	
    static constraints = {
		description blank: false
    }

}
