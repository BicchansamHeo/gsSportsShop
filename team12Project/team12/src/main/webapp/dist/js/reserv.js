//제발 건들이지 말아쥬세요.... 민감한 친구에요...
var now = new Date();
var dateArry = [];
var dateArry2 = [];
//ajax로 공휴일 정보, 예약 불가능한 날짜 받아오기
//json으로 툴팁 넣고, 배열로 날짜disabled
var demoPicker;
var selectDate;
var startDateLong;
var endDateLong;
var holiCnt;
var loading;
var empNo;
var outArry = [];
$(document).ready(function () {
	empNo=$('#empNo').val();

    $("#loadingImg").hide();
    
    
    //외부인 추가
    $("#addOut").on("click",function(){
    	$("#outInput").css('display', 'block');
    	$("#addOut").css('display', 'none');
    });
    
    $("#add").on("click",function(){
    	if($("#outsider").val()!=''){
    		if(parseInt(maxPeople) <= parseInt(outArry.length) + parseInt(empArry.length)){
        		swal("회의실 최대 수용 인원을 초과하였습니다.","", "warning");
        		$(this).val("0").prop("selected", true);
        		return;
        	}
            var obj = {};
    		obj.name = $("#outsider").val();
    		outArry.push(obj);
    		var name = $("#outsider").val();
    		$('.emps').append("<li id='"+$("#outsider").val()+"'><button type='button' id='delete' class='minus "+name+"'><i class='fa fa-check'></i></button>" + $("#outsider").val() + "</li>");
            
            $( ".minus" ).mouseover(function()
                    {
                        $(this).children().addClass("fa-close");
                        $(this).children().removeClass("fa-check");
                    });
             
             $( ".minus" ).mouseout(function()
                    {
            	 		$(this).children().addClass("fa-check");
            	 		$(this).children().removeClass("fa-close");
                    });
             console.log(outArry);
             $( "."+name ).on("click", function(){
            	 console.log($('#'+name).val());
            	 $('#'+name).remove();
            	 for (var i = 0; i < outArry.length; i++) {
                 	
                     if (outArry[i].outSider == name) {
                    	 outArry.splice(i, 1);
                    	 console.log(outArry);
                     }
                 }
             });
    		
    		
    		$("#outsider").val('');
    		$("#outInput").css('display', 'none');
        	$("#addOut").css('display', 'inline-block');
    		
    	}else{
    		swal("이름을 입력해 주세요.","", "warning");
    	}
    });


    $('#empName').keyup(function (e) {
        $("#empList li").remove();

        $.ajax({
            url: "/searchEmp.do?empName=" + $('#empName').val(),
            type: "GET",
            dataType: 'json',
            success: function (response) {

                console.log(response.data);
                var data = response.data;
                if (data != null) {
                    $.each(data, function (key, value) {
                        $("#empList").append("<li id='" + value.empNo + "' class='" + value.deptNo + "' data-dismiss='modal'>" + value.empNo + " / " + value.empName + " / " + value.deptName + " / " + value.deptNo + "</li>");
                        $("#empList #" + value.empNo).on('click', function () {
                            var empNo = $(this).attr('id');
                            var deptNo = $(this).attr('class');

                            var flag2 = 0;
                            for (var i = 0; i < empArry.length; i++) {

                                if (empArry[i].empNo == empNo) {
                                    flag2 = 1;
                                    break;
                                }
                            }
                            if (flag2 == 0) {
                                if (parseInt(maxPeople) <= parseInt(outArry.length) + parseInt(empArry.length)) {
                                    swal("회의실 최대 수용 인원을 초과하였습니다.", "", "warning");
                                    return;
                                }

                                var obj2 = {};
                                obj2.empNo = $(this).attr('id');
                                obj2.deptNo = $(this).attr('class');
                                empArry.push(obj2);


                                $('.emps').append("<li name='" + empNo + "' class='" + deptNo + " " + empNo + "'><button type='button' class='minus " + empNo + "_btn'><i class='fa fa-check'></i></button>" + value.empName + " / " + value.deptNo + "</li>");
                                cnt++;
                                $(".minus").mouseover(function () {
                                    $(this).children().addClass("fa-close");
                                    $(this).children().removeClass("fa-check");
                                });

                                $(".minus").mouseout(function () {
                                    $(this).children().addClass("fa-check");
                                    $(this).children().removeClass("fa-close");
                                });

                                $('.' + empNo + '_btn').on('click', function () {
                                    console.log($(".emps ." + select).attr('class').split(" "));
                                    var deptNo = $(".emps ." + select).attr('class').split(" ")[0];
                                    var text = $(".emps ." + select).text();
                                    var val = $(".emps ." + select).attr('name');
                                    $('.' + empNo).remove();

                                    for (var i = 0; i < empArry.length; i++) {

                                        if (empArry[i].empNo == val) {
                                            empArry.splice(i, 1);
                                        }
                                    }
                                    for (var i = 0; i < empTempArry.length; i++) {

                                        if (empTempArry[i].empNo == val) {
                                            empTempArry.splice(i, 1);
                                        }
                                    }
                                    cnt--;
                                });
                            }


                            //팀리스트 추가
                            var select = $(this).attr('class');
                            var flag = 0;
                            for (var i = 0; i < deptArry.length; i++) {

                                if (deptArry[i].deptNo == select) {
                                    flag = 1;
                                    break;
                                }
                            }
                            if (flag == 0) {
                                var obj = {};
                                obj.deptNo = $(this).attr('class');
                                deptArry.push(obj);
                                $('.teams').append("<li class='" + select + "'><button type='button' class='minus " + select + "_btn'><i class='fa fa-check'></i></button>" + value.deptName + " / " + value.deptNo + "</li>");
                                $(".minus").mouseover(function () {
                                    $(this).children().addClass("fa-close");
                                    $(this).children().removeClass("fa-check");
                                });

                                $(".minus").mouseout(function () {
                                    $(this).children().addClass("fa-check");
                                    $(this).children().removeClass("fa-close");
                                });

                                $('.' + select + '_btn').on('click', function () {
                                    console.log($(".teams ." + select));
                                    var deptNo = $(".teams ." + select).attr('class');
                                    var text = $(".teams ." + select).text().split("/")[0].trim();
                                    var val = $(".teams ." + select).text().split("/")[1].trim();
                                    $('.' + select).remove();

                                    for (var i = 0; i < deptArry.length; i++) {

                                        if (deptArry[i].deptNo == deptNo) {
                                            deptArry.splice(i, 1);
                                        }
                                    }
                                    for (var i = 0; i < empTempArry.length; i++) {
                                        console.log(empTempArry);
                                        console.log(empArry);

                                        if (empTempArry[i].deptNo == deptNo) {
                                            empTempArry.splice(i, 1);
                                            empArry.splice(i, 1);

                                        }
                                    }


                                });
                                $('#empName').val('');

                            }


                        })
                    });
                }
            }
        });

    });
});

