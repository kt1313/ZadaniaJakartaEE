<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="pl">
    <title>YT Player</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>YT PLAYER</h1>
<%
    String[] videos = request.getParameterValues("video");
    if (videos == null)
        out.println("<h2>Brak parametru video w adresie URL</h2>");
    else {
        for (String videoId: videos) {
%>

<iframe id="ytplayer" type="text/html" width="640" height="360"
        src="http://www.youtube.com/embed/<%=videoId%>" frameborder="0"></iframe>

<%
        }
    }
%>
</body>
</html>