package businessobjects;

public class NominationDetails {
    private String awardTitle;
    private String awardMessage;
    private String mesageToApprover;

    public String getAwardTitle() {
        return awardTitle;
    }

    public void setAwardTitle(String awardTitle) {
        this.awardTitle = awardTitle;
    }

    public String getAwardMessage() {
        return awardMessage;
    }

    public void setAwardMessage(String awardMessage) {
        this.awardMessage = awardMessage;
    }

    public String getMesageToApprover() {
        return mesageToApprover;
    }

    public void setMesageToApprover(String mesageToApprover) {
        this.mesageToApprover = mesageToApprover;
    }
}
