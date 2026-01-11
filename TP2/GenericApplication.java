public class GenericApplication {
    public static void main(String[] args) {
        GenericStorage<Integer> intStore = new GenericStorage<>();
        intStore.addElement(10);
        intStore.addElement(20);
        System.out.println("Integer storage: " + intStore + " Size: " + intStore.getSize());

        GenericStorage<String> strStore = new GenericStorage<>();
        strStore.addElement("Hello");
        strStore.addElement("World");
        System.out.println("String storage: " + strStore + " Size: " + strStore.getSize());

        GenericStorage<Double> dblStore = new GenericStorage<>();
        dblStore.addElement(3.14);
        dblStore.addElement(2.718);
        System.out.println("Double storage: " + dblStore + " Size: " + dblStore.getSize());

        System.out.println("Get element 1 from String storage: " + strStore.getElement(1));
    }
}