roomNo = getQuerystring('roomNo');

$.ajax({
    url: "/getHollyday.do?roomNo=" + roomNo,
    type: "GET",
    dataType: 'json',
    success: function (response) {


        var data = response.data;
        var data2 = response.data2;
        $.each(data, function (key, value) {
            dateArry.push(new Date(value.holidayDate));
        });
        if (data2) {
            $.each(data2, function (key, value) {
                var arry = [];
                var sd = new Date(value.startDate);
                sd.setHours(0);
                sd.setMinutes(0);
                var ed = new Date(value.endDate);
                ed.setHours(0);
                ed.setMinutes(0);

                console.log(sd.setDate(new Date(value.startDate).getDate() + 1));
                console.log(ed.setDate(new Date(value.endDate).getDate() - 1));

                arry.push(sd);
                arry.push(ed);

                dateArry2.push(arry);
            });
        }


        for (var i = 0; i < dateArry2.length; i++) {
            var date = dateArry2[i];
            var range = (new Date(date[1]).getTime() - new Date(date[0]).getTime()) / 1000 / 60 / 60 / 24;

            var startDate = new Date(date[0]);
            var endDate = new Date(date[1]);

            dateArry.push(new Date(date[0]));
            for (var j = 1; j <= range; j++) {
                var dt = new Date(date[0]);
                dt.setDate(dt.getDate() + j);

                dateArry.push(dt);
            }

        }

        demoPicker = new Datepickk({
            container: document.querySelector('#demoPicker'),
            inline: true,
            maxSelections: 1
        });
        /*Set currentDate*/
        demoPicker.currentDate = new Date();

        demoPicker.disabledDates = dateArry;

        demoPicker.onSelect = function (checked) {
            var state = (checked) ? 'selected' : 'unselected';

            if (state == 'selected') {

                selectDate = this.toLocaleDateString();
                var now = new Date();
                now.setDate(now.getDate() - 1);
                if (new Date(selectDate).getTime() < now.getTime()) {
                    swal("현재와 미래를 선택하세요.","", "warning");
                    demoPicker.unselectDate(new Date(this.toLocaleDateString()));
                    return;
                }

                if (serviceType == "N") { //단기 인 경우
                    $(".reserv-btn").prop("disabled", false);
                    setTimePicker(selectDate);
                } else if (serviceType == "Y") { //장기인 경우
                    //초기 값 선택시
                    if (startDateLong && !endDateLong && (new Date(startDateLong).getTime() > new Date(this.toLocaleDateString()))) {
                        swal("시작 날짜 보다 큰값을 선택하세요.","", "warning");
                        demoPicker.unselectDate(new Date(this.toLocaleDateString()));
                        return;
                    }
                    if (startDateLong && endDateLong) {

                            $(".reserv-btn").prop("disabled", true);
                            startDateLong = '';
                            endDateLong = '';
                            demoPicker.unselectAll();
                            return;


                    }
                    if (!startDateLong) {
                        startDateLong = this.toLocaleDateString();
                    }
                    else if (!endDateLong && (new Date(startDateLong).getTime()!= new Date(endDateLong).getTime())) {



                        endDateLong = this.toLocaleDateString();
                        if ((parseInt(new Date(endDateLong).getDate()) - parseInt(new Date(startDateLong).getDate())) > 7) {
                            swal("장기예약은 7일 이상 하실 수 없습니다.","", "warning");
                            demoPicker.unselectDate(new Date(endDateLong));
                            endDateLong = '';
                            return;
                        }

                        var obj = {};
                        obj.startDate = startDateLong;
                        obj.endDate= endDateLong;
                        obj.roomNo = roomNo;
                        $.ajax({
                            url: "/getLongCheck.do",
                            type: "POST",
                            data: "reservData=" + JSON.stringify(obj),
                            dataType: 'json',
                            success: function (response) {
                                console.log(response.data);
                                if(response.data != 0) {
                                    swal("선택 날짜 중간에 이미 예약된 날짜가 포함되어 있습니다.","", "warning");
                                    demoPicker.unselectDate(new Date(endDateLong));
                                    endDateLong = '';
                                }else{
                                    $(".reserv-btn").prop("disabled", false);
                                    setStartTimePicker(startDateLong);
                                    setEndTimePicker(endDateLong);
                                    holiCnt = response.data2;
                                }
                            }
                        });
                    }


                    console.log('start: ' + startDateLong);
                    console.log('end: ' + endDateLong);

                }

            } else {
                $(".reserv-btn").prop("disabled", true);
                if (serviceType == "Y" && startDateLong && endDateLong) {

                    if(new Date(startDateLong).getTime() == new Date(this.toLocaleDateString()).getTime()){

                        startDateLong=endDateLong;
                        endDateLong='';
                    }else if(new Date(endDateLong).getTime()==new Date(this.toLocaleDateString()).getTime()){

                        endDateLong = '';
                    }

                }
            }

        };

    }
});

