$(function(){
    //使用datagrid绑定数据库
    $('#dg').datagrid({
        url:'selectType',
        title:"信息列表",
        iconCls: 'icon-search',//图标
        toolbar: '#ToolBar',//工具栏
        striped: true,//斑马线
        rownumbers: true,//显示行号
        pagination:true,
        pagesize:5,
        pageList:[3,5,10,20],
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'类型编号',width:100},
            {field:'name',title:'类型名称',width:100},
            {field:'operation',title:'操作',width:100,align:'center',
                formatter:function (value,row,index) {
                    return "<input type='button' value='删除' onclick='deleteOne("+row.id+")'/> "+ "&nbsp;<input type='button' value='修改' onclick='dialogs(\"updateType\",\"修改类型\")'/>"
                }}
        ]]
    });
});

<!--打开对话框-->
function dialogs(id,title) {
    if(id==="insertType"){
        $("#"+id).dialog("open").dialog("setTitle",title)
    }
    if(id==="updateType"){
        //获取选中的行
        var SelectRows = $("#dg").datagrid('getSelections');
        if(SelectRows.length != 1){
            $.messager.alert("系统提示", "只允许选择一行需要编辑的数据","info");
            return;
        }else{
            $("#"+id).dialog("open").dialog("setTitle",title)
            //获取选中的修改行
            var row=SelectRows[0]
            $.post("selectOneType",{"id":row.id},function (data) {
                //将数据回显到表单中
                $('#updatefrom').form('load',data)
            },"json")
        }
    }
    if(id==="deleteType"){
        //获取选中的行
        var SelectRows = $("#dg").datagrid('getSelections');
        if(SelectRows.length == 0){
            $.messager.alert("系统提示", "至少选择一行需要删除的数据","info");
            return;
        }else{
            deleteBatch(SelectRows);
        }
    }
}

<!-- 取消——>关闭对话框 -->
function cancel(id){
    $("#"+id).dialog("close")
}

<!-- 保存(更新)——>控制层——>service——>dao -->
function save(id,url) {
    <!-- 使用easyui提交表单 -->
    $('#'+id).form('submit', {
        url:url,   /*自动映射参数*/
        success:function(data){
            if(id==="insertfrom"){
                if(data==1){
                    $.messager.alert('系统提示',"添加成功",'info');
                    $('#dg').datagrid('reload');
                    $("#"+url).dialog("close")
                }else{
                    $.messager.alert('系统提示',"添加失败",'error');
                    $("#"+url).dialog("close")
                }
            }
            if(id==="updatefrom"){
                if(data==1){
                    $.messager.alert('系统提示',"修改成功",'info');
                    $('#dg').datagrid('reload');
                    $("#"+url).dialog("close")
                }else{
                    $.messager.alert('系统提示',"修改失败",'error');
                    $("#"+url).dialog("close")
                }
            }
        }
    });
}

<!-- 删除单条 -->
function deleteOne(id){
    $.messager.confirm('系统提示', '确定删除吗?', function(r){
        if (r){
            $.post("deleteTypeOne",{"id":id},function (data) {
                if(data==1){
                    $.messager.alert('系统提示',"删除成功",'info');
                    $('#dg').datagrid('reload');
                }else{
                    $.messager.alert('系统提示',"删除失败",'error');
                }
            },"json")
        }
    });
}
<!-- 删除多条 -->
function deleteBatch(SelectRows){
    $.messager.confirm("系统提示", "确定要删除<font color=red> " + SelectRows.length + " </font>条数据吗?", function(r){
        if (r){
            var ids="";
            for(var i=0;i<SelectRows.length;i++){
                var ids=ids+SelectRows[i].id+","
            }
            ids=ids.substring(0,ids.length-1);//去除最后的逗号
            $.post("deleteTypeBatch",{"ids":ids},function (data) {
                if(data==1){
                    $.messager.alert('系统提示',"删除成功",'info');
                    $('#dg').datagrid('reload');
                }else{
                    $.messager.alert('系统提示',"删除失败",'error');
                }
            },"json")
        }
    });
}