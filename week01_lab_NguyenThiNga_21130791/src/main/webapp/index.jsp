<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%--<jsp:include page="./common/header.jsp"></jsp:include>--%>
  <div class="container col-md-5 col-md-offset-3" style="overflow: auto">
    <h1 style="text-align: center">Login Form</h1>
    <form action="controller" method="get">
      <input type="hidden" name="action" value="login"/>
      <div class="form-group">
        <label>Account ID:</label> <input type="text" class="form-control" id="accountId" placeholder="Account ID" name="accountId" required>
      </div>

      <div class="form-group">
        <label>Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
      </div>

      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
<%--<jsp:include page="./common/footer.jsp"></jsp:include>--%>

</body>
</html>