//단기 / 장기 체크
var serviceType = 'N';
$(document).ready(function () {
    $("input:radio[name=inlineRadioOptions]").change(function () {
        //라디오 버튼 값을 가져온다.
        serviceType = $(this).val();
        console.log(serviceType);
        if (serviceType == "N") { //단기 인 경우
            selectDate = '';
            startDateLong = '';
            endDateLong = '';
            console.log(selectDate);
            console.log(startDateLong);
            console.log(endDateLong);
            demoPicker.range = false;
            demoPicker.unselectAll();
            demoPicker.maxSelections = parseInt("1");
            console.log(demoPicker.maxSelections);
        } else if (serviceType == "Y") { //장기인 경우
            selectDate = '';
            startDateLong = '';
            endDateLong = '';
            console.log(selectDate);
            console.log(startDateLong);
            console.log(endDateLong);

            demoPicker.range = true;
            demoPicker.unselectAll();
        }

    });


});

//시작 시간
var start;
var dateArry3 = [];
var $datepicker_start_input = $('.timepicker').pickatime({
    formatSubmit: 'HH:i',
    interval: 30,
    min: [7, 0],
    max: [22, 30],
    container: 'body'
});
$(".timepicker").attr("readonly", false);
//종료시간
var $datepicker_end_input = $('.timepicker2').pickatime({
    formatSubmit: 'HH:i',
    interval: 30,
    min: [7, 0],
    max: [23, 00],
    container: 'body'
});

datepicker_start = $datepicker_start_input.pickatime('picker'),
    datepicker_end = $datepicker_end_input.pickatime('picker');

