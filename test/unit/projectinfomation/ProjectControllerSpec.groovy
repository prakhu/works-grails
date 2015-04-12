package projectinfomation



import grails.test.mixin.*
import spock.lang.*


@TestFor(ProjectController)
@Mock(Project)
class ProjectControllerSpec extends Specification {

    def "index action redirects to list action"() {
        when:
        controller.list()

        then:
        response.redirectedUrl == '/project/list'
    }

    def "test list action"() {
        when:
        controller.list()

        then:
        view == '/project/list'
        model.projectInstanceList.size() == 0
    }

    def "test create action"() {
        when:
        controller.create()

        then:
        model.projectInstance != null
    }

    def "save a project without params"() {
        when:
        controller.save()

        then:
        model.projectInstance != null
        view == '/project/create'
    }

    def "save a project"() {
        given:
        populateValidParams(params)
        assert Project.count() == 0

        when:
        controller.save()

        then:
        Project.count() == 1
        response.redirectedUrl == '/project/show/1'
        flash.message != null
    }

    def "show a project"() {
        given:
        def project = new Project(projectValidProperties).save()

        when:
        params.id = project.id
        controller.show()

        then:
        view == '/project/show'
        model.projectInstance == project
    }

    def "edit a project not founded"() {
        when:
        controller.edit()

        then:
        flash.message != null
        response.redirectedUrl == '/project/list'
    }

    def "edit a project"() {
        given:
        def project = new Project(projectValidProperties).save()

        when:
        params.id = project.id
        controller.edit()

        then:
        view == '/project/edit'
        model.projectInstance == project
    }

    def "update a project successfully"() {
        given:
        def project = new Project(projectValidProperties).save()
        assert project.techLead == 'Prakhar Srivastava'

        when:
        params.id = project.id
        params.techLead = 'Prakhar'
        controller.update()

        then:
        project.techLead == 'Prakhar'
    }

    def "delete a project"() {
        given:
        def project = new Project(projectValidProperties).save()
        assert Project.count() == 1

        when:
        params.id = project.id
        controller.delete()

        then:
        Project.count() == 0
        response.redirectedUrl == '/project/list'
    }

    private populateValidParams(params) {
        params.with {[
            name: 'Tribal Worldwide',
		code: '420',
		techLead: 'Prakhar Srivastava',
		manager: 'Srivastava Prakhar',
		delivery: new Date(),
		priority: 1]
        }
    }

    private projectValidProperties = [
       name: 'Tribal Worldwide',
		code: '420',
		techLead: 'Prakhar Srivastava',
		manager: 'Srivastava Prakhar',
		delivery: new Date(),
		priority: 1
    ]
}