<%@ page import="java.util.ArrayList" %>
<%@ page import="ua.kpi.tef.model.entities.ammunition.Ammunition" %>
<%@ page import="ua.kpi.tef.model.entities.Knight" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script defer src="view/js/index.js"></script>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<Ammunition> ammunition = (ArrayList<Ammunition>) request.getAttribute("ammunition");
    Knight knight = (Knight) request.getAttribute("knight");
%>
<h1>Welcome to App!</h1>
<div class="item-container">
    <% for (Ammunition item : ammunition) { %>
    <div class="item"
         data-type="<%=item.getClass().getSimpleName()%>"
         data-name="<%=item.getName()%>"
         data-weight="<%=item.getWeight()%>"
         data-price="<%=item.getPrice()%>"
    >
        <%=item.getName()%>
    </div>
    <% } %>
</div>
<br/>
<div class="knight">
    <div>
        Helmet: <%=knight.getHelmet() == null ? "empty" : knight.getHelmet()%>
    </div>
    <div>
        Chestplate: <%=knight.getChestplate() == null ? "empty" : knight.getChestplate()%>
    </div>
    <div>
        Leggins: <%=knight.getLeggins() == null ? "empty" : knight.getLeggins()%>
    </div>
    <div>
        Boots: <%=knight.getBoots() == null ? "empty" : knight.getBoots()%>
    </div>
    <div>
        Weapon: <%=knight.getBoots() == null ? "empty" : knight.getWeapon()%>
    </div>
    <div>
        Shield: <%=knight.getBoots() == null ? "empty" : knight.getShield()%>
    </div>
</div>
<br/>
<div class="overall-price">
    Overall price: <%=knight.getOverallPrice()%>
</div>
<br/>
<form id="filter" method="POST" action="app">
    <input type="number" name="lower" value='<%=request.getAttribute("lower")%>'>
    <input type="number" name="upper" value='<%=request.getAttribute("upper")%>'>
    <button type="submit">Submit</button>
</form>
</body>
</html>
