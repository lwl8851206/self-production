package self.production.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WarController {

	public WarController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/war/warToUpload.do")
	public String warToUpload(@RequestParam("owner")String owner, ModelMap mm) {
		mm.put("owner", owner);
		return "updatewar";
	}
	
	@ModelAttribute("currentTab")
	public String generateAlready() {
		return "war";
	}

}
