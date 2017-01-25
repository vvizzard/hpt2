

<%
	String captcha =  session.getAttribute("dns_security_code").toString(); 
        out.print(captcha) ;        
	String answer = request.getParameter("answer");
	if (captcha.compareTo(answer)==0) {            
%>
<b>Correct Captcha Code !</b> <%
 	} else {
 %> <b>In Correct Captcha Code !</b> <%
 	}
 %>


