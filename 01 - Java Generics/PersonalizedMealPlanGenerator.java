interface MealPlan {
    String getMealDescription();
}
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealDescription() {
        return "Vegetarian meal plan: Plant-based food, no meat.";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealDescription() {
        return "Vegan meal plan: No animal products, plant-based only.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealDescription() {
        return "Keto meal plan: High fat, low carb diet.";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealDescription() {
        return "High-protein meal plan: Focus on lean meats and protein-rich foods.";
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMealPlan() {
        System.out.println(mealPlan.getMealDescription());
    }
}
public class PersonalizedMealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(T mealPlan) {
        Meal<T> meal = new Meal<>(mealPlan);
        meal.displayMealPlan();
    }

    public static void main(String[] args) {
        VegetarianMeal vegetarian = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();

        System.out.println("Personalized Meal Plans:");
        generateMealPlan(vegetarian);
        generateMealPlan(vegan);
        generateMealPlan(keto);
        generateMealPlan(highProtein);
    }
}