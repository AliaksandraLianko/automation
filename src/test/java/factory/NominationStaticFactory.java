package factory;

import businessobjects.NominationDetails;

public class NominationStaticFactory {

    public static NominationDetails populateNomination() {
        NominationDetails nominationDetails = new NominationDetails();
        nominationDetails.setAwardTitle("Test award title");
        nominationDetails.setAwardMessage("Test message to recipient");
        nominationDetails.setMesageToApprover("Test message for approver");
        return nominationDetails;
    }
}
