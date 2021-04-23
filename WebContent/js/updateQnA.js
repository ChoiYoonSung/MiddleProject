/**
 * 
 */

function secret() {
	if ($('#boardSecret').prop("checked")) {
		$('#boardSecret').val('Y');
	} else {
		$('#boardSecret').val('N');
	}
}