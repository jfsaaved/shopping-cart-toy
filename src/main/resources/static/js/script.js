function searchKeyPress(e)
{
    // look for window.event in case event isn't passed in
    e = e || window.event;
    if (e.keyCode == 13)
    {
        document.getElementById('filterButton').click();
        return false;
    }
    return true;
}

function filter() {
	filter = document.getElementById('filter').value;
	var url = window.location.href.split('?')[0];
	window.location.replace(url + "?filter=" + filter);
}

function rowClicked(value) {
    var url = window.location.href.split('?')[0];
    window.location.replace(url + "/" + value);
}

function rowClicked2(itemType, value) {
    var url = window.location.href.split('/')[0];
    window.location.replace(url + "/" + itemType + "s/" + value);
}

/*
$('#item-table').on('click', '.clickable-row', function(event) {
  if($(this).hasClass('bg-info selected')){
    $(this).removeClass('bg-info selected');
  } else {
    $(this).addClass('bg-info selected');
  }
});
*/