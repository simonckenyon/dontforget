package ie.koala.dontforget

class Reminder {
	
	String description
	Date dateCreated

	static belongsTo = [user: User]
	
    static constraints = {
		description blank: false
    }

}
