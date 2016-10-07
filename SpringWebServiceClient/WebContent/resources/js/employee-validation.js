var Employee = {
		// Datatable ajax server-side pagination
		getSellHistory : function(){
			var uid = $("#uidForChat").val();
			if(uid != undefined && uid != "" && uid != null){
				$('#sellHistoryTable').DataTable( {
					lengthChange: false,
					"pageLength":20,
					"searching": false,
			        "processing": true,
			        "serverSide": true,
					//serverSide		: true,
			        //ordering		: false,
			        //searching		: false,
					"ajax": {
					    "url": "getSellHistory/"+uid,
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
