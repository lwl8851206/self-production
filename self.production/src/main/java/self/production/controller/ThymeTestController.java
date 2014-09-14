package self.production.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import self.production.model.hosts.Hosts;
import self.production.service.DataService;

@Controller
public class ThymeTestController {
	
	@Autowired
	private DataService dataService;
	
	@ModelAttribute("already")
	public String generateAlready() {
		return this.dataService.getData();
	}
	
	public ThymeTestController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/thyme/getData.do")
	@ResponseBody
	public TestPojo getData(HttpServletRequest rq, ModelMap mm) {
		TestPojo tp = new TestPojo();
		tp.setId("id1");
		tp.setPojos(new String[]{"one", "tow", "three"});
		return tp;
		//return String.format("from interceptor: %s", rq.getAttribute("inte"));
	}

}

class TestPojo {
	private String id;
	private String [] pojos;
	
	public TestPojo(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getPojos() {
		return pojos;
	}

	public void setPojos(String[] pojos) {
		this.pojos = pojos;
	}
	
}
