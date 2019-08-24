<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script src="js/users.js"></script>
</head>
<body style="width: 100%;height: 100%">
<!--显示所有区域-->
<table id="dg"></table>
<!--工具栏-->
<div id="ToolBar">
    <div style="height: 25px;">
        <a href="javascript:dialogs('insertUsers','添加用户')" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:dialogs('updateUsers','修改用户')" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:dialogs('deleteUsers','删除用户')" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">多项删除</a>
    </div>
    <div style ="padding-left:10px;padding-bottom:10px;">
        姓名（可以模糊查询）：<input id ="name" name ="name" type ="text" class="textbox" style ="width:130px;" />&emsp;
        号码（可以模糊查询）：<input id ="telephone" name ="telephone" type ="text" class="textbox" style ="width:130px;" />
        <a id ="search" href ="javascript:search()" class="easyui-linkbutton" data-options="iconCls:'icon-search'," style ="margin-left:20px; padding:0 10px 0 10px;">查询</a>
    </div>
</div>
<!--添加用户信息的对话框-->
<div id="insertUsers" class="easyui-dialog" buttons="#insertbuttons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="insertfrom" method="post"><!--新增表单-->
        <table>
            <tr>
                <td>用户名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name"  /></td>
            </tr>
            <tr>
                <td>用户号码:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="telephone"  /></td>
            </tr>
        </table>
    </form>
</div>
<div id="insertbuttons">  <!--绑定按钮-->
    <a href="javascript:save('insertfrom','insertUsers')" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:cancel('insertUsers')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<!--修改用户信息的对话框-->
<div id="updateUsers" class="easyui-dialog" buttons="#updatebuttons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="updatefrom" method="post"><!--修改表单-->
        <table>
            <tr>
                <td>用户编号:</td>
                <td><input type="text" style="border: none" readonly class="easyui-validatebox" required
                           name="id" /></td>
            </tr>
            <tr>
                <td>用户名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" /></td>
            </tr>
            <tr>
                <td>用户号码:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="telephone" /></td>
            </tr>
        </table>
    </form>
</div>
<div id="updatebuttons">  <!--绑定按钮-->
    <a href="javascript:save('updatefrom','updateUsers')" class="easyui-linkbutton" iconCls="icon-ok">更新</a>
    <a href="javascript:cancel('updateUsers')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
