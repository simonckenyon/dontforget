package ie.koala.dontforget



import org.junit.*
import grails.test.mixin.*

@TestFor(ReminderController)
@Mock(Reminder)
class ReminderControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/reminder/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.reminderInstanceList.size() == 0
        assert model.reminderInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.reminderInstance != null
    }

    void testSave() {
        controller.save()

        assert model.reminderInstance != null
        assert view == '/reminder/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/reminder/show/1'
        assert controller.flash.message != null
        assert Reminder.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/reminder/list'

        populateValidParams(params)
        def reminder = new Reminder(params)

        assert reminder.save() != null

        params.id = reminder.id

        def model = controller.show()

        assert model.reminderInstance == reminder
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/reminder/list'

        populateValidParams(params)
        def reminder = new Reminder(params)

        assert reminder.save() != null

        params.id = reminder.id

        def model = controller.edit()

        assert model.reminderInstance == reminder
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/reminder/list'

        response.reset()

        populateValidParams(params)
        def reminder = new Reminder(params)

        assert reminder.save() != null

        // test invalid parameters in update
        params.id = reminder.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/reminder/edit"
        assert model.reminderInstance != null

        reminder.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/reminder/show/$reminder.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        reminder.clearErrors()

        populateValidParams(params)
        params.id = reminder.id
        params.version = -1
        controller.update()

        assert view == "/reminder/edit"
        assert model.reminderInstance != null
        assert model.reminderInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/reminder/list'

        response.reset()

        populateValidParams(params)
        def reminder = new Reminder(params)

        assert reminder.save() != null
        assert Reminder.count() == 1

        params.id = reminder.id

        controller.delete()

        assert Reminder.count() == 0
        assert Reminder.get(reminder.id) == null
        assert response.redirectedUrl == '/reminder/list'
    }
}
