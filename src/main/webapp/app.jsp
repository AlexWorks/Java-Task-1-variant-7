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
    <link rel="stylesheet" href="view/css/styles.css">
    <title>Title</title>
</head>
<body>
<%
    ArrayList<Ammunition> ammunition = (ArrayList<Ammunition>) request.getAttribute(TextConstants.AMMUNITION);
    Knight knight = (Knight) request.getAttribute(TextConstants.KNIGHT_OBJECT);
    BundleManager manager = new BundleManager();
%>
<div class="header">
    <h1><%=manager.getString(BundlesKeys.WELCOME)%></h1>
    <div id="languages">
        <div data-language="uk" class="lang"></div>
        <div data-language="en" class="lang"></div>
    </div>
</div>
<br>
<div class="app-container">
    <div class="knight">
        <div class="equipment-container">
            <div class="equipment">
                <div class="info-wrapper">
                <% Ammunition item = knight.getHelmet();%>
                    <img class="ammunition-icon" src="./view/images/Helmet.png">
                <%@include file="item.jsp"%>
                </div>
            </div>
            <div class="equipment">
                <div class="info-wrapper">
                <% item = knight.getChestplate();%>
                    <img class="ammunition-icon" src="./view/images/Chestplate.png">
                <%@include file="item.jsp"%>
                </div>
            </div>
            <div class="equipment">
                <div class="info-wrapper">
                <%  item = knight.getLeggings();%>
                    <img class="ammunition-icon" src="./view/images/Leggings.png">
                <%@include file="item.jsp"%>
                </div>
            </div>
            <div class="equipment">
                <div class="info-wrapper">
                <%  item = knight.getBoots();%>
                    <img class="ammunition-icon" src="./view/images/Boots.png">
                <%@include file="item.jsp"%>
                </div>
            </div>
            <div class="equipment">
                <div class="info-wrapper">
                <%  item = knight.getWeapon();%>
                    <img class="ammunition-icon" src="./view/images/Weapon.png">
                <%@include file="item.jsp"%>
                </div>
            </div>
            <div class="equipment">
                <div class="info-wrapper">
                <%  item = knight.getShield();%>
                    <img class="ammunition-icon" src="./view/images/Shield.png">
                <%@include file="item.jsp"%>
                </div>
            </div>
        </div>
        <div class="overall-price">
            <%=manager.getString(BundlesKeys.OVERALL_PRICE)%>: <%=knight.getOverallPrice()%>
        </div>
    </div>
    <div class="items">
        <div class="item-container">
            <% for (Ammunition value : ammunition) { %>
            <div class="item"
                 data-type="<%=value.getClass().getSimpleName()%>"
                 data-name="<%=value.getName()%>"
                 data-weight="<%=value.getWeight()%>"
                 data-price="<%=value.getPrice()%>"
            >
                <img class="ammunition-icon" src="<%="/view/images/" + value.getClass().getSimpleName() + ".png"%> ">
                <div class="info-wrapper">
                    <div class="info"><%=manager.getString(BundlesKeys.NAME)%>: <%=value.getName()%></div>
                    <div class="info"><%=manager.getString(BundlesKeys.PRICE)%>: <%=value.getPrice()%></div>
                    <div class="info"><%=manager.getString(BundlesKeys.WEIGHT)%>: <%=value.getWeight()%></div>
                </div>
            </div>
            <% } %>
        </div>
        <form id="filter" method="POST" action="app">
            <div class="input-wrapper">
                <div class="input-info"><%=manager.getString(BundlesKeys.PRICE_DIAPASON)%></div>
                <input type="text" name="lower" value='<%=request.getAttribute("lower")%>'>
                <div class="dash">-</div>
                <input type="text" name="upper" value='<%=request.getAttribute("upper")%>'>
                <button type="submit"><%=manager.getString(BundlesKeys.SUBMIT)%></button>
            </div>

        </form>
    </div>
</div>
<div class="error-messages">
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
