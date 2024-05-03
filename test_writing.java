import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class test_writing {
    public static void main(String[] args) throws IOException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        //Donor_Request d1 = new Donor_Request(111,"UpdatePersonalInfo",currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Pending");
        //Donor_Request d2 = new Donor_Request(222,"UpdatePersonalInfo",currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Pending");
        ArrayList<Donor_Request> DRs = new ArrayList<>();
        File fileName = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Donor_Requests.txt");
        System.out.println(fileName.length());
        // File empty
        if(fileName.length() == 0){
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            System.out.println("Info has been writtin in the text file");
            printWriter.close();
        }
        else{
            Scanner sc = new Scanner (fileName);
            sc.useDelimiter(",|\\n");
            int requestID = 0;
            String requestType = "";
            String requestDate = "";
            String requestStatus = "";
            int treaker =0;
            while (sc.hasNext ()) {
                if(treaker ==0 && sc.hasNext()){
                    System.out.println("Tracker = "+treaker);
                    requestID = Integer.parseInt(sc.next());
                    System.out.println(requestID);
                    treaker++;
                }
                else if(treaker == 1 && sc.hasNext()){
                    System.out.println("Tracker = "+treaker);
                     requestType = sc.next();
                    System.out.println(requestType);
                    treaker++;
                }
                else if(treaker == 2 && sc.hasNext()){
                    System.out.println("Tracker = "+treaker);
                    requestDate = sc.next();
                    System.out.println(requestDate);
                    treaker++;
                }
                else if(treaker == 3 && sc.hasNext()){
                    System.out.println("Tracker = "+treaker);
                    requestStatus = sc.next();
                    DRs.add(new Donor_Request(requestID,requestType,requestDate,requestStatus));
                    System.out.println(requestStatus);
                    treaker = 0;
                }

            }
            DRs.add(new Donor_Request(112,"UpdateMedicalHistory",currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Pending"));
            int i = 0;
               while(i< DRs.size()){
                    System.out.println(DRs.get(i).toString());
                    i++;

                }
            sc.close ();


        }

    }

}

