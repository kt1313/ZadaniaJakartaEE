package pl.javastart;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        String numberString = request.getParameter("number");
        int number = Integer.parseInt(numberString);
        int numberMinus=0;
        List<Integer> list= new ArrayList<>();
        System.out.println("Podzielniki liczby : " +number);
        for (int i = 1; i <= Math.abs(number); i++) {
            if (number % i == 0) {
                list.add(i);
            }

            ;
        }
        if (number<0){
            //System.out.println(number);
            List<Integer> list2=new ArrayList<>();
            //dodaje wartości minusowe do LISTY jesli liczba mniejsza os zera
            for (Integer integ:list
            ) {
                numberMinus=integ*(-1);
                //System.out.println(numberMinus);
                list2.add(numberMinus);
            }
            list.addAll(list2);
            for (Integer cont:list
                 ) {
                System.out.println(cont);
            }
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
        writer.print("Podzielniki liczby " +request.getParameter("number"));
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