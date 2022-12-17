package menu.factory;

import menu.domain.Crew;

public class CrewFactory {
    static public Crew createCrew(String name) {
        return new Crew(name);
    }
}
