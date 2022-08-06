<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/page/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
<script type="text/javascript">
	$.cookie('token', result.data, { expires: 7, path: '/' });
	String token = UUID.randomUUID().toString().replace("-", "");
	users.setToken(token);
	Calendar nowTime = Calendar.getInstance();
	nowTime.add(Calendar.MINUTE, 1);
	users.setLoginTime(nowTime.getTime());
	userService.updateUser(users);
	return ResultModel.success(token);


	$.cookie('token', result.data, { expires: 7, path: '/' });


	var goodsParam=$("#fr").serialize();
	$.param({"id":'${u.id}', "pageNo":pageNo, "rank":'${u.rank}',"parentId":'${u.parentId}'})+'&'+goodsParam,
	$.param({"pageNo":pageNo})+'&'+goodsParam,

//日期转换为数字格式
Date date = new Date(System.currentTimeMillis());
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
String str = simpleDateFormat.format(date);


@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date launchTime;

style="margin-top:100px" align="center" border="1" cellspacing="1"


	<!-- 时间控件格式 -->
<input type="text" name="launchTime" onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',skin:'YcloudRed',alwaysUseStartDate:true})" ><br>
<!--层显  -->
placeholder="请输入要查询的书名" 

		$("#fr").serialize(),
	parent.location.href="${ctx}/s/toShow";
	/*小弹窗  */
	function on(){
		layer.open({
			  type: 2, 
			  area: ['500px', '300px'],
			  title: ['修改商品信息', 'font-size:18px;'],
			  maxmin: true,
			  //跳页面
			  content: "${ctx}/s/toAdd",
			  //背景色变暗,随处点击关闭
			  shadeClose:false,
			});
	}
	//添加的回填
	function on(){
		layer.load();
		$.post("${ctx}/u/add",
				$("#fr").serialize(),
				function(result){
				layer.closeAll('loading');
					if(result.code != 200){
						layer.alert(result.msg, {
							  icon: 2,
							  skin: 'layui-layer-lan'
							})
							return;
					}
				layer.msg("添加成功,即将加载到首页",
						{time:1500},
						function(){
							parent.location.href="${ctx}/u/toShow";
				})
		});
	}

	//询问
	function add(){
		layer.confirm('是否进入新增页面',{
				btn:['是','否'],	
		},function(){
			  layer.close(layer.index);
			
		},function(){
			search();
		});
		
	}
	//判断
		if(result.code != 200){
			layer.alert(result.msg, {
				  icon: 2,
				  skin: 'layui-layer-lan'
				})
				return;
		}

	//窗口路劲统一化
	if(window.top.document.URL != document.URL){
		window.top.location= document.URL;
	}

	//加载层-默认风格
	layer.load();
	layer.closeAll('loading');
	//提示消息框
	layer.msg("请最少选择一个id进行修改");

	//
	map.put("code", -1);
	map.put("msg", "系统异常" + e.getMessage());
	map.put("data", null);
	return map;
	
	//
	map.put("code", -1);
	map.put("msg", "用户名或密码不能为空");
	map.put("data", null);
	
	//上下页 controller
	PageHelper.startPage(pageNo,2);
	PageInfo<ShopPojo> pageInfo = new PageInfo<ShopPojo>(list);
	Map<String, Object> maps = new HashMap<String, Object>();
	maps.put("list", list);
	maps.put("pages", pageInfo.getPages());
	map.put("data", maps);
	
	//上下页 框jsp页面
	<div id="dtb" align="center" ></div>
	htmlsq += "<input type='button'  value='上一页'  onclick='ud(true)'>";
	htmlsq += "<input type='button'  value='下一页'  onclick='ud(false,"+result.data.pages+")'>";
	$("#dtb").html(htmlsq);
	//分页
	function ud(b,pages){
		if(b){
			if(pageNo<2){
				layer.msg("首页");
				return;
			}
			--pageNo;
			layer.msg("第"+pageNo+"页");
		}else{
			if(pageNo == pages){
				layer.msg("尾页");
				return;
			}
			++pageNo;
			layer.msg("第"+pageNo+"页");
		}
		search(isDel,pageNo);
	}
	
	
	//批量删除修改
	function de(){
		var arr =[]
		$('input[name="tid"]:checked').each(function(){
			arr.push($(this).val());
		});
		if(arr.length == '0' ){
			layer.msg("请最少选择一个id进行删除");
			return;
		}
		
		$.post("${ctx}/s/updateIsDel",
				{"ids":arr,"isDel":2},
				function(result){
					search(isDel,pageNo);
		});
	}
	
	
	if(arr.length > 1 ){
		layer.msg("请选择一个id进行修改");
		return;
	}
	
	//全选	反选
	<th><input type="checkbox" name="allSel"></th>
	htmls += "<td><input type='checkbox' name='tid' value='"+b.id+"'></td>";
	//给“全选”设置点击事件
	$("[name='allSel']").click(function(){
			$(":checkbox[name='tid']").prop('checked',this.checked);
	});
	
	//修改回填复选框的值
	$(function(){
		//获得所要回显的值，此处为：100,1001,200,1400
		var checkeds = '${u.hobby}';
		//拆分为字符串数组
		var checkArray =checkeds.split(",");
		//获得所有的复选框对象
		var checkBoxAll = $("input[name='hobby']");
		//获得所有复选框（新闻,微信,论坛，问答，博客，平媒）的value值，然后，用checkArray中的值和他们比较，如果有，则说明该复选框被选中
		for(var i=0;i<checkArray.length;i++){
		    //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
		    $.each(checkBoxAll,function(j,checkbox){
		        //获取复选框的value属性
		        var checkValue=$(checkbox).val();
		        if(checkArray[i]==checkValue){
		            $(checkbox).attr("checked",true);
		        }
		    })
		}
	})
	
	</script>
</html>