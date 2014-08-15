
var pages = 7;

(function( $ ) {
  
  var data;
  var maxPage;
  var currentPage;
  
  var appendTo;
  var template;
  var json;
  
  var methods = {
	
	init : function( appendToArg, templateArg, jsonArg, pageArg ) {
		appendTo = appendToArg;
		template = templateArg;
		data = jsonArg;
		maxPage = Math.floor(jsonArg.length / pages);
		currentPage = ((pageArg == "" ) ? 1 : pageArg);;
	},
    load : function( appendTo, template, json ) { 
		// disable previous button
		updateUiState(false);		
		//$(appendTo).html('');
		// prepare data for the first page
		preparePage(template, appendTo);
	
    },
    previouspage : function( ) {
		
		if (--currentPage >= 1) {
			$(appendTo).html('');
			preparePage(template, appendTo);
		}
		updateUiState(true);		
	},
    nextpage : function( ) {
		
		$("#prevbtn").prop( "disabled", false);
		
		if (++currentPage <= maxPage) {
			// delete previous content
			$(appendTo).html('');
			// prepare page and load into the data
			preparePage(template, appendTo);
		} 
		updateUiState(true);
	},
	pagenumber : function( number ) {
		number.text("Page " + (currentPage == null ? 1 : currentPage));
	},
	update : function( page, pageContainer ) {
		currentPage = ((page == "" ) ? 1 : page);
		console.log("current page: " + currentPage);
		methods["pagenumber"].apply(this, [ pageContainer ]);
		// disable previous button
		updateUiState(false);		
		// delete previous content
		$(appendTo).html('');
		// prepare data for the first page
		preparePage(template, appendTo);
	}
  };
  
  function updateUiState( keepAnchor ) {
	controlBtns();
	if (keepAnchor) {
		updateAnchor();
	}	
  }
  
  function updateAnchor() {
	history.pushState(currentPage, "", "#" + currentPage);
  }
  
  function controlBtns() {
	if (currentPage == maxPage) {
		$("#nextbtn").prop( "disabled", true );
	} else if (currentPage == 1) {
		$("#prevbtn").prop( "disabled", true );
	} else {
		$("#prevbtn").prop( "disabled", false );
		$("#nextbtn").prop( "disabled", false );
	}
	
  }
  
  function preparePage(template, appendTo) {
	var page = new Array();
	var start = currentPage * pages - 1;  
	var end = start + pages;
	end = end < data.length ? end : data.length;
	for (var item = start; item < end; item++) {
		page.push(data[item]);
	}
	
	$.get(template, function(templates) {
		$.tmpl(templates, page).appendTo(appendTo)
	});
  }

  $.fn.postloader = function( method ) {
    
    // логика вызова метода
    if ( methods[method] ) {
      return methods[ method ].apply( this, Array.prototype.slice.call( arguments, 1 ));
    } else if ( typeof method === 'object' || ! method ) {
      return methods.load.apply( this, arguments );
    } else {
      $.error( 'Метод с именем ' +  method + ' не существует для jQuery.tooltip' );
    } 
  };
})(jQuery);