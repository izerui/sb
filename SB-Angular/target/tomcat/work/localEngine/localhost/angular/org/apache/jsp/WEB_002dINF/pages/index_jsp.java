package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html ng-app=\"myApp\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>ç¨æ·çé¢</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/bootstrap.min.css\"></link>\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/app.css\"></link>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/lib/angular.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/lib/angular-route.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/lib/angular-resource.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/app.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/controllers.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/services.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/filters.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container-fluid\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-md-2\">\n");
      out.write("\t\t\t\t<ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("\t\t\t\t   <li><a href=\"#user/list\">åè¡¨</a></li>\n");
      out.write("\t\t\t\t   <li><a href=\"#user/add\">å¢å </a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-md-10\">\n");
      out.write("\t\t\t\t<div ng-view></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