datepicker_start.on('set', function (event) {
    if (event.select) {
        if (selectDate && (new Date(selectDate + ' ' + $('input[name=startTime_submit]').val()) <= new Date())) {
            swal("선택하신 시간이 현재시간보다 작습니다.", "", "warning");
            datepicker_start.set('clear');
            return;
        }
        if (startDateLong && (new Date(startDateLong + ' ' + $('input[name=startTime_submit]').val()) <= new Date())) {
            swal("선택하신 시간이 현재시간보다 작습니다.", "", "warning");
            datepicker_start.set('clear');
            return;
        }
        console.log(selectDate + ' ' + $('input[name=startTime_submit]').val());
        console.log(new Date(selectDate + ' ' + $('input[name=startTime_submit]').val()));
        $(".timepicker2").attr("readonly", false);
    	$(".timepicker2").attr("disabled", false);
        if (serviceType == "N") {
            datepicker_end.set('enable', true);
            datepicker_end.set('disable', datepicker_start.get('disable'));
            start = $('input[name=startTime_submit]').val();

            datepicker_end.set('min', datepicker_start.get('select'));
            console.log(datepicker_start.get('select'));
            datepicker_end.set('disable', [
                [datepicker_start.get('select').hour, datepicker_start.get('select').mins]
            ]);
            
        }else{
            start = $('input[name=startTime_submit]').val();
            console.log("가즈아앙: "+datepicker_start.get('disable'));

            var sn = parseInt(start.split(':')[0]) * 60 + parseInt(start.split(':')[1]);
            var sa;
            var flag = 'Y';
            for (var i = 0; i < dateArry3Start.length; i++) {
                sArry = [];
                eArry = [];
                //start
                sArry.push(dateArry3Start[i][0].getHours());
                sArry.push(dateArry3Start[i][0].getMinutes());



                sa = parseInt(sArry[0]) * 60 + parseInt(sArry[1]);


                if (sn <= sa) {
                    swal("중간에 이미 예약된 시간이 포함되어있습니다.","", "warning");
                    datepicker_start.set('clear');
                    flag = 'N';
                    break;
                }

            }
            console.log(flag);
            if (flag == 'Y') {
                //getPrice();
                $(".timepicker2").attr("disabled", false);
            }
        }

    }
});
var end;
var totalTime;
datepicker_end.on('set', function (event) {
    if (event.select) {
        if (serviceType == "N") {
            var sa;
            var ea;
            end = $('input[name=endTime_submit]').val();
            var sn = parseInt(start.split(':')[0]) * 60 + parseInt(start.split(':')[1]);
            var en = parseInt(end.split(':')[0]) * 60 + parseInt(end.split(':')[1]);
            totalTime = en - sn;
            console.log(totalTime);
            var flag = 'Y';
            for (var i = 0; i < dateArry3.length; i++) {
                sArry = [];
                eArry = [];
                //start
                sArry.push(dateArry3[i][0].getHours());
                sArry.push(dateArry3[i][0].getMinutes());
                //end
                eArry.push(dateArry3[i][1].getHours());
                eArry.push(dateArry3[i][1].getMinutes());


                sa = parseInt(sArry[0]) * 60 + parseInt(sArry[1]);
                ea = parseInt(eArry[0]) * 60 + parseInt(eArry[1]);

                if (sn <= sa && en >= ea) {
                    swal("중간에 이미 예약된 시간이 포함되어있습니다.","", "warning");
                    datepicker_end.set('clear');
                    flag = 'N';
                    break;
                }

            }
            console.log(flag);
            if (flag == 'Y') {
                getPrice();
            }
        }else{
            end = $('input[name=endTime_submit]').val();
            var ts = new Date(startDateLong);
            ts.setDate(ts.getDate()+1);
            var te = new Date(endDateLong);

            console.log(ts);
            console.log(te);

            var ss = new Date(startDateLong+' '+start);

            var ee= new Date(endDateLong+' '+end);
            console.log("holiCnt  "+holiCnt);

            var totalDay=((te.getTime()-ts.getTime())/1000/60/60/24)-(parseInt(holiCnt));
            console.log("totalDay  "+totalDay);
            var tst = (23*60)-((parseInt(start.split(":")[0])*60)+(parseInt(start.split(":")[1])));
            var tet = ((parseInt(end.split(":")[0])*60)+(parseInt(end.split(":")[1])))-(7*60);
            console.log("tst  "+tst);
            console.log("tet  "+tet);

            totalTime = (totalDay*16*60)+tst+tet;


            var en = parseInt(end.split(':')[0]) * 60 + parseInt(end.split(':')[1]);
            var ea;
            var flag = 'Y';
            for (var i = 0; i < dateArry3End.length; i++) {

                eArry = [];
                //start
                eArry.push(dateArry3End[i][0].getHours());
                eArry.push(dateArry3End[i][0].getMinutes());



                ea = parseInt(eArry[0]) * 60 + parseInt(eArry[1]);


                if (en >= ea) {
                    swal("중간에 이미 예약된 시간이 포함되어있습니다.","", "warning");
                    datepicker_end.set('clear');
                    flag = 'N';
                    break;
                }

            }
            console.log(flag);
            if (flag == 'Y') {
                getPrice();

            }
        }
    }
});

var sArry;
var eArry;

//날짜선택하고 예약하기 누를때 해당 날짜 예약 시간 리스트 불러옴
//단기
function setTimePicker(selectDate) {

    datepicker_start.set('disable', false);
    datepicker_end.set('disable', false);
    $('#selectDate').val(selectDate);
    $('#selectDateEnd').val(selectDate);

    console.log('선택 날짜: ' + selectDate);
    $.ajax({
        url: "/getReserved.do?selectDate=" + selectDate+"&roomNo="+roomNo,
        type: "GET",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success: function (response) {
            var data = response.data;
            console.log(data);
            dateArry3 = [];
            if (data != null) {
                $.each(data, function (key, value) {
                    console.log("long: "+value.longTermYn);
                    if(value.longTermYn=='N'){
                        dateArry3.push([new Date(value.startDate), new Date(value.endDate)]);
                    }else{
                        console.log("check: "+value.startDate);

                        if((new Date(value.startDate).getDate() == new Date(selectDate).getDate()) && (new Date(value.startDate).getMonth() == new Date(selectDate).getMonth())){
                            var s=new Date(value.startDate);
                            s.setHours(23);
                            s.setMinutes(0);
                            dateArry3.push([new Date(value.startDate), s]);
                        }else if((new Date(value.endDate).getDate() == new Date(selectDate).getDate()) && (new Date(value.endDate).getMonth() == new Date(selectDate).getMonth())){
                            var e=new Date(value.endDate);
                            e.setHours(0);
                            e.setMinutes(0);
                            dateArry3.push([e, new Date(value.endDate)]);
                        }
                    }

                });

                for (var i = 0; i < dateArry3.length; i++) {
                    sArry = [];
                    eArry = [];
                    //start
                    console.log(dateArry3[i][0].getHours());
                    console.log(dateArry3[i][0].getMinutes());
                    sArry.push(dateArry3[i][0].getHours());
                    sArry.push(dateArry3[i][0].getMinutes());
                    //end
                    console.log(dateArry3[i][1].getHours());
                    console.log(dateArry3[i][1].getMinutes());
                    eArry.push(dateArry3[i][1].getHours());
                    eArry.push(dateArry3[i][1].getMinutes());

                    datepicker_start.set('disable', [{
                        from: sArry,
                        to: eArry
                    }]);
                    datepicker_end.set('disable', [{
                        from: sArry,
                        to: eArry
                    }]);

                }
            }

        }
    });
}

