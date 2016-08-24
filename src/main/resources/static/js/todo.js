$(function() {

    var todayRange =  [moment(), moment().endOf('day')];

    function cb(start, end, label, isFirst) {
        if (label == 'Custom Range')
          $('.todoFilterWrapper input[type=text]').val(start.format('D MMM YYYY') + ' - ' + end.format('D MMM YYYY'));
        else {
          $('.todoFilterWrapper input[type=text]').val(label);
        }

        var hiddenRangeVal = [start.valueOf(), end.valueOf()].join('_');

        $('.todoFilterWrapper input[type=hidden]').val(hiddenRangeVal);

        if (!isFirst)
            location.href = '/?range=' + hiddenRangeVal;
    }

    $('.todoFilterWrapper input, .todoFilterWrapper button').daterangepicker({
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
           'This Week': [moment(), moment().endOf('week')],
           'Next Week': [moment().add(1, 'weeks').startOf('week'), moment().add(1, 'weeks').endOf('week')],
           'This Month': [moment(), moment().endOf('month')],
           'This Year': [moment(), moment().endOf('year')]
        }
    }, cb);

    cb(todayRange[0], todayRange[1], 'Today', true);
});

    function deleteTodo(todoId, $this) {

        $.post('/todo/delete/' + todoId, {
            _csrf: getCsrfToken()
        }, function(res) {
            $($this).parents('.media').slideUp('slow', function() {
                location.href = '/';
            });
        });
    }

    function getCsrfToken() {
        return $('input[name=_csrf]').val();
    }