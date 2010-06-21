if(typeof(logging) == "undefined"){
    logging = {};
}
if(typeof(logging.DetailsLink) == "undefined"){
    logging.DetailsLink = {

        //        EXPANDED_CLASS: "change_details_expanded",

        details: function(event){
            var detailsLink = $(event.target);

            detailsLink.closest(".logging_DetailsLink").find(".message").each(function(index, element){
                var message = $(element);
                if(message.css("display") == "none"){
                    message.show();
                } else {
                    message.hide();
                }
            });

            var detailsRow = logging.DetailsLink.getDetailsRow(detailsLink);
            var details = logging.DetailsLink.getDetailsSection(detailsRow);

            var isHidden = logging.DetailsLink.isHidden(detailsRow);
            logging.DetailsLink.log("display : "+detailsRow.css("display")+", is hidden : "+isHidden);

            if(isHidden){
                detailsRow.show();
                //                logging.DetailsLink.switchVisibility(detailsRow);
                details.toggle('drop', {}, 1000);
            } else {
                details.toggle('drop', {}, 1000, function(){
                    //                    logging.DetailsLink.switchVisibility(detailsRow);
                    detailsRow.hide();
                });
            }            
            
            return false;
        },

        isHidden: function(detailsRow){
            return $(detailsRow).is(":hidden");
        //            return !$(detailsRow).hasClass(logging.DetailsLink.EXPANDED_CLASS);
        },

        //        switchVisibility: function(detailsRow){
        //            $(detailsRow).toggleClass(logging.DetailsLink.EXPANDED_CLASS);
        //        },

        getDetailsSection: function(detailsRow){
            return $(detailsRow).find(".logging_DetailsPanel");
        },
        
        getDetailsRow: function(detailsLink){
            return $(detailsLink).closest('tr').next();
        },
        
        isDebugEnabled: false,

        log: function(message){
            if(logging.DetailsLink.isDebugEnabled){
                if(typeof(console) != "undefined"){
                    console.log(message);
                } else {
                    alert(message);
                }
            }
        }
    }
}

$(document).ready(function(){
    $(".logging_DetailsLink").each(function(index, detailsLink){
        logging.DetailsLink.getDetailsSection(logging.DetailsLink.getDetailsRow(detailsLink)).hide();
        $(detailsLink).click(logging.DetailsLink.details);
    });
});