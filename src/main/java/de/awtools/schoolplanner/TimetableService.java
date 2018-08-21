package de.awtools.schoolplanner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetable")
public class TimetableService {

	// ------------------------------------------------------------------------
	// The beans
	// ------------------------------------------------------------------------

//    // -- betofficeBasicJsonService -------------------------------------------
//
//    private BetofficeBasicJsonService betofficeBasicJsonService;
//
//    @Autowired
//    public void setBetofficeBasicJsonService(
//            BetofficeBasicJsonService _betofficeBasicJsonService) {
//
//        betofficeBasicJsonService = _betofficeBasicJsonService;
//    }

	// ------------------------------------------------------------------------

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Course createCourse(@RequestBody Course course) {
		return course;
	}
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value = "/school/{schoolId}/class/{classId}/course/today", method = RequestMethod.GET)
	public List<String> findCoursesForToday(@PathVariable("schoolId") String schoolId,
			@PathVariable("classId") String classId) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM course c", Course.class);
		List resultList = query.getResultList();
		
		return List.of("Andre", "Lars", "Adam", "Erwin", "Christine", "Spike");
	}

	@CrossOrigin
	@RequestMapping(value = "/school/{schoolId}/class/{classId}/course/week", method = RequestMethod.GET)
	public List<String> findCoursesForWeek(@PathVariable("schoolId") String schoolId,
			@PathVariable("classId") String classId) {

		return List.of("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag");
	}

	@CrossOrigin
	@RequestMapping(value = "/school/{schoolId}/class/{classId}/course/{courseId}", method = RequestMethod.GET)
	public List<String> findCourse(@PathVariable("schoolId") String schoolId, @PathVariable("classId") String classId,
			@PathVariable("courseId") String courseId) {

		return List.of("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag");
	}

}
