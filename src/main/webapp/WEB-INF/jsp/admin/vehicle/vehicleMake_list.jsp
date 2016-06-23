<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%--Sidebar--%>
    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">
            <%--List of Existing elements--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Make</th>
                    <th></th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                    <tr>
                        <td>${vehicleMake.id}</td>
                        <td>${vehicleMake.vehicleMakeName}</td>
                        <td>Click edit to add/edit models</td>
                        <td><a href="/admin/vehicle/make/edit/${vehicleMake.id}">Edit</a></td>
                        <td><a href="/admin/vehicle/make/delete/${vehicleMake.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>