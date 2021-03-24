package tr.duzce.edu.mf.bm.tolga;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class KaydetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        String responseHeaderTanimi = "<html><head>";
        responseHeaderTanimi += "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>";
        responseHeaderTanimi += "<title>Servlet'den Merhaba!</title>";
        responseHeaderTanimi += "</head>";
        try {
            out = response.getWriter();
            out.println(responseHeaderTanimi);
            request.setCharacterEncoding("UTF-8");
            String isim = request.getParameter("isim").trim();
            String soyisim = request.getParameter("soyisim").trim();
            Integer cinsiyet = Integer.parseInt(request.getParameter("cinsiyet"));
            String strCinsiyet = "Bay";
            if(cinsiyet == 2)
                strCinsiyet = "Bayan";
            Integer sinif = Integer.parseInt(request.getParameter("sinif"));

            out.println("<body>");
            out.println("<h1>Girilen Bilgiler</h1>");
            out.println("<p>İsim: " + isim + "</p>");
            out.println("<p>Soyisim: " + soyisim + "</p>");
            out.println("<p>Cinsiyet: " + strCinsiyet + "</p>");
            out.println("<p>Sınıf: " + sinif + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close(); // Yazici nesne kapatiliyor
        }
    }
} // eof class