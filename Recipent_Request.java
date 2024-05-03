public class Recipent_Request {
    private int requestID;
    private String requestType;

    private String requestDate;

    private  String requestStatus;

    private String blood_Type;

    public Recipent_Request(){};

    public Recipent_Request(int requestID, String requestType, String requestDate, String requestStatus, String blood_Type){
        this.requestID = requestID;
        this.requestType = requestType;
        this.requestDate = requestDate;
        this.requestStatus = requestStatus;
        this.blood_Type = blood_Type;
    }
    public int returnID(){
        return requestID;
    }

    public void changeRewuestStatus(String newStatus){
        this.requestStatus = newStatus;
    }

    public String toString(){
        return (requestID+ ","+requestType+","+requestDate+","+requestStatus+","+blood_Type+"\n");
    }



}
