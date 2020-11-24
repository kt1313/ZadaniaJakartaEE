package pl.javastart;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/divider")
public class Divider extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setContentType(response);
        sendHtmlResponse(countDividers(request,response),request,response);
    }
    private void setContentType(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }
    protected List<Integer> countDividers(HttpServletRequest request, HttpServletResponse response) {
        String liczbaString = request.getParameter("liczba");
        int liczba = Integer.parseInt(liczbaString);
        List<Integer> list= new ArrayList<>();
        System.out.println("Podzielniki liczby " + liczbaString);
        for (int i = 0; i < liczba; i++) {
            if (liczba % i == 0) {
                list.add(i);
            }
            ;
        }
        return list;
    }

    private void sendHtmlResponse(List<Integer> list,HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Map<String, String[]> parameterMap = request.getParameterMap();
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head></head>");
        writer.println("<body>");
        //writer.println("<ol>");
        writer.print("<h1>");
        writer.print("Dzielniki liczby" +request.getParameter("liczba"));
        writer.println("</h1>");
        for (Integer i : list) {
            //writer.printf("<li>%s</li>\n", key);
            //for (String value : parameterMap.get(key)) {
            writer.println("<ul>");
            writer.printf("<li>%s</li>\n", i);
            writer.println("</ul>");
        }
    //}
        //writer.println("</ol>");
        writer.println("</body>");
        writer.println("</html>");
    }

}