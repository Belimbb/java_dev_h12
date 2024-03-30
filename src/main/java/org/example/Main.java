package org.example;

import org.example.Entities.Client;
import org.example.Entities.Planet;
import org.example.service.Client.ClientCrudServiceImpl;
import org.example.service.FlyWayService;
import org.example.service.Planet.PlanetCrudServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FlyWayService flyway = FlyWayService.getInstance();
        flyway.migrate("src/main/resources/hibernate.properties");

        Client client = new Client();
        client.setName("TestClient");
        client.setId(11L);

        ClientCrudServiceImpl clientService = new ClientCrudServiceImpl();
        clientService.create(client);

        client.setName("BetaClient");

        clientService.update(client);
        clientService.delete(client);

        System.out.println("All clients");
        for (Client client1 : clientService.getAll()) {
            System.out.println(client1);
        }


        Planet planet = new Planet();
        planet.setId("TPL");
        planet.setName("Test planet");

        PlanetCrudServiceImpl planetService = new PlanetCrudServiceImpl();
        planetService.create(planet);

        planet.setName("Beta planet");

        planetService.update(planet);
        planetService.delete(planet);

        System.out.println("\nAll planets");
        for (Planet planet1 : planetService.getAll()) {
            System.out.println(planet1);
        }

    }
}