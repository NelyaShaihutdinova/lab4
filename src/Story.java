
import abstracts.*;
import enums.*;
import sceneObjects.*;

public class Story {
    public static void main(String[] args) {
        Hero spruts = new Hero("Спрутс", new Pants("Штаны", Clear.CLEAR),0, Permafrost.CHILLY, ListOfDuties.COOKING, ListOfDuties.KNEADTHEDOUGH, ListOfDuties.KINDLEAFIRE);
        Hero salesman = new Hero("Продавец", null, 0, null, ListOfDuties.SELLPRODUCTS);
        Hero stranger = new Hero("Незнакомец", null, 0, null, ListOfDuties.DELIVERYFOOD, ListOfDuties.COOKING, ListOfDuties.DIRECTTHEWORK);
        Location market = new Market("Рынок");
        spruts.changeLocation(market);
        salesman.joke(spruts);
        spruts.angerLevelInfo();
        Home home = new Home("Дом");
        spruts.changeLocation(home);
        Home.Door door = home.new Door("Дверь");
        stranger.knock(door);
        Home.Stairs stairs = new Home.Stairs();
        spruts.comeDown(stairs);
        spruts.open(door);
        Hero julio = new Hero("Джулио", null,0, Permafrost.CHILLY, ListOfDuties.DELIVERYFOOD, ListOfDuties.COOKING, ListOfDuties.DIRECTTHEWORK);
        stranger.introduceYourself(julio);
        Room kitchen = new Kitchen("Кухня");
        spruts.changeRoom(kitchen);
        julio.changeRoom(kitchen);
        Kindeble stove = new Kindeble() {
            @Override
            public void kindle() {
                CanBroke chair1 = new Chair("Стул 1", kitchen, Brokenness.NOTBROKEN);
                CanBroke chair2 = new Chair("Стул 2", kitchen, Brokenness.NOTBROKEN);
                spruts.broke(chair1, chair2);
                System.out.println("Stove is fire up");
            }
        };
        stove.kindle();
        CanBroke egg = new Egg("Яйцо");
        spruts.broke(egg);
        RowFood[] food = {new Egg("Яйцо"), new Egg("Яйцо"), new Egg("Яйцо") , new Egg("Яйцо"), new Egg("Яйцо"), new Egg("Яйцо")};
        spruts.takeRowFood(food);
        spruts.pourOut(spruts.getClothes(), (CanBePourOut) egg);
        julio.think(spruts);
        julio.takeAway(spruts);
        TableWare pan = new FryingPan("Сковорода", kitchen, Size.BIG);
        julio.chooseTableWare(pan);
        julio.cookScramble();
        Dish scramble = new Scramble("Яичница");
        Sittable chair3 = new Chair("Стул 3", kitchen, Brokenness.NOTBROKEN);
        Sittable chair4 = new Chair("Стул 4", kitchen, Brokenness.NOTBROKEN);
        spruts.sit(chair3);
        julio.sit(chair4);
        julio.eat(scramble);
        spruts.eat(scramble);
        spruts.thinkAboutLifeWithSbd(julio);
        spruts.suggest(Suggestions.LIVETOGETHER, julio);
        spruts.setLifeSatisfaction(LifeSatisfaction.SATISFACTION);
        spruts.sleep();
        julio.sleep();
        try {
            spruts.watchTV("CABBAGE");
        } catch (AngerLevelExcessException e){
            System.out.println(e.getMessage());
        }
        try {
            julio.watchTV("CUCUMBERS");
        } catch (AngerLevelExcessException e){
            System.out.println(e.getMessage());
        }
        spruts.angerLevelInfo();
        julio.angerLevelInfo();
    }
}
