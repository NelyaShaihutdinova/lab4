package sceneObjects;

import abstracts.*;
import enums.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Hero {
    private String name;
    private Room room;
    private ArrayList<ListOfDuties> duties;
    private LifeSatisfaction lifeSatisfaction;
    private Sittable sittable;
    private Suggestions suggestion;
    private Clothes clothes;
    private ArrayList<RowFood> rowFood;
    private TableWare tableWare;
    private Permafrost permafrost;
    private int angerLevel;
    private Location location;

    public Hero(String name, Clothes clothes, int angerLevel, Permafrost permafrost, ListOfDuties... duties) {
        this.name = name;
        this.clothes = clothes;
        this.angerLevel = angerLevel;
        this.permafrost = permafrost;
        this.duties = new ArrayList<>();
        this.rowFood = new ArrayList<>();
        this.duties.addAll(Arrays.asList(duties));
    }

    public String getName() {
        return name;
    }

    public void setLifeSatisfaction(LifeSatisfaction lifeSatisfaction) {
        this.lifeSatisfaction = lifeSatisfaction;
        System.out.println(lifeSatisfaction.getName());
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void changeRoom(Room room) {
        System.out.println(name + " go to the " + room.getName());
        this.room = room;
    }

    public void broke(CanBroke... canBrokes) {
        for (CanBroke canBroke : canBrokes) {
            System.out.println(name + " brake " + canBroke.getName());
            canBroke.broke(Brokenness.BROKEN);
        }
    }


    public void pourOut(WherePourOut wherePourOut, CanBePourOut canBePourOut) {
        System.out.println(name + " pour out " + canBePourOut.getName() + " in " + wherePourOut.getName());
        if (wherePourOut instanceof Clothes) {
            Clothes cl = (Clothes) wherePourOut;
            cl.setClear(Clear.NOTCLEAR);
        }
    }

    public void think(Hero hero) {
        if (hero.getClothes().getClear() == Clear.NOTCLEAR) {
            System.out.println(this.name + " thinks: " + hero.getName() + " has a problem. I want to have a dinner");
        } else {
            System.out.println(hero.getName() + " is good boy");
        }
    }

    public void takeAway(Hero hero) {
        System.out.println(name + " take away food of " + hero.name);
        this.rowFood = hero.rowFood;
        hero.rowFood = null;
    }

    public void takeRowFood(RowFood... food) {
        System.out.println(name + " take food");
        this.rowFood.addAll(Arrays.asList(food));
    }

    public void open(Home.Door door){
        System.out.println(name + " open " + door.getName());
    }

    public void chooseTableWare(TableWare tableWare) {
        if (tableWare.getSize() == Size.BIG) {
            System.out.println(name + " choose tableWare " + tableWare.getName());
            this.tableWare = tableWare;
        } else {
            System.out.println("This Tableware isn't correct");
        }
    }

    public void sit(Sittable sittable) {
        this.sittable = sittable;
        System.out.println(name + " sat on " + sittable.getName());
    }

    public void breakEggsForScramble() {
        for (RowFood egg : rowFood) {
            System.out.println(name + " brake " + egg.getName());
            egg.broke(Brokenness.BROKEN);
        }
    }

    public void putEggsToTableWare() {
        for (RowFood egg : rowFood) {
            System.out.println(name + " pour out " + egg.getName() + " in " + tableWare.getName());
        }
    }

    @Override
    public String toString() {
        return "Hero: " + name;
    }

    @Override
    public int hashCode() {
        int result = this.getName() == null ? 0 : this.getName().hashCode();
        return (result + 31);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ((Hero) obj).name.equals(name);
    }

    public void cookScramble() {
        this.breakEggsForScramble();
        this.putEggsToTableWare();
    }

    public void eat(Dish dish) {
        System.out.println(name + " eats " + dish.getName());
    }

    public void thinkAboutLifeWithSbd(Hero hero) {
        if (hero.duties.contains(ListOfDuties.COOKING) && hero.duties.contains(ListOfDuties.DELIVERYFOOD)) {
            System.out.println("Life with " + hero.name + " is good");
        }
    }

    public void suggest(Suggestions suggestion, Hero hero) {
        this.suggestion = suggestion;
        System.out.println(name + ": I want to live with " + hero.name);
    }

    public void sleep() throws FreezingException{
        class Box{
            private String name;
            public Box(String name) {
                this.name = name;
            }
            public String getName() {
                return name;
            }
        }
        Box box = new Box("Сундук");
        if(this.permafrost!=Permafrost.FREEZING){
            if (this.permafrost == Permafrost.CHILLY) {
                System.out.println(this.name + " sleep in " + box.getName());
            } else {
                System.out.println("It's too hot to sleep in" + box.getName());
            }
        }else{
            throw new FreezingException("Покиньте город. Слишком холодно!");
        }
    }

    public void joke(Hero hero){
        System.out.println(name + " joke about " + hero.name);
        hero.angerLevel = hero.angerLevel + 5;
    }

    public void angerLevelInfo() {
        if ((this.angerLevel > 4) && (this.angerLevel <= 9)) {
            System.out.println(name + " is angry");
        } else if (this.angerLevel > 9) {
            System.out.println(name + " is furious");
        }
    }

    public void knock(Home.Door door) {
        System.out.println(name + " knock on " + door.getName());
    }

    public void comeDown(Home.Stairs stairs) {
        System.out.println(name + " come down the " + stairs.getName());
    }

    public void changeLocation(Location location) {
        System.out.println(name + " go to the " + location.getName());
        this.location = location;
    }

    public void introduceYourself(Hero hero){
        System.out.println(name + ": I'm " + hero.getName());
    }
    public void watchTV(String tvProgramm) throws AngerLevelExcessException{
        boolean isAnnoying = true;
        try {
            TVProgramms.valueOf(tvProgramm);
        }
        catch (IllegalArgumentException e){
            isAnnoying = false;
        }
        if (this.angerLevel < 95) {
            if (isAnnoying) {
                this.angerLevel += 5;
            }
        }
        else{
            throw new AngerLevelExcessException(this.name + "слишком раздражен, чтобы смотреть телевизор");
        }
    }
}

