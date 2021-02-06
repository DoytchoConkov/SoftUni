import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, Integer> materials = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        boolean isReady = false;
        while (!isReady) {
            String[] token = scan.nextLine().split(" ");
            for (int i = 0; i < token.length - 1; i += 2) {
                String materialToLowerCase = token[i + 1].toLowerCase();
                if (materialToLowerCase.equals("shards") || materialToLowerCase.equals("fragments") || materialToLowerCase.equals("motes")) {
                    addItems(materials, materialToLowerCase, token[i]);
                    if (materials.get(materialToLowerCase) >= 250) {
                        switch (materialToLowerCase) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                materials.put(materialToLowerCase, materials.get(materialToLowerCase) - 250);
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                materials.put(materialToLowerCase, materials.get(materialToLowerCase) - 250);
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                materials.put(materialToLowerCase, materials.get(materialToLowerCase) - 250);
                                break;
                        }
                        isReady = true;
                        break;
                    }
                } else {
                    addItems(junk, materialToLowerCase, token[i]);
                }
            }
        }
        materials
                .entrySet()
                .stream()
                .sorted((q1, q2) -> q2.getValue().compareTo(q1.getValue()))
                .forEach(e -> System.out.println(String.format("%s: %d", e.getKey(), e.getValue())));
        junk
                .forEach((k, v) -> {
                    System.out.printf("%s: %d%n", k, v);
                });
    }

    private static void addItems(TreeMap<String, Integer> map, String material, String quant) {
        map.putIfAbsent(material, 0);
        map.put(material, map.get(material) + Integer.parseInt(quant));
    }
}
