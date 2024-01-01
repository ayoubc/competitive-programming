class FoodRatings {
    private Map<String, Integer> foodRating;
    private Map<String, String> foodCuisine;
    private Map<String, TreeSet<P>> cuisineMaxRatingFood;
    private class P implements Comparable<P> {
        String food;
        int rating;
        public P(String f, int r) {
            food = f;
            rating = r;
        }
        @Override
        public int compareTo(P o) {
            int c = food.compareTo(o.food);
            if (c == 0) return c;

            int d = Integer.compare(rating, o.rating)*-1;
            if (d == 0) {
                d = c;
            }
            return d;
        }
    }
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineMaxRatingFood = new HashMap<>();
        for(int i=0;i<foods.length;i++) {
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            TreeSet<P> s = cuisineMaxRatingFood.get(cuisines[i]);
            if (s == null) s = new TreeSet<>();
            s.add(new P(foods[i], ratings[i]));
            cuisineMaxRatingFood.put(cuisines[i], s);
        }
    }
    
    public void changeRating(String food, int newRating) {
        P p = new P(food, foodRating.get(food));
        P newP = new P(food, newRating);
        foodRating.put(food, newRating);
        String cuisine = foodCuisine.get(food);
        TreeSet<P> s = cuisineMaxRatingFood.get(cuisine);
        s.remove(p);
        s.add(newP);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMaxRatingFood.get(cuisine).first().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */