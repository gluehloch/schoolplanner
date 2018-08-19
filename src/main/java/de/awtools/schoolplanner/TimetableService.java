package de.awtools.schoolplanner;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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

	@CrossOrigin
	@RequestMapping(value = "/courses/today", method = RequestMethod.GET)
	public List<String> findAllSeason() {

		// return betofficeBasicJsonService.findAllSeason();
		return List.of("Andre", "Lars", "Adam", "Erwin", "Christine", "Spike");
	}

}
