// URL para os serviços RESTful
var rootColorsURL = "http://localhost:8080/ApiMSMicroProfileTomEEMaven/api/colors";
var rootVehiclesURL = "http://localhost:8080/ApiMSMicroProfileTomEEMaven/api/vehicles";

// Carrega as listas apos o load page
$(document).ready(function(){
	colorsFindAll();
	vehiclesFindAll();
	 $( document ).on('click', '#btnEditVehicle', function(id){
		 vehicleFindByIdForEdit(this.value);
	 });
	 $( document ).on('click', '#btnDeleteVehicle', function(id){
		 deleteVehicle(this.value);
	 });
	 $( document ).on('click', '#btnNewVehicle', function(){
		 $('#id').val("");
		 $('#registrationForm').trigger("reset");
	 });
	 
});

// Function to serialize all form fields in a JSON string
function formToJSON(formId) {
	var values = {};
	$.each($(formId).serializeArray(), function(i, field) {
		if (field.value != ""){
			values[field.name] = field.value;
		}
		if(field.name == "color"){
			values[field.name] = JSON.parse(field.value);
		}
		if($("#active").is(':checked')){
			values["active"] = true;
		}else{
			values["active"] = false	;
		}
		var date = new Date();
		values["updatedIn"] = date.toISOString().substring(0, 19);	
	});
	
	var stringJson = JSON.stringify(values)
	console.log(stringJson);
	
	return stringJson;
}

// ========================= Colors ==========================
function colorsFindAll() {
	console.log('colorsFindAll');
	$.ajax({
		type : 'GET',
		url : rootColorsURL,
		dataType : "json", // data type do response
		success: function (data) {
             console.log(data);
             var options = '';
             $.each(data, function (key, value) {
                 options += '<option value=' + JSON.stringify(value) + '>' + value.description + '</option>';
             });
             $('#color').append(options);
         },
         error(jqXHR, textStatus, errorThrown) {
             alert('Something wrong happened because: ' + errorThrown)
         }
	});
}

// ======================== Vehicles =========================
// listener do save button
$('#btnSaveVehicle').click(function() {
	if ($('#id').val() == '')
		createVehicle();
	else
		updateVehicle();
	return false;
});

// create
function createVehicle() {
	console.log('==Create Vehicle:::');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootVehiclesURL,
		dataType : "json",
		data : formToJSON('#registrationForm'),
		success : function(data, textStatus, jqXHR) {
			var fm = $('#registrationForm');
			fm.data = data;
			$('#id').val(data.id);
			$('#updatedIn').val(data.updatedIn);
			vehiclesFindAll();
			alert('Vehicle create: '+textStatus);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Vehicle create error: ' + jqXHR.responseText);
		}
	});
}

// update
function updateVehicle() {
	console.log('==Upload Vehicle:::');
	$.ajax({
		type : 'PUT',
		contentType : 'application/json',
		url : rootVehiclesURL,
		dataType : "json",
		data : formToJSON('#registrationForm'),
		success : function(data, textStatus, jqXHR) {
			var fm = $('#registrationForm');
			fm.data = data;
			$('#id').val(data.id);
			$('#updatedIn').val(data.updatedIn);
			vehiclesFindAll();
			alert('Vehicle update: '+textStatus);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Vehicle update error: ' + jqXHR.responseText);
		}
	});
}

// delete
function deleteVehicle(id) {
	console.log('==Delete Vehicle:::');
	$.ajax({
		type : 'DELETE',
		url : rootVehiclesURL + '/' + id,
		success : function(data, textStatus, jqXHR) {
			vehiclesFindAll();
			alert('Vehicle delete: '+textStatus);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Vehicle delete error: ' + jqXHR.responseText);
		}
	});
}

// find all
function vehiclesFindAll() {
	console.log('==Find all Vehicle:::');
	$.ajax({
		type : 'GET',
		url : rootVehiclesURL,
		dataType : "json", // data type of response
		success :  function(data, textStatus, jqXHR) {
			console.log(data);
			renderList(data);
		}
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null and a 'collection of one' as an
	// object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [ data ]);
	$('#vehicles').remove();
	var lines = "<table id='vehicles' border='1'>"
		+ "<tr><td>Plate</td>" 
		+ "<td>Model Year</td>"
		+ "<td>Manufacture Year</td>"
		+ "<td>Color</td>"
		+ "<td>Status</td>"
		+ "<td>Edit</td>"
		+ "<td>Delete</td></tr>";
	$.each(list, function(index, vehicle) {(
			lines += "<tr><td>" + vehicle.plate + "</td>" 
			+ "<td>" + vehicle.modelYear + "</td>"
			+ "<td>" + vehicle.manufactureYear + "</td>"
			+ "<td>" + vehicle.color.description + "</td>"
			+ "<td>" + vehicle.active + "</td>"
			+ "<td><button id='btnEditVehicle' value='"+vehicle.id+"'>Edit</button></td>"
			+ "<td><button id='btnDeleteVehicle' value='"+vehicle.id+"'>Delete</button</td></tr>"
		);
	});
	
	lines += "</table>";
	
	$('#vehicleFieldSet').append(lines);
}

// Pesquisa pelo id, para edição
function vehicleFindByIdForEdit(id) {
	console.log('findByIdForEdit: ' + id);
	$.ajax({
		type : 'GET',
		url : rootVehiclesURL + '/' + id,
		dataType : "json",
		success : function(data) {
			jsonToForm(data);
		}
	});
}

function jsonToForm(data) {
	$('#id').val(data.id);
	$('#plate').val(data.plate);
	$('#modelYear').val(data.modelYear);
	$('#manufactureYear').val(data.manufactureYear);
	$('#color').val(JSON.stringify(data.color));
	$('#updatedIn').val(data.updatedIn);
	if(data.active){
		$('#active').prop('checked', true);
	}else{
		$('#active').prop('checked', false);
	}
}

// =======================================================
