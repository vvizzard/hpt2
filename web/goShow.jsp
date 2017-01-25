<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<% 
    Login temp = new Login();  
    String id = request.getParameter("id");
    //if(id == "*")id = null;
    String nom = request.getParameter("nom");    
    String prenom = request.getParameter("prenom");
    //if(nom == "*")nom = null;
    String dateNaissance1 = request.getParameter("dateNaissance1");
    String dateNaissance2 = request.getParameter("dateNaissance2");
    String dn = dateNaissance1.substring(8)+dateNaissance1.substring(4,7)+'-'+dateNaissance1.substring(0,4);
    String dn2 = dateNaissance2.substring(8)+dateNaissance2.substring(4,7)+'-'+dateNaissance2.substring(0,4);
    
    
    /*String[] specialite = temp.getSpecialite();  
    int i;
    for(i = 0; i<specialite.length;i++)if(specialite[i].compareTo(sp)==0)break;
    temp.insertMed(nom, prenom, dn, salaire,i);*/
    String bla = "";
    Medecin[] tst = null;
    try{
        tst = temp.getMedecin(id,nom,prenom,dateNaissance1,dateNaissance2);
    }
    catch(Exception e){
        bla = e.getMessage();
    }
    //Medecin[] tst = temp.getMedecin("*","RA","m","1800/01/01","3000/12/12");
    
    //request.getRequestDispatcher("insertMedecin.jsp").forward(request, response);
    
%>

<div class="container login lg">
    <div >
        <% if(bla.compareTo("")==0){ %>
        <table class="table table-hover">
            <tr>
                <th>id</th>
                <th>nom</th>
                <th>prenom</th>
                <th>date de naissance</th>
                <th>spécialité</th>
                <th>salaire</th>
            </tr>
            <% for(int i = 0; i<tst.length;i++){%>
            <tr>
                <td> <% out.print(tst[i].id); %> </td>
                <td> <% out.print(tst[i].nom); %> </td>
                <td> <% out.print(tst[i].prenom); %> </td>
                <td> <% out.print(tst[i].dateNaissance); %> </td>
                <td> <% out.print(tst[i].specialite);%></td>
                <td> <% out.print(tst[i].salaire.substring(0,tst[i].salaire.length()-1 ));%></td>
                <td><a href = "deleteMedecin.jsp?id=<%out.println(tst[i].id); %>">delete</td>
                <td><a href = "modifMedecin.jsp?id=<%out.println(tst[i].id); %>&&nom=<%out.println(tst[i].nom);%>&&prenom=<%out.println(tst[i].prenom);%>&&dateNaissance=<%out.println(tst[i].dateNaissance);%>&&salaire=<%out.println(tst[i].salaire);%>">modifier</td>
            </tr>
            <%}%>
        </table>
            <%} else{%>
            <p><%out.print(bla);%></p>
            <%}%>
    </div>
</div>  

<jsp:include page="templates/footer.jsp" />