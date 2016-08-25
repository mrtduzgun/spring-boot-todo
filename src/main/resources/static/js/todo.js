$(function() {

    var RANGE_SEPERATOR = '_';
    var todayRange =  [moment().startOf('day'), moment().endOf('day')];

    var dateRangePickerDefaults = {

          startDate: todayRange[0],
          endDate: todayRange[1],
          autoUpdateInput: false,
          minDate: moment(),
          locale: {
            format: 'D MMM YYYY'
          },
          ranges: {
             'Today': todayRange,
             'Tomorrow': [moment().add(1, 'days').startOf('day'), moment().add(1, 'days').endOf('day')],
             'This Week': [moment().startOf('week'), moment().endOf('week')],
             'Next Week': [moment().add(1, 'weeks').startOf('week'), moment().add(1, 'weeks').endOf('week')],
             'This Month': [moment().startOf('month'), moment().endOf('month')],
             'This Year': [moment().startOf('year'), moment().endOf('year')]
          }
      };

    var initialRange = todayRange;
    var initialRangeLabel = 'Today';

    var selectedRange = getUrlVars()['range'];

    if (selectedRange) {
        initialRangeLabel = decodeURIComponent(getUrlVars()['label']);
        if (dateRangePickerDefaults.ranges[initialRangeLabel])
            initialRange = dateRangePickerDefaults.ranges[initialRangeLabel];
        else {
            var selectedRangeArr = selectedRange.split('_');
            initialRange = [moment(parseInt(selectedRangeArr[0])), moment(parseInt(selectedRangeArr[1]))];
        }
    } else {
        initialRangeLabel = 'All Time';
    }

    dateRangePickerDefaults = $.extend(dateRangePickerDefaults, {
          startDate: initialRange[0],
          endDate: initialRange[1]
    });

    function cb(start, end, label, isFirst) {

        var hiddenRangeVal = [start.valueOf(), end.valueOf()].join(RANGE_SEPERATOR);
        var redirectUrl = '/?range=' + hiddenRangeVal;

        if (label == 'Custom Range') {
        var visibleText = start.format('D MMM YYYY') + ' - ' + end.format('D MMM YYYY');
          $('.todoFilterWrapper input[type=text]').val(visibleText);
          redirectUrl += '&label=' + visibleText;
        }
        else {
          $('.todoFilterWrapper input[type=text]').val(label);
          redirectUrl += '&label=' + label;
        }

        $('.todoFilterWrapper input[type=hidden]').val(hiddenRangeVal);

        if (!isFirst) {
            location.href = redirectUrl;
        }
    }

    $('#todoFilter input, #todoFilter button').daterangepicker(dateRangePickerDefaults, function(start, end, label) {
        cb(start, end, label, false);
    });

    $('#todoAddFilter input, #todoAddFilter button').daterangepicker(dateRangePickerDefaults, function(start, end, label) {
        cb(start, end, label, true);
    });

    cb(initialRange[0], initialRange[1], initialRangeLabel, true);
});

function deleteTodo(todoId, $this) {

    $.post('/todo/delete/' + todoId, {
        _csrf: getCsrfToken()
    }, function(res) {
        location.href = '/';
    });
}

function getCsrfToken() {
    return $('input[name=_csrf]').val();
}

// Read a page's GET URL variables and return them as an associative array.
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}