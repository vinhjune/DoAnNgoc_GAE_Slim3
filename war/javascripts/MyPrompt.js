$(function () {

    $('.EnableDisableHandler a , .EnableDisableHandler input:submit , .EnableDisableHandler input:button ')
        .live('click', function (e, x) {
            var diss = this;

            if (!x) {
                e.preventDefault();

                var question = $(diss).attr('data-question') || 'Are You sure you want to delete the item?';
                $.prompt(question, {
                    buttons: { 'yes': true, 'No': false },
                    focus: 1,
                    overlayspeed: 'fast',
                    callback: function () {
                        if (arguments[0]) {
                            $(diss)
                                .data('forbidden', false)
                                .trigger('click', [true]);
                        }
                    }
                });
            }
            else {
                window.location.href = $(diss).attr('href');
            }
        });
});