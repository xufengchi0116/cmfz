<%@page pageEncoding="UTF-8" isELIgnored="false" %>


<script>

    $("#user-table").jqGrid({
        url: "${pageContext.request.contextPath}/user/selectuser",
        datatype: "json",
        colNames: ['编号', '电话', '用户', '法号', '省份', "城市", "签名", "照片", "性别", "创建时间"],
        colModel: [
            {name: 'id', hidden: true},
            {name: 'phone', editable: true},
            {name: 'username', editable: true},
            {name: 'dharma', editable: true},
            {name: 'province', editable: true},
            {name: 'city', editable: true},
            {name: 'sign', editable: true},
            {
                name: 'photo', editable: true, edittype: "file", formatter: function (value, option, rows) {
                    return "<img style='width:90%;height:10%;' src='${pageContext.request.contextPath}/img/" + rows.photo + "'/>";
                }
            },
            {name: 'sex', editable: true},
            {name: 'createDate'}
            /* {name : 'aa',formatter:function (value,options,row) {
                     return "<a class='btn btn-warning' onclick=\"openModal('edit','"+row.id+"')\">修改</a>";
                 }}*/
        ],
        styleUI: "Bootstrap",
        autowidth: true,
        height: "300px",
        rowNum: 3,
        rowList: [3, 5, 10],
        pager: '#user-pager',
        viewrecords: true,
        caption: "文章的详细信息",
        editurl: "${pageContext.request.contextPath}/article/edit"
    }).navGrid("#user-pager", {edit: false, add: false, del: false, search: false});


    function out() {
        window.location.href = "${pageContext.request.contextPath}/user/out";
    }
</script>


<div>
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">所有用户</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" onclick="out()">导出所有用户信息</a>
        </li>
    </ul>
</div>
<table id="user-table"></table>
<div id="user-pager" style="height: 40px"></div>