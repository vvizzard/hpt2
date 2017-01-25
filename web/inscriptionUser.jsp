<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<% 
    Login temp = new Login();
    String[] specialite = temp.getSpecialite();                    
%>

<div class = "container login lg">
    <form class="form-horizontal" action="goIns.jsp" method="POST">
	  <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="nom">nom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="nom" placeholder="entrer le nom du medecin ici">
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="prenom">prenom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="prenom" placeholder="entrer le prenom du medecin ici">
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="dateNaissance">date de naissance:</label>
		<div class="col-sm-9">
		  <input type="date" class="form-control" name="dateNaissance">
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="salaire">E-mail:</label>
		<div class="col-sm-9">
                    <input type="email" class="form-control" name="email" id="email" placeholder="entrer le votre email ici" onchange="checkEmail()" >
		</div>
                <script>
                    function checkEmail() {
                        var email = document.getElementById('email');
                        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                        if (!filter.test(email.value)) {
                            alert("votre adresse e-mail n'est pas valide");
                         //   email.focus;                         
                        return false;
                        }
                    }
                </script>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="specialité">mot de passe:</label>
		<div class="col-sm-9">
                    <input type="password" class="form-control" name="password" id="password" onchange="CheckPassword()" placeholder="entrer le mot de passe" >
		</div>
                <script>
                    function CheckPassword() { 
                        var pwd=document.getElementById('password');
                        var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;

                        if(!decimal.test(pwd.value)) 
                        {                            
                            alert('Votre mot de passe doit contenir une majuscule,un chiffre,un caractere special et doit contenir au moins 8 caracteres');
                            return false;
                        }
                    }
                </script>
	  </div>
	  <div class="form-group"> 
		<div class="col-sm-offset-3 col-sm-9">
		  <button type="submit" class="btn btn-default cnn" >inscrire</button>
		</div>
	  </div>
	</form>
</div>
<jsp:include page="templates/footer.jsp" />