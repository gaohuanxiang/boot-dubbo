<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/page/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tbody id="tb"></tbody>
	</table>
</body>
<script type="text/javascript">
	var pageNo = 1;
	$(function(){
		search(pageNo);
	});
	function search(pageNo){
		$.post("${ctx}/shop/show",
				{"pageNo":pageNo},
				function(result){
					//console.log(result);
					if(result.code != 200){
						layer.alert(result.msg, {
							  icon: 2,
							  skin: 'layui-layer-lan'
							})
							return;
				}
			htmls = "";
			htmlsq = "";
			for (var i = 0; i < result.data.list.length; i++) {
				var s = result.data.list[i];
				htmls += "<tr>";
				htmls += "<td>"+s.+"</td>";
				htmls += "<td>"+s.+"</td>";
				htmls += "<td>"+s.+"</td>";
				htmls += "</tr>";
			}
			$("#tb").html(htmls);
			htmlsq += "<input type='button'  value='上一页'  onclick='ud(true)'>";
			htmlsq += "<input type='button'  value='下一页'  onclick='ud(false,"+result.data.pages+")'>";
			$("#div").html(htmlsq);
		});
		
	}

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
		search(pageNo);
	}

	//修改
	function up(re){
		layer.open({
			type: 2,
			area: ['500px', '300px'],
			title: ['修改商品信息', 'font-size:18px;'],
			maxmin: true,
			//跳页面
			content: "${ctx}/u/toUpdate/"+re,
			//背景色变暗,随处点击关闭
			shadeClose:false,
		});
	}
	//删除
	function de(id){
		$.post("${ctx}/u/daleteUser",
				{"id":id},
				function (result){
					if(result.code !== 200){
						layer.alert(result.msg, {
							icon: 2,
							skin: 'layui-layer-lan'
						})
						return;
					}
					layer.msg("删除成功,即将加载到首页",
							{time:1500},
							function(){
								search(1);
							})
				});
	}

</script>
</html>