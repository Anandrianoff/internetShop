<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:mainLayout title="Orders">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Order id</th>
            <th>User id</th>
            <th>Change status</th>
            <th>Products</th>
            <th>Current status</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${orders}" var="o">
                <tr>
                    <sf:form action="/admin/changeStatus" method="post" id="form${o.id}" modelAttribute="order">
                        <td>${o.id}</td>
                        <td>${o.user.id}</td>
                        <td><sf:select path="status" id="select${o.id}">
                            <sf:options items="${statuses}"></sf:options>
                        </sf:select></td>
                        <td><ol>
                            <c:forEach items="${o.productInOrders}" var="pio">
                                <li>${pio.product.name} - ${pio.product.price}$ X ${pio.amount}</li>
                            </c:forEach>
                        </ol></td>
                        <td><button onclick="change('${o.id}', '#status${o.id}' )">Save</button> </td>
                        <td>${o.status}</td>
                    </sf:form>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.js"></script>
    <script type="text/javascript">
        function change(order,status) {
            $.post('/admin/changeStatus', {'order':order, 'status':status })
        }
    </script>
</t:mainLayout>