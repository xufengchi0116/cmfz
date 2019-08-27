<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>

    <%--引入bootstrap的样式--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/boot/css/bootstrap.min.css">
    <%--引入bootstrap和jqgrid的整合样式--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">

    <%--引入js文件--%>
    <script src="${pageContext.request.contextPath}/statics/boot/js/jquery-2.2.1.min.js"></script>
    <%--引入bootstrap的js文件--%>
    <script src="${pageContext.request.contextPath}/statics/boot/js/bootstrap.min.js"></script>

    <%--引入jqgrid的js文件--%>
    <script src="${pageContext.request.contextPath}/statics/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script src="${pageContext.request.contextPath}/statics/jqgrid/js/ajaxfileupload.js"></script>

    <%--引入kindeditor的js文件--%>
    <script src="${pageContext.request.contextPath}/kindeditor/kindeditor-all-min.js"></script>
    <script src="${pageContext.request.contextPath}/kindeditor/lang/zh-CN.js"></script>

    <%--引入echarts的js文件--%>
    <script src="${pageContext.request.contextPath}/echarts/echarts.min.js"></script>
    <%--引入echarts的地图js文件--%>
    <script src="${pageContext.request.contextPath}/echarts/china.js"></script>

    <script>
        goEasy.subscribe({
            //当前的channel名称
            channel: "cmfz-article",
            onMessage: function (message) {
                alert("Channel:" + message.channel + " content:" + message.content);
            }
        });
    </script>

    <title>持明法洲后台管理系统</title>
</head>
<body>

<%--顶部导航条--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">持明法洲后台管理系统</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a>欢迎：${sessionScope.Admin.username}</a></li>
                <li><a href="${pageContext.request.contextPath}/Admin/exit">退出系统</a></li>
            </ul>
        </div>
    </div>
</nav>

<%--中间栅格系统--%>
<div class="row">
    <%--左侧--%>
    <div class="col-xs-2">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title text-center">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                           aria-expanded="true" aria-controls="collapseOne">
                            <h4>轮播图管理</h4>
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body text-center">
                        <a href="javascript:$('#right').load('${pageContext.request.contextPath}/banner/banner-show.jsp')"
                           class="btn btn-default">查询轮播图</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingTwo">
                    <h4 class="panel-title text-center">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            <h4>专辑管理</h4>
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="panel-body text-center">
                        <a href="javascript:$('#right').load('${pageContext.request.contextPath}/album/album-show.jsp')"
                           class="btn btn-default">查询专辑</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingThree">
                    <h4 class="panel-title text-center">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            <h4>文章管理</h4>
                        </a>
                    </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                    <div class="panel-body text-center">
                        <a href="javascript:$('#right').load('${pageContext.request.contextPath}/article/article-show.jsp')"
                           class="btn btn-default">查询文章</a>
                        <%--                        <br><br>
                                                <a href="javascript:$('#right').load('article/article-search.jsp')" class="btn btn-default">搜索文章</a>--%>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingFour">
                    <h4 class="panel-title text-center">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                           href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                            <h4>用户管理</h4>
                        </a>
                    </h4>
                </div>
                <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                    <div class="panel-body text-center">
                        <a href="javascript:$('#right').load('user/user-show.jsp')" class="btn btn-default">查询用户</a>
                        <br><br>
                        <a href="javascript:$('#right').load('user/user-line.jsp')" class="btn btn-default">用户注册趋势</a>
                        <br><br>
                        <a href="javascript:$('#right').load('user/user-map.jsp')" class="btn btn-default">用户地区分布</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--右侧--%>
    <div class="col-xs-10" id="right">
        <div class="jumbotron" style="padding-left: 80px">
            <h2>欢迎来到持明法洲后台管理系统!</h2>
        </div>
        <img src="${pageContext.request.contextPath}/img/shouye.jpg" style="width: 100%" alt="">
    </div>
</div>


<%--底部页脚--%>
<div class="panel panel-footer text-center">
    持明法洲后台管理系统@百知教育2019.8.14
</div>

</body>
</html>