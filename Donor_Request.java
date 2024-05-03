public class Donor_Request {
    private int requestID;
    private String requestType;
    private String requestDate;

    private String requestStatus;
    public Donor_Request(){}

    public Donor_Request(int requestID,String requestType, String requestDate, String requestStatus){
        this.requestID = requestID;
        this.requestType = requestType;
        this.requestDate = requestDate;
        this.requestStatus = requestStatus;

    }

    public void changeRequestStatus(String Status){
        requestStatus = Status;
    }

    public int returenID(){
        return requestID;
    }

    public String toString(){
        return(requestID+ ","+ requestType + ","+requestDate+","+requestStatus+"\n");
    }
}
