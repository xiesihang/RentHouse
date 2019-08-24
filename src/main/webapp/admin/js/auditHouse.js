$(function(){
    //使用datagrid绑定数据库
    $('#dg').datagrid({
        url:'selectHouseAudit',
        title:"信息列表",
        toolbar: '#ToolBar',//工具栏
        iconCls: 'icon-search',//图标
        striped: true,//斑马线
        rownumbers: true,//显示行号
        pagination:true,
        pagesize:5,
        pageList:[3,5,10,20],
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'房屋编号',width:100},
            {field:'userName',title:'用户',width:100},
            {field:'title',title:'标题',width:100},
            {field:'type',title:'类型',width:100},
            {field:'district',title:'区域',width:100},
            {field:'street',title:'街道',width:100},
            {field:'price',title:'价格',width:100},
            {field:'pubdate',title:'房产日期',width:100,
                formatter:function (value,row,index) {
                    var pubdate=new Date(value)
                    return pubdate.toLocaleDateString()
                }},
            {field:'floorage',title:'面积',width:100},
            {field:'contact',title:'联系电话',width:100},
            {field:'description',title:'内容',width:100},
            {field:'operation',title:'操作',width:145,align:'center',
                formatter:function (value,row,index) {
                    return "<input type='button' value='通过审核' onclick='passAuditHouse("+row.id+")'/>"
                }}
        ]]
    });
});

function passAuditHouse(id) {
   $.post("passAuditHouse",{"id":id},function (data) {
       if(data>0){
           $.messager.alert('系统提示',"审核通过!",'info');
           $('#dg').datagrid('reload');
       }else{
           $.messager.alert('系统提示',"审核失败!",'error');
           $('#dg').datagrid('reload');
       }
   },"json")
}
$(function(){  //加载事件
    //发送异步请求获取类型，进行显示
    $.post("/admin/selectTypeAll",null,function (data) {
        for(var i=0;i<data.length;i++){
            //创建节点
            var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
            //追加节点
            $("#type").append(node);
        }
    },"json");
});



//加载所有区域
$(function(){  //加载事件
    //发送异步请求获取类型，进行显示
    $.post("selectDistrictAll",null,function (data) {
        for(var i=0;i<data.length;i++){
            //创建节点
            var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
            //追加节点
            $("#district").append(node);
        }
        loadStreet();
    },"json");
    //给区域添加改变事件
    $("#district").change(function () {
        loadStreet()
    });

    //加载街道
    function loadStreet() {
        //获取区域编号
        var id=$("#district").val();
        if(id!=""){
            //清空原有数据项
            $("#street>option:gt(0)").remove();
            $.post("selectStreetByDistrictId",{"id":id},function (data) {
                for(var i=0;i<data.length;i++){
                    //创建节点
                    var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                    //追加节点
                    $("#street").append(node);
                }
            },"json")
        }
    }
});

function search() {
    $("#dg").datagrid("load", {"title":$.trim($('#title').val()), "district":$.trim($('#district').val()),"street":$.trim($('#street').val()),"type":$.trim($('#type').val())})
}