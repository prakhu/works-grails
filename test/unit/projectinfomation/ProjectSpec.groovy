package projectinfomation

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Project)
class ProjectSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	def projectData = [
		name: 'Tribal Worldwide1',
		code: '4201',
		techLead: 'Prakhar Srivastava1',
		manager: 'Srivastava Prakhar1',
		delivery: new Date(),
		priority: 11
	]
	
	void "test something"() {
	
		setup:
		def existingProject = new Project(projectData).save()

		when:
		def project = new Project(projectData)

		then:
		false == project.validate()
		'unique' == project.errors['code'].code
		
		}
}
