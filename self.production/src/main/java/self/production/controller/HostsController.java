package self.production.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;

import self.production.model.HostsContent;
import self.production.model.hosts.Hosts;
import self.production.model.hosts.HostsList;
import self.production.util.FileUtil;
import self.production.util.HostsUtil;
import self.production.util.ServersUtil;

@Controller
public class HostsController {// 通过扩展Controller接口定义处理器
	public static Logger logger = LoggerFactory
			.getLogger(HostsController.class);

	// 匹配/index.do?nick=fdf,并且参数nick自动赋给nickName,ModelMap可以存储变量，传给模版
	@RequestMapping("/hosts/hostsManager.do")
	public String getHosts(@RequestParam("owner") String owner, ModelMap mm) {
		List<String> hostsList = null;
		hostsList = HostsUtil.getOnesHostsList(owner);
		mm.addAttribute("hostsList", hostsList);
		mm.addAttribute("owner", owner);
		return "hosts-manager";
	}

	@RequestMapping("/index.do")
	public String index(ModelMap mm) {
		HashSet<String> serversSet = ServersUtil.getServers();
		String[] servers = new String[serversSet.size()];
		serversSet.toArray(servers);
		mm.addAttribute("servers", servers);
		for (String server : servers)
			System.out.println(server);
		return "index";
	}

	@RequestMapping("/hosts/deleteHosts.do")
	public String deleteHosts(HttpServletRequest rq) {
		String owner = rq.getParameter("owner");
		String hosts = rq.getParameter("hosts");
		if (owner == null || hosts == null)
			System.out.println(String.format("params [\"%s\" or \"%s\"] must mot be empty",
					"hosts", "owner"));
		HostsUtil.deleteHostsForOne(owner, hosts);
		System.out.println(String.format("you haved deleted hosts[%s] from server[%s]",
				hosts, owner));
		return "redirect:/hosts/hostsManager.do?owner=" + owner;
	}

	@RequestMapping(value="/hosts/createHosts.do", method=RequestMethod.POST)
	public String createHosts(HttpServletRequest rq,@ModelAttribute HostsContent hostsContent) {
		HostsUtil.createHostsForOne(hostsContent.getHostsOwner(), hostsContent.getHostsName(), hostsContent.getHostsContent());
		System.out.println(String.format("you have create hosts[%s] for owner[%s]", hostsContent.getHostsName(), hostsContent.getHostsOwner()));
		return "redirect:/hosts/hostsManager.do?owner=" + hostsContent.getHostsOwner();
	}
	
	@RequestMapping("/hosts/addHosts.do")
	public String addHost(@RequestParam("owner") String owner, @RequestParam(value="hosts", required=false) String hosts, ModelMap mm) {
		mm.addAttribute("owner", owner);
		mm.addAttribute("hosts", hosts == null ? "" : hosts);
		mm.addAttribute("content", hosts == null ? "" : HostsUtil.getHostsContent(owner, hosts));
		mm.addAttribute("hostsContent", new HostsContent());
		return "hosts-add";
	}
	
	@RequestMapping("/hosts/readHostsContent.do")
	@ResponseBody
	public String readHostsContent(HttpServletRequest rq) {
		String owner = rq.getParameter("owner");
		String hosts = rq.getParameter("hosts");
		if (owner == null || hosts == null)
			return String.format("params [\"%s\" or \"%s\"] must mot be empty",
					"hosts", "owner");		

		return String.format("hosts[%s]'s content: <br>%s", hosts, HostsUtil.getHostsContent(owner, hosts));
	}
	
	@RequestMapping("/hosts/editHostsContent.do")
	@ResponseBody
	public String editHostsContent(HttpServletRequest rq) {
		String owner = rq.getParameter("owner");
		String hosts = rq.getParameter("hosts");
		String content = rq.getParameter("hostsContent");
		if (owner == null || hosts == null)
			return String.format("params [\"%s\" or \"%s\" or \"%s\"] must mot be empty",
					"hosts", "owner", "hostsContent");				
		HostsUtil.editHostsContent(owner, hosts, content);
		return String.format("hosts[%s]'s content is updated, content is below:<br>%s", hosts, HostsUtil.getHostsContent(owner, hosts));
	}
	
	@RequestMapping("/hosts/copyHosts.do")
	@ResponseBody
	public String copyHosts(HttpServletRequest rq) {
		String owner = rq.getParameter("owner");
		String from = rq.getParameter("from");
		String hosts = rq.getParameter("hosts");
		if (owner == null || hosts == null)
			return String.format("params [\"%s\" or \"%s\" or \"%s\"] must mot be empty",
					"hosts", "owner", "from");
		HostsUtil.copyHosts(owner, from, hosts);
		return String.format("copy hosts[%s] from %s to %s--done", hosts, from, owner);
	}
	
	@ModelAttribute("already")
	public String generateAlready() {
		return "i am already here";
	}
}
