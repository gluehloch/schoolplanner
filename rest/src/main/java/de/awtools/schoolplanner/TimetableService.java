package de.awtools.schoolplanner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.awtools.schoolplanner.school.Course;
import de.awtools.schoolplanner.school.Lesson;
import de.awtools.schoolplanner.school.LessonRepository;
import de.awtools.schoolplanner.school.SchoolClass;
import de.awtools.schoolplanner.school.SchoolService;


@RestController
@RequestMapping("/timetable")
public class TimetableService {

	// ------------------------------------------------------------------------
	// The beans
	// ------------------------------------------------------------------------


	// ------------------------------------------------------------------------

	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private LessonRepository lessonRepository;

	@Transactional
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Course createCourse(@RequestBody Course course) {
		return course;
	}
	
	@Transactional
	@CrossOrigin
	@GetMapping(value = "/school/{schoolId}/class/{classId}/course/today")
	public List<Lesson> findCoursesForToday(@PathVariable("schoolId") String schoolId,
			@PathVariable("classId") String classId) {

	    Optional<SchoolClass> clazz = schoolService.findSchoolClass(4711);
	    
		// classRepository.findById(4711L);
		LocalDateTime now = LocalDateTime.now();
		
		List<Lesson> lessons = lessonRepository.findToday(now.getDayOfWeek());

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
