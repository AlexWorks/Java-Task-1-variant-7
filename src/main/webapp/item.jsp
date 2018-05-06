<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% if (item == null )  { %>
<%=manager.getString(BundlesKeys.EMPTY)%>
<% } else { %>
<br>
<%=manager.getString(BundlesKeys.NAME)%>: <%=item.getName()%><br>
<%=manager.getString(BundlesKeys.PRICE)%>: <%=item.getPrice()%><br>
<%=manager.getString(BundlesKeys.WEIGHT)%>: <%=item.getWeight()%><br>
<br>
<% } %>