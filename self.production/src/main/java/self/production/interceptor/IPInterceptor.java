package self.production.interceptor;

import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import self.production.util.CollectionHelper;
import self.production.util.FileUtil;

public class IPInterceptor implements HandlerInterceptor{
	private static String IP_LIMIT_CONFIG_FILE = HandlerInterceptor.class.getResource("/").getPath() + "iplimit.properties";
	
	public IPInterceptor() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj)
			throws Exception {
		// TODO Auto-generated method stub
		String ipLimitProperties = FileUtil.readProperties(IP_LIMIT_CONFIG_FILE).getProperty("ip");
		if (ipLimitProperties == null || ipLimitProperties.equals(""))
			return false;
		
		HashSet<String> ipLimits = CollectionHelper.stringToHashSet(ipLimitProperties);
		//httpservletrequest.setAttribute("inte", "intercepted");
		String fromIP = httpservletrequest.getRemoteHost();
		System.out.printf("interceptor works, address:%s,ip:%s",httpservletrequest.getRemoteAddr(),  fromIP);
		if (ipLimits.contains(fromIP))
			return true;
		else
			return false;
	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
