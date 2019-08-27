<%--
  Created by IntelliJ IDEA.
  User: 徐奉驰
  Date: 2019/8/15
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>

<script>

    $(function () {


        $("#banner-table").jqGrid({
            url: "/cmfz/banner/FindAll",
            datatype: "json",
            colNames: ['编号', '名称', '图片', '描述', '状态', '创建时间'],
            colModel: [
                {name: 'id', hidden: true},
                {name: 'name', editable: true},
                {
                    name: 'cover', editable: true, edittype: "file", formatter: function (value, option, rows) {
                        return "<img style='width:50%;height:12%;' src='${pageContext.request.contextPath}/img/" + rows.cover + "'/>";
                    }
                },
                {name: 'description', editable: true},
                {name: 'status', editable: true, edittype: "select", editoptions: {value: "正常:正常;冻结:冻结"}},
                {name: 'create_date'}
            ],
            //cellEdit:true,
            styleUI: "Bootstrap",
            autowidth: true,
            height: "300px",
            rowNum: 3,
            rowList: [3, 5, 10],
            pager: '#banner-pager',
            viewrecords: true,
            caption: "轮播图的详细信息",
            editurl: "${pageContext.request.contextPath}/banner/edit"
        }).navGrid("#banner-pager", {edit: true, add: true, del: true, search: false}, {
            //控制修改
            closeAfterEdit: close,
            beforeShowForm: function (obj) {
                obj.find("#cover").attr("disabled", true);
            }
        }, {
            //控制添加
            //关闭添加对话框
            closeAfterAdd: close,
            afterSubmit: function (response) {
                var status = response.responseJSON.status;
                var id = response.responseJSON.message;
                if (status) {
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/banner/upload",
                        fileElementId: "cover",
                        data: {id: id},
                        type: "post",
                        success: function () {
                            $("#banner-table").trigger("reloadGrid");
                        }
                    });
                }
                return "123";
            }
        }, {
            //控制删除
        });
    })
</script>


<div class="page-header">
    <h2>展示所有的轮播图</h2>
</div>
<table id="banner-table"></table>
<div id="banner-pager" style="height: 40px"></div>