<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
<title>Quality one</title>
<%@ include file="meta.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<%
	    List<String> artifactList = new ArrayList<String>();
	    List<String> aggregateList = new ArrayList<String>();
	    File workspace = new File(System.getProperty("user.home") + File.separator + ".quality-one"
	            + File.separator + "workspace");
	    if (workspace.isDirectory())
	    {
	        for (File project : workspace.listFiles())
	        {
	            if (!project.isDirectory())
	            {
	                continue;
	            }
	            int firstIndex = project.getName().indexOf('$');
	            if (firstIndex == -1)
	            {
	                continue;
	            }

	            if ("aggregate".equalsIgnoreCase(project.getName().substring(0, firstIndex)))
	            {
	                aggregateList.add(project.getName().substring(project.getName().indexOf('$') + 1));
	                continue;
	            }

	            artifactList.add(project.getName().replace('$', ':'));
	        }
	    }
	%>

	<div id="wrap">
		<div class="container">
			<div class="row">
				<div class="span6">
					<h3>Projects</h3>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
						massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>
					
					<ul class="dropdown-menu">
						<%
							for (String title : artifactList) {
								String[] tokens = title.split(":");    
						%>
						<li><a>><%=tokens[0]%>  <%=tokens[1]%></a</li>
						<%
							}
						%>
					</ul>
					
					<table class="table">
						<%
							for (String title : artifactList) {
								String[] tokens = title.split(":");    
						%>
						<tr><td><%=tokens[0]%></td><td><%=tokens[1]%></td></tr>
						<%
							}
						%>
					</table>
					
					<p>
						<a class="btn btn-primary" href="#">Add project</a>
					</p>
				</div>
				<div class="span6">
					<h3>Aggregate violation change report</h3>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
						massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>
						
					<table>
						<%
							for (String title : aggregateList) {
						%>
						<tr><td><%=title%></td></tr>
						<%-- <li style="margin: 8px 0 8px 0"><a href="aggregate.jsp?Aggregate=<%=title%>"><%=title%></a></li> --%>
						<%
							}
						%>
					</table>
					
					<p>
						<a class="btn btn-primary" href="#">Add aggregate report</a>
					</p>
				</div>
			</div>
		</div>
		<div id="push"></div>
	</div>

	



	<%-- <div id="wrapper">
		<div id="box">
			<table>
				<tr>
					<td style="vertical-align: top;">
						<div class="panel">
							<div class="title">Violation change report</div>
							<div class="content">
								<ul>

									<%
										for (String title : artifactList) {
									%>
									<li style="margin: 5px 0 5px 0"><a
										href="query.jsp?KEE=<%=title%>"><%=title%></a></li>
									<%
										}
									%>
								</ul>
							</div>
						</div>
					</td>
					<td style="vertical-align: top;">
						<div class="panel">
							<div class="title">Aggregate violation change report</div>
							<div class="content">
								<ul>
									<%
										for (String title : aggregateList) {
									%>
									<li style="margin: 8px 0 8px 0"><a href="aggregate.jsp?Aggregate=<%=title%>"><%=title%></a></li>
									<%
										}
									%>

								</ul>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div> --%>
	<%@ include file="footer.jsp"%>
</body>
</html>