import spitterapp.config.DatabaseConfig;
import spitterapp.model.Spitter;
import spitterapp.model.Spittle;
import spitterapp.service.SpitterService;
import spitterapp.service.SplittleService;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        SpitterService spitterService = new SpitterService();
        SplittleService spittleService = new SplittleService();

        Spitter spitter1 = new Spitter(1,"John","Doe","12345");
        Spitter spitter2 = new Spitter(2,"John2","Doe2","56789");

        spitterService.createSpitter(spitter1);
        spitterService.createSpitter(spitter2);


        Spittle spittle1 = new Spittle(1,"hello",1, "1/12/2023");
        Spittle spittle2 = new Spittle(2,"hello",2, "1/12/2023");

        spittleService.createSpittle(spittle1);
        spittleService.createSpittle(spittle2);

        spitter1.addSpittle(spittle1);
        spitter2.addSpittle(spittle2);

        System.out.println(spitterService.getSpitter(1));
        System.out.println(spitterService.getSpitter(2));



    }
}
