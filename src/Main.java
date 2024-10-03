import spitterapp.entities.SpitterEnt;
import spitterapp.entities.SpittleEnt;
import spitterapp.service.SpitterService;
import spitterapp.service.SplittleService;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        SpitterService spitterService = new SpitterService();
        SplittleService spittleService = new SplittleService();


        spitterService.createSpitter("John", "Doe", "password123");
        // Read Spitter by ID
        SpitterEnt spitter = spitterService.getSpitter(1);
        System.out.println("Retrieved Spitter: " + spitter.getFirstName());

        spittleService.createSpittle("some content","15/10/2025",spitter);
        // Read Spitter by ID
        SpittleEnt spittle = spittleService.getSpittle(1);
        System.out.println("Retrieved Spittle: " + spittle.getContent());
    }
}
