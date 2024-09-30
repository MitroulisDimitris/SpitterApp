import spitterapp.domain.Spitter;
import spitterapp.domain.Spittle;
import spitterapp.service.SpitterService;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        SpitterService service = new SpitterService();

        Spitter spitter1 = new Spitter(1,"John","Doe","12345");
        Spitter spitter2 = new Spitter(2,"John2","Doe2","56789");

        service.createSpitter(spitter1);
        service.createSpitter(spitter2);

        LocalDateTime now = LocalDateTime.now();

        Spittle spittle1 = new Spittle(1,"hello",1, now);
        Spittle spittle2 = new Spittle(2,"hello",2, now);

        service.createSpittle(spittle1);
        service.createSpittle(spittle2);

        spitter1.addSpittle(spittle1);
        spitter2.addSpittle(spittle2);

        System.out.println(service.getSpitter(1));
        System.out.println(service.getSpitter(2));
    }
}