//장기 시작
var dateArry3Start;
function setStartTimePicker(selectDate) {

    datepicker_start.set('disable', false);
    datepicker_end.set('disable', false);
    $('#selectDate').val(selectDate);
    console.log('선택 날짜: ' + selectDate);
    $.ajax({
        url: "/getReserved.do?selectDate=" + selectDate+"&roomNo="+roomNo,
        type: "GET",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success: function (response) {
            var data = response.data;
            dateArry3 = [];
            if (data != null) {
                $.each(data, function (key, value) {
                    if(value.longTermYn=='N'){
                        dateArry3.push([new Date(value.startDate), new Date(value.endDate)]);
                    }else{
                        console.log("check: "+value.startDate);

                        if((new Date(value.startDate).getDate() == new Date(selectDate).getDate()) && (new Date(value.startDate).getMonth() == new Date(selectDate).getMonth())){
                            var s=new Date(value.startDate);
                            s.setHours(23);
                            s.setMinutes(0);
                            dateArry3.push([new Date(value.startDate), s]);
                        }else if((new Date(value.endDate).getDate() == new Date(selectDate).getDate()) && (new Date(value.endDate).getMonth() == new Date(selectDate).getMonth())){
                            var e=new Date(value.endDate);
                            e.setHours(0);
                            e.setMinutes(0);
                            dateArry3.push([e, new Date(value.endDate)]);
                        }
                    }

                });
                dateArry3Start = dateArry3;
                for (var i = 0; i < dateArry3.length; i++) {
                    sArry = [];
                    eArry = [];
                    //start
                    console.log(dateArry3[i][0].getHours());
                    console.log(dateArry3[i][0].getMinutes());
                    sArry.push(dateArry3[i][0].getHours());
                    sArry.push(dateArry3[i][0].getMinutes());
                    //end
                    console.log(dateArry3[i][1].getHours());
                    console.log(dateArry3[i][1].getMinutes());
                    eArry.push(dateArry3[i][1].getHours());
                    eArry.push(dateArry3[i][1].getMinutes());

                    datepicker_start.set('disable', [{
                        from: sArry,
                        to: eArry
                    }]);

                }
            }

        }
    });
}

//장기 끝
var dateArry3End;
function setEndTimePicker(selectDate) {

    datepicker_start.set('disable', false);
    datepicker_end.set('disable', false);
    $('#selectDateEnd').val(selectDate);
    console.log('선택 날짜: ' + selectDate);
    $.ajax({
        url: "/getReserved.do?selectDate=" + selectDate+"&roomNo="+roomNo,
        type: "GET",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success: function (response) {
            var data = response.data;
            dateArry3 = [];
            if (data != null) {
                $.each(data, function (key, value) {
                    if(value.longTermYn=='N'){
                        dateArry3.push([new Date(value.startDate), new Date(value.endDate)]);
                    }else{
                        console.log("check: "+value.startDate);

                        if((new Date(value.startDate).getDate() == new Date(selectDate).getDate()) && (new Date(value.startDate).getMonth() == new Date(selectDate).getMonth())){
                            var s=new Date(value.startDate);
                            s.setHours(23);
                            s.setMinutes(0);
                            dateArry3.push([new Date(value.startDate), s]);
                        }else if((new Date(value.endDate).getDate() == new Date(selectDate).getDate()) && (new Date(value.endDate).getMonth() == new Date(selectDate).getMonth())){
                            var e=new Date(value.endDate);
                            e.setHours(0);
                            e.setMinutes(0);
                            dateArry3.push([e, new Date(value.endDate)]);
                        }
                    }

                });
                dateArry3End = dateArry3;
                for (var i = 0; i < dateArry3.length; i++) {
                    sArry = [];
                    eArry = [];
                    //start
                    console.log(dateArry3[i][0].getHours());
                    console.log(dateArry3[i][0].getMinutes());
                    sArry.push(dateArry3[i][0].getHours());
                    sArry.push(dateArry3[i][0].getMinutes());
                    //end
                    console.log(dateArry3[i][1].getHours());
                    console.log(dateArry3[i][1].getMinutes());
                    eArry.push(dateArry3[i][1].getHours());
                    eArry.push(dateArry3[i][1].getMinutes());

                    datepicker_end.set('disable', [{
                        from: sArry,
                        to: eArry
                    }]);

                }
            }

        }
    });
}

