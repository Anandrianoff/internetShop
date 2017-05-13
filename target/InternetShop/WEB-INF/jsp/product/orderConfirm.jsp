<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:mainLayout title="Confirm your order">
    <c:forEach items="${c}" var="con">
        <sf:form action="/remove_product" method="post">
            <input type="hidden" value="${con.id}" id="id" name="id">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <h3>${con.name}</h3>
                        <h4>${con.cost}$ X ${con.amount}</h4>
                    </div>
                    <div class="col-md-4">
                        <button type="submit">Delete</button>
                    </div>
                </div>
            </div>
        </sf:form>
        <hr>
    </c:forEach>

    <a href="/order_confirmed">Ok</a>
</t:mainLayout>