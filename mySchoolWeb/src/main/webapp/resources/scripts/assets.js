/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function refresh() {
    window.parent.location = window.parent.location.href;
}
function handleLoginRequest(xhr, status, args) {
    if (args.validationFailed || !args.loggedIn) {
        PF('updateassetdlg').jq.effect("shake", {times: 5}, 100);
    }
    else {
        PF('updateassetdlg').hide();
        $('#updateLink').fadeOut();
    }
}
