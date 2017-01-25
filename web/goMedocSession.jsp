<%@page import="java.util.ArrayList"%>
<%@page import="fonctions.Article"%>
<%@page import="javax.mail.Session"%>
<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<% 
    Login temp = new Login();  
    String med = request.getParameter("med");    
    String qt = request.getParameter("qt");    
    String pos = request.getParameter("pos");   
    ArrayList<String[]> tp = new ArrayList<String[]>();
    tp.add(new String[]{med,qt,pos});
    ArrayList<String[]> sess = (ArrayList<String[]>)session.getAttribute("liste");
    if(sess==null)session.setAttribute("liste",tp);                
    else {
        sess.add(new String[]{med,qt,pos});
        session.setAttribute("liste",sess);
    }
%>