<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="col-md-7 col-md-offset-1">
            <form method="post" action="RegistrationForm">
                <h2 class="text-center">Register</h2>
                <label>Name</label> <br>
                <div class="input-group">
                    <input type="text" aria-label="First name" class="form-control" placeholder="First Name" name="FirstName">
                    <input type="text" aria-label="Last name" class="form-control" placeholder="Last Name" name="LastName">
                </div>
                <div class="form-group">
                    <label>User name</label> <br>
                    <input class="form-control" type="text" name="UserName">
                </div>

                <div class="form-group">
                    <label>E-mail</label> <br>
                    <input class="form-control" type="text" name="Email">
                </div>

                <div class="form-group">
                    <label>Password</label> <br>
                    <input class="form-control" type="password" name="Password">
                </div>

                <div class="form-group">
                    <label>Facebook</label> <br>
                    <input class="form-control" type="text" name="Facebook">
                    <p class="fw-light">Enter your Facebook profile URL</p>
                </div>

                <div class="form-group">
                    <label>Short bio</label> <br>
                    <textarea class="form-control" name="ShortBio"></textarea>
                    <p class="fw-lighter">Share a little information about yourself</p>
                </div>

                <div class="form-group">
                    <button class="btn btn-primary" type="submit">Submit</button> <br>
                </div>
        </form>
        </div>
    </div>
</body>
</html>