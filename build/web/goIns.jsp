<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<% 
    String bla = "";
    Login temp = new Login();        
    String nom = "";//request.getParameter("nom");
    String prenom = "";//request.getParameter("prenom");
    String dateNaissance = "";//request.getParameter("dateNaissance");
    String dn = "";//dateNaissance.substring(8)+dateNaissance.substring(4,7)+'-'+dateNaissance.substring(0,4);
    String salaire = "";//request.getParameter("salaire");
    String sp = "";//request.getParameter("specialite");
    
    try{
        nom = request.getParameter("nom");
        prenom = request.getParameter("prenom");
        dateNaissance = request.getParameter("dateNaissance");
        dn = dateNaissance.substring(8)+dateNaissance.substring(4,7)+'-'+dateNaissance.substring(0,4);
        salaire = request.getParameter("salaire");
        sp = request.getParameter("specialite");
    }
    catch(Exception s){
        bla = "erreur dans les formulaires";
    }
    
    String[] specialite = temp.getSpecialite();  
    int i;
    for(i = 0; i<specialite.length;i++)if(specialite[i].compareTo(sp)==0)break;
    
    try{
    temp.insertMed(nom, prenom, dn, salaire,i+1);
    }
    catch(Exception e){
        bla = e.getMessage();
    }
    //Medecin[] tst = temp.insertMed(null,"RA","m","1800/01/01","2000/12/12");
    if(bla.compareTo("")==0)request.getRequestDispatcher("goShow.jsp?id=&nom=&prenom=&dateNaissance1=1800-01-01&dateNaissance2=3000-01-01").forward(request, response);
    else{
    
%>

<jsp:include page="templates/header.jsp" />
        <div class="container login lg">
            <p> <% out.println(bla); %> </p>
        </div>
    </body>
</html>
<%}%>
<jsp:include page="templates/footer.jsp" />