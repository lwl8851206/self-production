package self.production.controller;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import self.production.util.ServersUtil;

@Controller
public class WarController {

	public WarController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/war/warToUpload")
	public String warToUpload(@RequestParam("owner")String owner, ModelMap mm) {
		HashSet<String> serversSet = ServersUtil.getServers();
		String[] servers = new String[serversSet.size()];
		serversSet.toArray(servers);
		mm.addAttribute("servers", servers);
		mm.put("owner", owner);
		return "updatewar";
	}
	
	@RequestMapping("/war/updateWar.do")
	@ResponseBody
	public String updateWar(@RequestParam("servers") String server, @RequestParam("path")String path) {
		return "haha";
	}
	
	@ModelAttribute("currentTab")
	public String generateAlready() {
		return "war";
	}

}
