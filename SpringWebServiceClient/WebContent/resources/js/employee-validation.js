var Employee = {
		// Datatable ajax server-side pagination
		getSellHistory : function(){
			var uid = $("#uid").val();
			if(uid != undefined && uid != "" && uid != null){
				$('#Employee').DataTable( {
					lengthChange: false,
					"pageLength":20,
					"searching": false,
			        "processing": true,
			        "serverSide": true,
					//serverSide		: true,
			        //ordering		: false,
			        //searching		: false,
					"ajax": {
					    "url": "getEmployee/"+uid,
					    "type": "POST",
					    /*
					    "data": function ( d ) {
					      JSON.stringify( d );
					      console.log(JSON.stringify( d ) );
					    },
					    "dataSrc": ""
					    */
					  },
			        "columns": [
			                    { "data": "key", "className": "col-xs-8" },
			                    { "data": "value", "className": "col-xs-8"},
			                ],
			        scrollY: 130,
			        scroller: {
			            loadingIndicator: true
			        }
					
					/*"bSort" 		: false,
					"bPaginate"		: false,
					"bFilter"		: false, 
					"bInfo"			: false,
			        "scrollCollapse": true,
			        "paging"		: false,
			        "scrollY"		: "130px",
					"ajax": {
					    "url": "getSellHistory/"+uid,
					    "type": "POST",
					    "data": function ( d ) {
					      JSON.stringify( d );
					      console.log(d );
					    },
					    "dataSrc": ""
					  },
			        "columns": [
			                    { "data": "key", "className": "col-xs-8" },
			                    { "data": "value", "className": "col-xs-8"},
			                ]*/
			    } );
			}
		},
		
}


$(document).ready(function() {
	var table = $('#example2').DataTable({
		   scrollY:        '50vh',
	    scrollCollapse: true,
	    paging:         false,
		   "ajax": {
	         "url": "getRepTypMasters",
	         "type": "POST",
	         "dataSrc": ""
	     },
	     "columns": [
	                 { "data": "rn" },
	                 { "data": "cn" },
	                 { "data": "rd" },
	                 { 
	                 	"data": null,
	                 	//"defaultContent":'<a class="repEdit" href="#" style="color:#000;text-decoration:none;"><img src="<c:url value="/resources/images/edit.png" />" height="12px" width="12px" title="Edit"/> Edit</a>'
	                 	"defaultContent":"<button>Edit</button>"
	                 },
	                 { 
		                   	"data": "rs",
	                     render: function (data, type, row) {
	                         var ddl = "<select>";
	                         for (var i = 0; i < data.length; i++) {
	                         	if(data == 1){
	                         		ddl = ddl + "<option value='"+data+"'>Active</option>";
	                         		ddl = ddl + "<option value='"+data+"'>In-Active</option>";
	                         	}else{
	                         		ddl = ddl + "<option value='"+data+"'>In-Active</option>";
	                         		ddl = ddl + "<option value='"+data+"'>Active</option>";
	                         	}
	                             
	                         }
	                         ddl += "</select>";
	                         return ddl;
	                     }
	                 },
	             ],
	 	language: {
	         paginate: {
	             previous	: "Previous",
	             next		: "Next",
	         },
	     }
	 });
	 
	 // Reading table Row data
	 //$('#example2 tbody').on( 'click', 'button', function () {
	 $(document).on( 'click', '#example2 tbody button', function () {
	     console.log( table.row( this ).data() );
	 } );
	 
	//Detect Scrollbar reached to bottom
		$("#divId").scroll(function(){
			   	if((Math.ceil($(this).scrollTop() + $(this).height()) >= $(this)[0].scrollHeight)){
			   		// User operation
			   	}
			});
	 
	});
	
