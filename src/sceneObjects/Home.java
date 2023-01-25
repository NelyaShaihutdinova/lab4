package sceneObjects;

import abstracts.Location;
public class Home extends Location{
    private String name;
    private Door door;
    private Stairs stairs;
    public Home(String name){
        super(name);
    }
    public Home(String name, Door door, Stairs stairs) {
        super(name);
        this.door = door;
        this.stairs = stairs;
    }

    public class Door {
        private String name;
        public Door(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    public static class Stairs {
        private static String name = "Лестница";
        public String getName() {
            return name;
        }
    }
}
