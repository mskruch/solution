package solution;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

public class ExceptionFilter implements Filter
{
	static final Logger logger = getLogger(ExceptionFilter.class);
	private static final String ERROR_PAGE = "/WEB-INF/views/error.jsp";

	@Override
	public void doFilter(
		ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException
	{
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			Object errorId = generateErrorId(e);
			logger.error("not handled exception: " + errorId, e);
			request.setAttribute("errorId", errorId);

			((HttpServletResponse) response)
				.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

			request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
		}
	}

	private String generateErrorId(Exception e)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyMMddHHmmssSSS");
		return simpleDateFormat.format(new Date());
	}

	@Override
	public void init(FilterConfig config) throws ServletException
	{
	}

	@Override
	public void destroy()
	{
	}
}