//팀목록 가져오기
$.ajax({
    url: "/getTeam.do",
    type: "GET",
    dataType: 'json',
    success: function (response) {

        console.log(response.data);
        var data = response.data;
        if (data != null) {
            $.each(data, function (key, value) {
                $(".teamList").append("<option class='" + value.deptNo + "' value='" + value.deptNo + "'>" + value.deptName + " / " + value.deptNo + "</option>");
            });

        }
    }
});

var deptArry = [];
//팀선택시 배열에 팀번호 추가 팀원 목록 요청
$('.teamList').on('change', function () {
    if ($(this).val() != '0') {
        var select = $(this).val();


        var index = $('.teamList option').index($('.teamList option:selected'));

        var flag = 0;
        for (var i = 0; i < deptArry.length; i++) {

            if (deptArry[i].deptNo == select) {
                flag = 1;
            }
        }
        if (flag == 0) {
            var obj = {};
            obj.deptNo = select;
            deptArry.push(obj);
            var jsonInfo = JSON.stringify(deptArry);
            console.log(jsonInfo);
            $('.teams').append("<li class='" + select + "'><button type='button' class='minus " + select + "_btn'><i class='fa fa-check'></i></button>" + $('.teamList option:selected').text() + "</li>");
            $(".minus").mouseover(function () {
                $(this).children().addClass("fa-close");
                $(this).children().removeClass("fa-check");
            });

            $(".minus").mouseout(function () {
                $(this).children().addClass("fa-check");
                $(this).children().removeClass("fa-close");
            });

            $('.' + select + '_btn').on('click', function () {
                console.log($(".teams ." + select));
                var deptNo = $(".teams ." + select).attr('class');
                var text = $(".teams ." + select).text().split("/")[0].trim();
                var val = $(".teams ." + select).text().split("/")[1].trim();
                $('.' + select).remove();
                $(".teamList").append("<option class='" + deptNo + "' value='" + val + "'>" + text + " / " + deptNo + "</option>");

                for (var i = 0; i < deptArry.length; i++) {

                    if (deptArry[i].deptNo == deptNo) {
                        deptArry.splice(i, 1);
                    }
                }
                for (var i = 0; i < empTempArry.length; i++) {
                    console.log(empTempArry);
                    console.log(empArry);

                    if (empTempArry[i].deptNo == deptNo) {
                        empTempArry.splice(i, 1);
                        empArry.splice(i, 1);

                    }
                }


            });
        }


        $(this).val("0").prop("selected", true);
        $('.empList').prop("disabled", false);
        $('.teamList option:eq(' + index + ')').remove();


        $.ajax({
            url: "/getTeamEmp.do",
            type: "POST",
            data: "teamList=" + JSON.stringify(deptArry),
            dataType: 'json',
            success: function (response) {

                console.log(response.data);
                var data = response.data;
                if (data != null) {
                    $.each(data, function (key, value) {

                        var check = 'N';
                        $(".empList").children().each(function () {
                            if ($(this).attr("value") == value.empNo) {
                                check = 'Y';
                                return false;
                            }
                        });

                        $(".emps").children().each(function () {
                            if ($(this).attr("name") == value.empNo) {
                                check = 'Y';
                                return false;
                            }
                        });

                        if (check == 'N') {
                            if ($('#empNo').val() != value.empNo) {
                                $(".empList").append("<option class='" + value.deptNo + "' value='" + value.empNo + "'>" + value.empName + " / " + value.deptNo + "</option>");
                            }

                        }

                    });

                }
            }
        });
    }


});


//사원 추가
var empArry = [];
var empTempArry=[];
var cnt=0;
$('.empList').on('change', function () {
    if ($(this).val() != '0') {
    	if(parseInt(maxPeople) <= parseInt(outArry.length) + parseInt(empArry.length)){
    		swal("회의실 최대 수용 인원을 초과하였습니다.","", "warning");
    		$(this).val("0").prop("selected", true);
    		return;
    	}
    	
    	
        var select = $(this).val();
        var index = $('.empList option').index($('.empList option:selected'));
        var obj = {};
        var objTmp={};
        obj.empNo = select;
        objTmp.empNo = select;
        empArry.push(obj);
        
        
        var deptNo = $('.empList option:selected').attr('class');
        obj.deptNo = deptNo;
        objTmp.deptNo=deptNo;
        empTempArry.push(objTmp);
        
        $('.emps').append("<li name='" + select + "' class='" + deptNo + " " + select + "'><button type='button' class='minus " + select + "_btn'><i class='fa fa-check'></i></button>" + $('.empList option:selected').text() + "</li>");
        cnt++;
        $( ".minus" ).mouseover(function()
                {
                    $(this).children().addClass("fa-close");
                    $(this).children().removeClass("fa-check");
                });
         
         $( ".minus" ).mouseout(function()
                {
        	 		$(this).children().addClass("fa-check");
        	 		$(this).children().removeClass("fa-close");
                });
        $('.empList option:eq(' + index + ')').remove();
        $('.' + select + '_btn').on('click', function () {
            console.log($(".emps ." + select).attr('class').split(" "));
            var deptNo = $(".emps ." + select).attr('class').split(" ")[0];
            var text = $(".emps ." + select).text();
            var val = $(".emps ." + select).attr('name');
            $('.' + select).remove();
            $(".empList").append("<option class='" + deptNo + "' value='" + val + "'>" + text + "</option>");

            for (var i = 0; i < empArry.length; i++) {

                if (empArry[i].empNo == val) {
                    empArry.splice(i, 1);
                }
            }
            for (var i = 0; i < empTempArry.length; i++) {

                if (empTempArry[i].empNo == val) {
                	empTempArry.splice(i, 1);
                }
            }
            
            
            
            cnt--;
        });
        var jsonInfo = JSON.stringify(empArry);
        console.log(jsonInfo);


        $(this).val("0").prop("selected", true);


    }
});

