//点击li的时候，展开li下面的div

function liClick(elm){
	$(elm +" li").on("click", function(event) {
				//取消冒泡
		event = event || window.event;
		if(event && event.stopPropagation) {
			event.stopPropagation();
		} else {
			event.cancelBubble = true;
		}
		if($(this).children("ul").css("display") == "block") {
			$(this).children("div").children("i").removeClass("icon-shangxiajiantou").addClass("icon-shangxiajiantou1");
		} else {
			$(this).children("div").addClass("panel_this").parent().parent().siblings('ul').children().children().removeClass("panel_this");
			$(this).children("div").children("i").removeClass("icon-shangxiajiantou1").addClass("icon-shangxiajiantou");
		}
		$(this).children("ul").slideToggle();
	})
}
			
			//遍历一级菜单
			function forEachNav(data) {
				var ulHtml = '';
				var liH = '';
				var ihtml = '';
				for(var i = 0, len = data.length; i < len; i++) {
					if(data[i].id == "m1") {
						ihtml = '<i class="iconfont icon-shangxiajiantou icon_img"></i>';
					} else {
						ihtml = '<i class="iconfont icon-shangxiajiantou1 icon_img"></i>'
					}

					if(data[i].children.length > 0) {
						liH = childNav(data[i].children,"m1");

						ulHtml = '<ul style="display: block;">'
										+'<li class="panel_li ">'
											+'<div class="panel_title font_dan">'+data[i].text+ihtml+'</div>'
											+liH
										+'</li>'
									+'</ul>';
					} else {
						ulHtml = '<ul>'
								+'<li class="panel_li">'
									+'<div class="panel_title font_dan">'+data[i].text+'</div>'
								+'</li>'
							+'</ul>';
					}

					$(".panel_box").append(ulHtml);
				}

			}

			////遍历子级菜单
			function childNav(data, id) {
				var childH = '';
				var liHtml = "";
				var ulH = "";
				var iHtml = "";
				var disp = "";
				for(var i = 0, len = data.length; i < len; i++) {
					if(data[i].parentId == id) {
						iHtml = '<i class="iconfont icon-shangxiajiantou icon_img"></i>';
						disp = "block";
					} else {
						iHtml = '<i class="iconfont icon-shangxiajiantou1 icon_img"></i>';
						disp = "none";
					}

					if(data[i].children.length > 0) {

						childH = childNav(data[i].children, id);
						liHtml += '<li class="panel_li">'
										+'<div class="panel_title font_dan">'+data[i].text+iHtml+'</div>'
										+childH
									+'</li>';

						ulH += '<ul style="display:'+disp+';">'
								+liHtml
							+'</ul>';

					} else {

						ulH += '<ul style="display:'+disp+';">'
								+'<li class="panel_li">'
									+'<div class="panel_title font_dan">'+data[i].text+'</div>'
								+'</li>'
							+'</ul>';
					}
				}

				return ulH;
			}

	