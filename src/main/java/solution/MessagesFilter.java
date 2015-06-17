package solution;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MessagesFilter implements Filter
{
	@Override
	public void doFilter(
		ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException
	{
		ResourceBundle bundle = ResourceBundle.getBundle("messages",
			request.getLocale());
		request.setAttribute("messages", bundle);

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override
	public void destroy()
	{
	}
}
