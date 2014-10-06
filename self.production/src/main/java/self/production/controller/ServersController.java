package self.production.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import self.production.util.ServersUtil;

@Controller
public class ServersController {

	
	public ServersController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/servers/addServer.do")
	@ResponseBody
	public String addServer(HttpServletRequest rq){
		String addedServer = rq.getParameter("addedServer");
		if (addedServer == null)
			return String.format("param ['%s'] must not be empty", "addedServer");
		ServersUtil.addServers(addedServer);
		return String.format("you have added server[%s]", addedServer);
	}
	
	@RequestMapping("/servers/removeServer.do")
	@ResponseBody
	public String removeServer(HttpServletRequest rq) {
		String removedServer = rq.getParameter("removedServer");
		if (removedServer == null)
			return String.format("param ['%s'] must not be empty", "removedServer");
		ServersUtil.removeServers(removedServer);
		return String.format("you have removed server[%s]", removedServer);		
	}
	
	@RequestMapping("/servers/getServers.do")
	@ResponseBody
	public String getServers() {
		JSONArray jsonArr = new JSONArray(ServersUtil.getServers());
		return jsonArr.toString();
	}
	
	@ModelAttribute("currentTab")
	public String generateAlready() {
		return "hosts";
	}

}
