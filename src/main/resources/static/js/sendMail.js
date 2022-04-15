function loadScenario()
{
    var selectScenario = document.getElementById('scenarioNames');
    selectScenario = selectScenario.options[selectScenario.selectedIndex].value;

    var message = {
        scenarioId : selectScenario
    };

    $.ajax({
        type    : 'POST',
        url     : '/scenarioInfoLoad',
        data    : message,
        success : function(result) {
            $("#scenarioInfoForm").replaceWith(result);
        },
        error   : function(result) {},
        complete: function() {
    }});
}

function modalClick(clickStatus)
{
	if (clickStatus == 'on')
    {
        $.ajax({
        type    : 'POST',
        url     : '/callCorpInfo',
        success : function(result) {
            document.getElementsByClassName('modal')[0].style.display = 'table';
            $("#corpNames").replaceWith(result);
        },
        error   : function(result) {},
        complete: function() {
        }})

    }
    else
    {
        document.getElementsByClassName('modal')[0].style.display = 'none';
    }
}