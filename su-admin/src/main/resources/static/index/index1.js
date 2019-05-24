$(function () {
    $("#tableData").bootstrapTable({
        url: "/registerInfo/queryAllRegister",
        clickToSelect: true,    	//是否启用点击选中行
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        queryParams:{key:""},
        columns: [
            {field: 'selectItem', radio: true},
            {
                title: '序号', align: 'center', width: 50, formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {title: '姓名', field: 'name', visible: true, align: 'center', sortable: true, valign: 'middle'},
            //{title: '任务所在组', field: 'jobGroup', visible: true, align: 'center', valign: 'middle'},
            {title: '车型', field: 'carType', visible: true, align: 'center', sortable: true, valign: 'middle'},
            {title: '电话', field: 'tel', visible: true, align: 'center', sortable: true, valign: 'middle'},
            {title: '车牌号', field: 'carNumber', visible: true, align: 'center', sortable: true, valign: 'middle'},
            {
                title: '登记时间',
                field: 'createTime',
                visible: true,
                sortable: true,
                align: 'center',
                valign: 'middle',
                formatter: function (value) {
                    return changeDateFormat(value);
                }
            },
            {
                title: '领取状态',
                field: 'isCome',
                visible: true,
                align: 'center',
                sortable: true,
                valign: 'middle',
                formatter: function (value) {
                    if (value == 1) {
                        return "已领取"
                    } else if (value == 0) {
                        return "已登记"
                    }
                }
            },
            {
                title: '到店时间',
                field: 'comeTime',
                visible: true,
                align: 'center',
                sortable: true,
                valign: 'middle',
                formatter: function (value) {
                    return changeDateFormat(value);
                }
            },
            {title: '备注', field: 'description', visible: false, align: 'center', valign: 'middle'},
            {
                field: 'id',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: actionFormatter
            }
        ],
        onLoadSuccess: function () {
        },
        onLoadError: function () {
        },
        onDblClickRow: function (row, $element) {
        },
    })
})

function changeDateFormat(cellval) {
    if (cellval != null) {
        var date = new Date(cellval);
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
    } else {
        return ""
    }
}

function refresh() {
    $("#tableData").bootstrapTable("refresh");
    refreshCounts();
}

function query() {
    var key = $('#query').val().toString();
    $.ajax({
        url: "/registerInfo/queryAllRegister",
        type: "GET",
        data: {"key": key},
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        success: function (data) {
            $("#tableData").bootstrapTable('load', data);
            $('#query').val("");
        }
    })
}

//操作栏的格式化
function actionFormatter(value, row, index) {
    var id = value;
    var result = "";
    result += "<a href='javascript:;' class='btn btn-xs ' onclick=\"editViewById('" + id + "')\" title='查看'><span >更改领取状态</span></a>";
    return result;
}

function editViewById(id) {
    $.ajax({
        url: "/registerInfo/editRegister",
        type: "GET",
        data: {
            "id": id
        },
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        success: function (data) {
            if (data.flag == true) {
                layer.msg("修改成功")
                refresh();
            }
        }
    })
}

$(function () {
    refreshCounts();
})
function refreshCounts() {
    $.ajax({
        url: '/registerInfo/getCounts',
        type: 'GET',
        date: {},
        success: function (date) {
            $("#counts").text(date)
        }
    })
    $.ajax({
        url: '/registerInfo/getComeCounts',
        type: 'GET',
        date: {},
        success: function (date) {
            $("#comeCounts").text(date)
        }
    })
}