package org.example.service.Planet;

import org.example.Entities.Planet;

import java.util.List;

public interface PlanetCrudService {
    void create (Planet planet);
    Planet getById (String planetId);
    List<Planet> getAll ();
    void update (Planet client);
    void delete (Planet client);
}