//기자제 추가
var fixtureArry = [];
$('.fixtureList').on('change', function () {
    if ($(this).val() != '0') {
        var select = $(this).val().split(",")[0];
        var quantity = $(this).val().split(",")[1];

        var index = $('.fixtureList option').index($('.fixtureList option:selected'));
        var obj = {};
        obj.fixtureNo = select;
        obj.quantity = 0;
        fixtureArry.push(obj);
        $('.fixtures').append("<li>" + $('.fixtureList option:selected').text() + "<input type='number' class='form-control' id='" + select + "' placeholder='수량을 입력하세요.'></li>");

        $('#' + select).on('change', function () {
            console.log(quantity);
            if (parseInt(quantity) >= parseInt($(this).val())) {
                for (var i = 0; i < fixtureArry.length; i++) {
                    if (fixtureArry[i].fixtureNo == select) {
                        fixtureArry[i].quantity = $(this).val();
                        getPrice();
                    }
                }
            } else {
                swal("현재 남은 수량보다 큰수량을 입력 하셨습니다.","", "warning");
                $(this).val('');

            }

            console.log(fixtureArry);
        });


        $(this).val("0").prop("selected", true);
        $('.fixtureList option:eq(' + index + ')').remove();
    }
});

//간식 추가
var snackArry = [];
$('.snackList').on('change', function () {
    if ($(this).val() != '0') {
        var select = $(this).val().split(",")[0];
        var quantity = $(this).val().split(",")[1];

        var index = $('.snackList option').index($('.snackList option:selected'));
        var obj = {};
        obj.snackNo = select;
        obj.quantity = 0;
        snackArry.push(obj);
        $('.snacks').append("<li>" + $('.snackList option:selected').text() + "<input type='number' class='form-control' id='" + select + "' placeholder='수량을 입력하세요.'></li>");


        $('#' + select).on('change', function () {
            //console.log('sad'+$(this).val());
            if (parseInt(quantity) >= parseInt($(this).val())) {
                for (var i = 0; i < snackArry.length; i++) {
                    if (snackArry[i].snackNo == select) {
                        snackArry[i].quantity = $(this).val();
                        getPrice();
                    }
                }
            } else {
                swal("현재 남은 수량보다 큰수량을 입력 하셨습니다.","", "warning");
                $(this).val('');
            }

            console.log(snackArry);
        });
        $(this).val("0").prop("selected", true);
        $('.snackList option:eq(' + index + ')').remove();
    }
});

//선택된 회의실 기자제 가져오기
// 회의실 리스트에서 클릭시 해당 회의실번호 여기에 넣기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
var roomNo = getQuerystring('roomNo');

$.ajax({
    url: "/getFixture.do?roomNo=" + roomNo,
    type: "GET",
    dataType: 'json',
    success: function (response) {

        console.log(response.data);
        var data = response.data;
        if (data != null) {
            $.each(data, function (key, value) {
                $(".fixtureList").append("<option value='" + value.fixtureNo + "," + value.quantity + "'>" + value.fixtureName + " / " + value.quantity + "개(사용가능 수량)</option>");
            });
        }
    }
});


//회의실 최대 인원 가져오기
var maxPeople;
var roomName;
$.ajax({
    url: "/getMaxPeople.do?roomNo=" + roomNo,
    type: "GET",
    dataType: 'json',
    success: function (response) {

        console.log(response.data);
        var data = response.data;
        maxPeople=data;
        //회의실 이름 가져오기
        $.ajax({
            url: "/getRoomName.do?roomNo=" + roomNo,
            type: "GET",
            dataType: 'json',
            success: function (response) {

                console.log(response.data);
                var data = response.data;
                roomName = data;
                $('#roomConfig').val(roomName + ' / ' + maxPeople + '명');
            }
        });
    }
});





