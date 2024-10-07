package spitter_maven;


import spitter_maven.entities.Spitter;
import spitter_maven.entities.Spittle;
import spitter_maven.service.SpitterService;
import spitter_maven.service.SplittleService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SpitterService spitterService = new SpitterService();
        SplittleService spittleService = new SplittleService();


        spitterService.createSpitter("John", "Doe", "password123");
        // Read Spitter by ID
        Spitter spitter = spitterService.getSpitter(1);
        System.out.println("Retrieved Spitter: " + spitter.getFirstName());

        spittleService.createSpittle("some content","15/10/2025",spitter);
        // Read Spittle by ID
        Spittle spittle = spittleService.getSpittle(1);
        System.out.println("Retrieved Spittle: " + spittle.getContent());
    }
}