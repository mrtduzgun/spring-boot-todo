$(function() {

    var todayRange =  [moment().startOf('day'), moment()];

    function cb(start, end) {
        $('.todoFilterWrapper input').val(start.format('D MMM YYYY') + ' - ' + end.format('D MMM YYYY'));
    }

    $('.todoFilterWrapper input, .todoFilterWrapper button').daterangepicker({
        startDate: todayRange[0],
        endDate: todayRange[1],
        locale: {
          format: 'D MMM YYYY'
        },        
        ranges: {
           'Today': todayRange,
           'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
           'Last 7 Days': [moment().subtract(6, 'days'), moment()],
           'Last 30 Days': [moment().subtract(29, 'days'), moment()],
           'This Month': [moment().startOf('month'), moment().endOf('month')],
           'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        }
    }, cb);
});