package be.course.design.polymorphism.benefits.implementations.bad;

import java.util.LinkedList;
import java.util.List;

public class SteakBearnaise {

    private final List<String> ingredients;

    public SteakBearnaise() {
        ingredients = new LinkedList<>();

        ingredients.add("A good steak");
        ingredients.add("Bearnaise");
    }

    public String[] getIngredients() {
        return (String[]) ingredients.toArray();
    }

    public void bake(String how) throws InterruptedException {
        if(how != null) {
            switch(how) {
                case "well done":
                    System.out.println("Put it in the pan until it is well done");
                    Thread.sleep(2500);
                    break;
                case "medium rare":
                    System.out.println("Put it in the pan until it is medium rare");
                    Thread.sleep(1700);
                    break;
                case "rare":
                    System.out.println("Barely put it in the pan");
                    Thread.sleep(1000);
                default:
                    System.out.println("No idea how you want it, so I assume rare...");
                    Thread.sleep(1000);
            }
        }
    }
}
