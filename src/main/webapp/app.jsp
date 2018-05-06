<%@ page import="java.util.ArrayList" %>
<%@ page import="ua.kpi.tef.model.entities.ammunition.Ammunition" %>
<%@ page import="ua.kpi.tef.model.entities.knight.Knight" %>
<%@ page import="ua.kpi.tef.controller.bundlemanager.BundleManager" %>
<%@ page import="ua.kpi.tef.BundlesKeys" %>
<%@ page import="ua.kpi.tef.TextConstants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script defer src="view/js/index.js"></script>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<Ammunition> ammunition = (ArrayList<Ammunition>) request.getAttribute(TextConstants.AMMUNITION);
    Knight knight = (Knight) request.getAttribute(TextConstants.KNIGHT_OBJECT);
    BundleManager manager = new BundleManager();
%>
<h1><%=manager.getString(BundlesKeys.WELCOME)%></h1>
<div id="languages">
    <div data-language="uk" class="lang">Українська</div>
    <div data-language="en" class="lang">English</div>
</div>
<br>
<div class="item-container">
    <% for (Ammunition item : ammunition) { %>
    <div class="item"
         data-type="<%=item.getClass().getSimpleName()%>"
         data-name="<%=item.getName()%>"
         data-weight="<%=item.getWeight()%>"
         data-price="<%=item.getPrice()%>"
    >
        <%=manager.getString(BundlesKeys.TYPE)%>: <%=manager.getString(item.getClass().getSimpleName().toLowerCase())%><br>
        <%=manager.getString(BundlesKeys.NAME)%>: <%=item.getName()%><br>
        <%=manager.getString(BundlesKeys.PRICE)%>: <%=item.getPrice()%><br>
        <%=manager.getString(BundlesKeys.WEIGHT)%>: <%=item.getWeight()%><br>
    </div>
    <br>
    <% } %>
</div>
<br/>
<div class="knight">
    <div>
        <%=manager.getString(BundlesKeys.HELMET)%>:
        <% Ammunition item = knight.getHelmet();%>
        <%@include file="item.jsp"%>
    </div>
    <div>
        <%=manager.getString(BundlesKeys.CHESTPLATE)%>:
        <% item = knight.getChestplate();%>
        <%@include file="item.jsp"%>
    </div>
    <div>
        <%=manager.getString(BundlesKeys.LEGGINS)%>:
        <%  item = knight.getLeggins();%>
        <%@include file="item.jsp"%>
    </div>
    <div>
        <%=manager.getString(BundlesKeys.BOOTS)%>:
        <%  item = knight.getBoots();%>
        <%@include file="item.jsp"%>
    </div>
    <div>
        <%=manager.getString(BundlesKeys.WEAPON)%>:
        <%  item = knight.getWeapon();%>
        <%@include file="item.jsp"%>
    </div>
    <div>
        <%=manager.getString(BundlesKeys.SHIELD)%>:
        <%  item = knight.getShield();%>
        <%@include file="item.jsp"%>
    </div>
</div>
<br/>
<div class="overall-price">
    <%=manager.getString(BundlesKeys.OVERALL_PRICE)%>: <%=knight.getOverallPrice()%>
</div>
<br/>
<form id="filter" method="POST" action="app">
    <input type="number" name="lower" value='<%=request.getAttribute("lower")%>'>
    <input type="number" name="upper" value='<%=request.getAttribute("upper")%>'>
    <button type="submit">Submit</button>
</form>
<% if (request.getAttribute(TextConstants.FILTER_ERROR) != null) { %>
<div style="color: red">
    <%=request.getAttribute(TextConstants.FILTER_ERROR)%>
</div>
<% } %>
<% if (request.getAttribute(TextConstants.EQUIP_ERROR) != null) { %>
<div style="color: red">
    <%=request.getAttribute(TextConstants.EQUIP_ERROR)%>
</div>
<% } %>
</div>
</body>
</html>
