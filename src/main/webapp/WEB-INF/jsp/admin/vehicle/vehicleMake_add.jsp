<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>
<script>
    $(document).ready(function(){
        $("#successAlert").delay(8000).fadeOut(2000);
        $("#warningAlert").delay(10000).fadeOut(2000);
    });
</script>


<div class="wrapper">

    <%--Sidebar--%>
    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/make/add" method="post">
                <fieldset>
                    <legend>Vehicle Make</legend>
                    <div class="form-group">
                        <label for="inputNewVehicleMake" class="col-lg-2 control-label">Make</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleMake" type="text" cssClass="form-control" id="inputNewVehicleMake" placeholder="Vehicle Make"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>
        <div class="col-sm-4">
            <%--Alert--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <%--Success--%>
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Vehicle Make added successfully to the database!</strong>YEAH!! <a href="#" class="alert-link">YES!!</a>.
                </div>
            </div>
            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <%--Warning--%>
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>All fields required. Please enter a Vehicle Make</a>.</p>
                </div>
            </div>
            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
                <%--Error--%>
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="../../includes/footer.jsp" %>