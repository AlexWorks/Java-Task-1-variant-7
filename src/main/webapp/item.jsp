<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% if (item == null) { %>
<div class="empty-place"><%=manager.getString(BundlesKeys.EMPTY)%></div>
<% } else { %>

<div><%=manager.getString(BundlesKeys.NAME)%>: <%=item.getName()%>
</div>
<div><%=manager.getString(BundlesKeys.PRICE)%>: <%=item.getPrice()%>
</div>
<div><%=manager.getString(BundlesKeys.WEIGHT)%>: <%=item.getWeight()%>
</div>

<% } %>