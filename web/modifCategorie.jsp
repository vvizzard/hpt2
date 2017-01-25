<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<% 
    String id = null;
    String nom = null;
        
    try{
        id = request.getParameter("id");
        nom = request.getParameter("nom");
    }
    catch(Exception s){
        s.printStackTrace();
    }               
%>

<div class = "container login lg">
    <form class="form-horizontal" action="goModifCategorie.jsp" method="POST">
	  <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="nom">nom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="nom" value="<%out.print(nom);%>">
		</div>
	  </div>            
            <input type="hidden" class="form-control" name="id" value="<%out.print(id);%>">		
	  <div class="form-group"> 
		<div class="col-sm-offset-3 col-sm-9">
		  <button type="submit" class="btn btn-default cnn" >modifier</button>
		</div>
	  </div>
    </form>
</div>
<jsp:include page="templates/footer.jsp" />