
function demoTest(){
    alert('demoTest called.');
}

$("h1").css("color","red");
$("a[target='pink']").css("color","pink");
 
$("#edit").click(function() {
 
 alert('demoTest called!!!!!!.');
 
 
});

const DELETE_MESSAGE = "削除してもよろしいですか？"
$('.delete-action').click(function() {
	if(!confirm(DELETE_MESSAGE)){
		return false;
	}
});

function edit(){
	var name = $('input[name="edit"]').val();
	//var itemId = $("#itemId").value();
	var form = $("#form1");
	form.addAttribute(`<input type='hidden' name='itemId' value=${name}>itemId</input>`);
	form.submit();
	console.log(name);
}

//var foo = 'ート';
//var bar = `テンプレ${foo}リテラル`;
//console.log(bar); // テンプレートリテラル