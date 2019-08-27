<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" pageEncoding="UTF-8" %>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Login Form Template</title>
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/form-elements.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/style.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/login/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="${pageContext.request.contextPath}/login/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="${pageContext.request.contextPath}/login/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="${pageContext.request.contextPath}/login/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed"
          href="${pageContext.request.contextPath}/login/assets/ico/apple-touch-icon-57-precomposed.png">
    <script src="${pageContext.request.contextPath}/boot/js/jquery-2.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/assets/js/jquery.backstretch.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/assets/js/scripts.js"></script>
    <script src="${pageContext.request.contextPath}/boot/js/jquery.validate.min.js"></script>
    <script>
        $(function () {

            /*           /!*用户名验证*!/
                        $("#form-username").blur(function () {
                            var op1 = $("#form-username").val();
                            if (op1 == "") {
                                $("#username1").html("<b><font color='red'>不能为空 X </font><b/>");
                            } else {
                                $("#username1").html("<b><font color='green'>用户名通过 √ </font><b/>");
                            }
                        })*/


            /*  /!*密码验证*!/
              $("#form-password").blur(function () {
                  var ps1 = $("#form-password").val();
                  if (ps1 == "") {
                      $("#password1").html("<b><font color='red'>密码不能为空 X </font><b/>");
                  } else {
                      $("#password1").html("<b><font color='green'>密码通过 √ </font><b/>");

                  }
              })*/

            $.extend($.validator.messages, {
                required: "<span style='color: red'>这是必填字段</span>"
            })

            $("#loginButtonId").click(function () {

                var flag = $("#loginForm").valid();
                if (flag) {

                    $.ajax({
                        url: "${pageContext.request.contextPath}/Admin/index",
                        datatype: "json",
                        data: $("#loginForm").serialize(),
                        type: "post",
                        success: function (data) {
                            if (data.msg == "success") {
                                location.href = "${pageContext.request.contextPath}/index.jsp";
                            }/*else{
                               window.location.reload();
                           }*/
                            else {
                                $("#msgDiv").html(data.msg);
                                $("#captchaImage").prop('src', '${pageContext.request.contextPath}/captcha/createCaptcha?' + new Date());
                            }
                        }
                    })

                }
            })
        })

        //验证码
        function changeCaptcha() {
            var cp = document.getElementById('captchaImage');
            cp.src = '${pageContext.request.contextPath}/captcha/createCaptcha?' + new Date();
        }
    </script>
</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>CMFZ</strong> Login Form</h1>
                    <div class="description">
                        <p>
                            <a href="#"><strong>CMFZ</strong></a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top" style="width: 450px">
                        <div class="form-top-left">
                            <h3>Login to showall</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom" style="width: 450px">
                        <form role="form" action="" method="post" class="login-form" id="loginForm">
                            <span style="color: red" id="msgDiv"></span>
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="username" placeholder="请输入用户名..."
                                       class="form-username form-control" required id="form-username">
                                <span id="username1"></span>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="请输入密码..."
                                       class="form-password form-control" required id="form-password">
                                <span id="password1"></span>
                            </div>
                            <div class="form-group">
                                <img id="captchaImage" style="height: 48px" class="captchaImage"
                                     src="${pageContext.request.contextPath}/captcha/createCaptcha"
                                     onclick="changeCaptcha()">
                                <input style="width: 286px;height: 50px;border:3px solid #ddd;border-radius: 4px;"
                                       type="test" name="captcha" id="form-code">
                            </div>
                            <input type="button" style="width: 400px;border:1px solid #9d9d9d;border-radius: 4px;"
                                   id="loginButtonId" value="登录">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


</body>

</html>