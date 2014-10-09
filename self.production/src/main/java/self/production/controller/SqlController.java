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
public class SqlController {

	public SqlController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/sql/sqlExecute")
	public String warToUpload(ModelMap mm) {
		HashSet<String> serversSet = ServersUtil.getServers();
		String[] servers = new String[serversSet.size()];
		serversSet.toArray(servers);
		mm.addAttribute("servers", servers);
//		mm.put("owner", owner);
		return "sql-execute";
	}
	
	@RequestMapping("/sql/executeSql.do")
	@ResponseBody
	public String updateWar(@RequestParam("servers") String server, @RequestParam("sql")String path) {
		return "haha";
	}
	
	@ModelAttribute("currentTab")
	public String generateAlready() {
		return "sql";
	}
}
