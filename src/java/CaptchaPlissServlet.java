/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ITU
 */
@WebServlet(urlPatterns = {"/captcha.jpg"})
public class CaptchaPlissServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpg");
        /*
     * Define number characters contains the captcha image, declare global
     */
    int iTotalChars = 6;

    /*
     * Size image iHeight and iWidth, declare globl
     */
    int iHeight = 40;
    int iWidth = 150;

    /*
     * font style
     */
    Font fntStyle1 = new Font("Arial", Font.BOLD, 30);
    Font fntStyle2 = new Font("Verdana", Font.BOLD, 20);

    /*
     * Possible random characters in the image
     */
    Random randChars = new Random();
    String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);

    /*
     * BufferedImage is used to create a create new image
     */
    /*
     * TYPE_INT_RGB - does not support transpatency, TYPE_INT_ARGB - support transpatency
     */
    BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2dImage = (Graphics2D) biImage.getGraphics();

    // Draw background rectangle and noisey filled round rectangles
    int iCircle = 15;
    //g2dImage.fillRect(0, 0, iWidth, iHeight);
    for (int i = 0; i < iCircle; i++) {
        g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
        int iRadius = (int) (Math.random() * iHeight / 2.0);
        int iX = (int) (Math.random() * iWidth - iRadius);
        int iY = (int) (Math.random() * iHeight - iRadius);
        //g2dImage.fillRoundRect(iX, iY, iRadius * 2, iRadius * 2,100,100);
    }
    g2dImage.setFont(fntStyle1);
    for (int i = 0; i < iTotalChars; i++) {
        g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
        if (i % 2 == 0) {
            g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 24);
        } else {
            g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 35);
        }
    }

    /*
     * create jpeg image and display on the screen
     */
    OutputStream osImage = response.getOutputStream();
    ImageIO.write(biImage, "jpeg", osImage);
    //osImage.close();

    /*
     * Dispose function is used destory an image object
     */
    g2dImage.dispose();

    HttpSession session = request.getSession();
    session.setAttribute("dns_security_code", sImageCode);
    //System.out.println("Captcha Page :"+session.getAttribute("dns_security_code"));
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
