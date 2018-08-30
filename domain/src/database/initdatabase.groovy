import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

import de.awtools.schoolplanner.PersistenceJPAConfig
import de.awtools.schoolplanner.school.SchoolService

@Grab(group='de.awtools.schoolplanner', module='domain', version='0.0.1-SNAPSHOT')


class Service {
    SchoolService schoolService;

    public Service() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        schoolService = ctx.getBean(SchoolService.class);
    }
}

println "Works as designed..."

Service service = new Service()
service.schoolService.createSchoolClass();