//간식가져오기
$.ajax({
    url: "/getSnack.do?roomNo=" + roomNo,
    type: "GET",
    dataType: 'json',
    success: function (response) {

        console.log(response.data);
        var data = response.data;
        if (data != null) {
            $.each(data, function (key, value) {
                $(".snackList").append("<option value='" + value.snackNo + "," + value.quantity + "'>" + value.snackName + " / " + value.quantity + "개(사용가능 수량)</option>");
            });
        }
    }
});






//예약 제출
$('#postReserv').on('click', function () {
    var obj = {};

    obj.roomNo = roomNo;
    obj.roomName = roomName;
    obj.snackList = snackArry;
    obj.fixtureList = fixtureArry;
    obj.empList = empArry;
    obj.deptList = deptArry;
    obj.empNo=empNo;
    obj.start = start;
    obj.end = end;
    obj.outList= outArry;
    if($("input:radio[name=inlineRadioOptions]:checked").val()=='N'){
        obj.selectDate = selectDate;
        obj.selectDate2 = selectDate;
    }else{
        obj.selectDate = startDateLong;
        obj.selectDate2 = endDateLong;
    }
    obj.price = totalPrice;
    obj.longTermYn = $("input:radio[name=inlineRadioOptions]:checked").val();

    //회의구분
    obj.reservContent = $('#reservContent').val();
    //회의목적
    obj.reservContent2 = $('#reservContent2').val();



    var jsonInfo = JSON.stringify(obj);
    console.log(jsonInfo);
    if (obj.roomNo && obj.empList && obj.deptList && obj.start && obj.end && obj.selectDate && obj.longTermYn && obj.reservContent && obj.reservContent2) {
    	$('#postReserv').attr("disabled", true);

        $("#loadingImg").show();
		wrapWindowByMask();
    	$.ajax({
            url: "/reserv.do",
            type: "POST",
            data: "reservData=" + JSON.stringify(obj),
            dataType: 'json',
            success: function (response) {

                console.log(response.data);
                var data = response.data;

                post_to_url("/confirmReserv.do", JSON.stringify(data), "POST");
                

            }
        });
    } else if (typeof obj.start == "undefined") {
        swal("시작 시간을 선택해주세요.", "", "warning");
    } else if (typeof obj.end == 'undefined') {
        swal("종료 시간을 선택해주세요.", "", "warning");
    } else if (obj.deptList.length < 1) {
        swal("회의 참여 부서를 입력해주세요.", "", "warning");
    } else if (obj.empList.length < 1) {
        swal("회의 참여 사원을 입력해주세요.", "", "warning");
    } else if (obj.reservContent == '') {
        swal("회의 구분을 입력해주세요.", "", "warning");
    } else if (obj.reservContent2 == '') {
        swal("회의 목적을 입력해주세요.", "", "warning");
    }

});


//취소버튼
$(".reset").click(function () {
    $("#reservForm").each(function () {
        this.reset();
    });
});

var totalPrice;
//실시간 가격 체크
function getPrice() {
    console.log('예약시간 총: ' + totalTime);
    if (totalTime) {
        var obj = {};
        obj.roomNo = roomNo;
        obj.snackList = snackArry;
        obj.fixtureList = fixtureArry;
        $.ajax({
            url: "/getPrice.do",
            type: "POST",
            data: "reservData=" + JSON.stringify(obj),
            dataType: 'json',
            success: function (response) {
                console.log('data: ' + response.data);
                $('#totalPrice').val('');


                var roomPrice = parseInt(response.data);
                var fixturePrice = parseInt(response.data1);
                var snackPrice = parseInt(response.data2);
                totalPrice = (roomPrice * (totalTime / 30)) + fixturePrice + snackPrice;
                $('#totalPrice').val(numberWithCommas(totalPrice));
            }
        });
    } else {
        swal("예약시간을 선택해주세요.","", "warning");
    }

}

//ajax success시 post 요청 으로 페이지 이동
function post_to_url(path, param, method) {
    method = method || "post"; // Set method to post by default, if not specified.
    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "data");
    hiddenField.setAttribute("value", param);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}


function wrapWindowByMask(){
	//화면의 높이와 너비를 구한다.
	var maskHeight = $(document).height();  
	var maskWidth = $(window).width();  
	
	//마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
	$('#mask').css({'width':maskWidth,'height':maskHeight});  
	
	//애니메이션 효과 - 일단 1초동안 까맣게 됐다가 80% 불투명도로 간다.
	//$('#mask').fadeIn(1000);      
	$('#mask').fadeTo("slow",0.6);    
}


$('#myModal').on('hidden.bs.modal', function () {
    // do something…
    $('#reservForm').reset();
});

function getQuerystring(paramName) {
    var _tempUrl = window.location.search.substring(1); //url에서 처음부터 '?'까지 삭제
    var _tempArray = _tempUrl.split('&'); // '&'을 기준으로 분리하기
    console.log(_tempArray);
    for (var i = 0; _tempArray.length; i++) {
    	
        var _keyValuePair = _tempArray[i].split('=');
        if (_keyValuePair[0] == paramName) { // _keyValuePair[0] : 파라미터 명 // _keyValuePair[1] : 파라미터 값
            return _keyValuePair[1];
        }
    }
}

//숫자 콤마
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
