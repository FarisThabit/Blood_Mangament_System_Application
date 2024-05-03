import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class testDataBase {
    public static void main(String[] args) throws SQLException, IOException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Donor_Request d1 = new Donor_Request(111,"UpdatePersonalInfo",currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Pending");
        Donor_Request d2 = new Donor_Request(222,"UpdatePersonalInfo",currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Pending");
        ArrayList<Donor_Request> DRs = new ArrayList<>();
        DRs.add(d1);
        DRs.add(d1);
        DRs.add(d1);
        DRs.add(d1);
        DRs.add(d1);
        DRs.add(d1);
        DRs.add(d1);
        DRs.add(d2);
       // int i = 0;
        String filename = "Donor_Requests.txt";
        String information = "This is some information to be written to the file.";
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(information);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }





      /*  Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
        );

        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("Select DMRN from donor " +
                "where ID = "+Show_And_Update_Medical_History.RDID );
        //System.out.println( resultset.getInt("DMRN"));

        if(resultset.next()) {
            System.out.println(resultset.getInt("DMRN"));

        } else {
            System.out.println("No results found.");*/
        }


        // Requesting data from the database


        // Writing data to the data from the database

           /* Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321");
            Statement statement2 = co.createStatement();
        //int MRN = Integer.parseInt(tf3.getText());
        String sqlCommand = "insert into medical_history values("+111+",'"+123+",'"+"s"+"','"+"d"+"','"+"f"+"','"+ "no"+"')";*/
       // System.out.println("',"+0+",'"+"Online'");





       /*Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
        );
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("Select ID from donor" );
        while (resultset.next()){
           // System.out.println(resultset.getString("ID"));
            if("0".equals(resultset.getString("ID"))){
                System.out.println("Found");
            }


            }

}*/



