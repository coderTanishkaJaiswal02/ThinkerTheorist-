<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   
 <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500;600&family=Pacifico&display=swap" rel="stylesheet">
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 
    <style>
        h2 {
            color: aliceblue;
            background-color: rgb(0, 62, 62);
        }
        
        fieldset {
            background-color: rgb(179, 220, 217);
            border-radius: 1px;
        }
        
        body {
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
            font-size: 15px;
        }
    </style>
</head>
<body>
	<header>
		<h1 align="center">Thinker Theoriest</h1>
	</header>
	
         <h2 style="color: aliceblue; background-color: rgb(0, 62, 62); " align="center ">Welcome <%=request.getAttribute("uname")%>!!</h2>
     <%
      if(null!=request.getAttribute("msg")){
  	%>
       <h3 style="color: black; background-color:1BF2C4; " align="center "><%=request.getAttribute("msg")%>!!</h3>
    <%} %>
   <div id="AddForm">
		<form action="<%=request.getContextPath()%>/addBlogs" method="POST">
			<input type="hidden" name="uId"
				value="<%=request.getAttribute("uId")%>" />
			<input type="hidden" name="uname"
				value="<%=request.getAttribute("uname")%>" />	
			<p>
				<div class="form-group">
  				<label for="comment">Add Blogs:</label>
 			    <textarea class="form-control" rows="5" id="comment" name="comment"></textarea>
			</div>
			</p>
			<p align="center">
				<button type="submit">Save</button>
			</p>
			
		</form>
	</div>
	
	   <%
      if(null!=request.getAttribute("blogs")){
    	  String[]  blogs = (String[])session.getAttribute("blogs");
  		%>
			<div id = "blogs">
				<div class="card text-white bg-info mb-3">
					<div class="card-header">My Blogs</div>
						<%for(String b: blogs){%>
							<div class="card-body">
								<blockquote class="blockquote mb-0">
										<p><%=b%></p>
									<footer class="blockquote-footer">
										<%=request.getAttribute("uname")%>
									</footer>
								</blockquote>
							</div>
						<%} %>
				</div>
			</div>
	<%
	}
	%>
		
	
		
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>