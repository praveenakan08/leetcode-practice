// TODO revise
import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>(); // Ingredient to recipes map
        Map<String, Integer> inDegree = new HashMap<>(); // Recipe in-degree count
        Set<String> available = new HashSet<>(Arrays.asList(supplies)); // Set of available ingredients
        Queue<String> queue = new LinkedList<>();

        // Initialize in-degree and adjacency list
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); // Count required ingredients

            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe); // Dependency mapping
            }
        }

        // Add initially available supplies to the queue
        for (String supply : supplies) {
            queue.offer(supply);
        }

        List<String> result = new ArrayList<>();
        
        // Process queue (BFS)
        while (!queue.isEmpty()) {
            String item = queue.poll();
            
            if (inDegree.containsKey(item) && inDegree.get(item) == 0) { // If it's a valid recipe
                result.add(item);
            }

            // Reduce in-degree for dependent recipes
            if (graph.containsKey(item)) {
                for (String recipe : graph.get(item)) {
                    inDegree.put(recipe, inDegree.get(recipe) - 1);
                    if (inDegree.get(recipe) == 0) {
                        queue.offer(recipe); // Ready to be cooked
                    }
                }
            }
        }

        return result;
    }
}
