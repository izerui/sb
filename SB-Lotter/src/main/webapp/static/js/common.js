var pageSize = 10;

function getPageInfo(start, total) {
	var pageInfo = '';
	var pageCount = Math.ceil(total / 10);
	if (start > 1) {
		pageInfo += '<li class="prev"><a style="height:29.2px;" href="javascript:void(0)" onClick="getData('
				+ (start - 1)
				+ ')"><i class="icon-double-angle-left"></i></a></li>';
	} else {
		pageInfo += '<li class="prev disabled"><a style="height:29.2px;" href="javascript:void(0)"><i class="icon-double-angle-left"></i></a></li>';
	}
	var index = 1;
	if (start - 2 > 0) {
		index = start - 2;
	} else {
		index = 1;
	}
	var end = 0;
	if (start + 2 < pageCount) {
		end = start + 2;
	} else {
		end = pageCount;
	}
	for (var i = index; i <= end; i++) {
		pageInfo += '<li';
		if (i == start) {
			pageInfo += ' class="active"';
		}
		pageInfo += '><a href="javascript:void(0)" onClick="getData(' + i
				+ ')">' + i + '</a></li>';
	}
	if (start < pageCount) {
		pageInfo += '<li class="next"><a href="javascript:void(0)" onClick="getData('
				+ (start + 1)
				+ ')" style="height:29.2px;"><i class="icon-double-angle-right"></i></a></li>';
	} else {
		pageInfo += '<li class="next disabled"><a href="javascript:void(0)"   style="height:29.2px;"><i class="icon-double-angle-right"></i></a></li>';
	}
	return pageInfo;
}

function showLoader() {
	$("#loading").show();
}

function hideLoader() {
	$("#loading").hide();
}

function showMessage(content) {
	$('#popover-content').text(content);
	$('.popover').slideDown();
	setTimeout(function() {
		$('.popover').slideUp();
	}, 2000);
}

function formatDate(d) {
	var day = new Date(d);
	var Year = 0;
	var Month = 0;
	var Day = 0;
	var CurrentDate = "";
	Year = day.getFullYear();//支持IE和火狐浏览器.
	Month = day.getMonth() + 1;
	Day = day.getDate();
	CurrentDate += Year + "-";
	if (Month >= 10) {
		CurrentDate += Month + "-";
	} else {
		CurrentDate += "0" + Month + "-";
	}
	if (Day >= 10) {
		CurrentDate += Day;
	} else {
		CurrentDate += "0" + Day;
	}
	return CurrentDate;
}