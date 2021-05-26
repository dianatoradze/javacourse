public class Main {
    public static void main(String[] args) {
        PhysicalPerson physicalPerson = new PhysicalPerson();
        physicalPerson.put(100);
        physicalPerson.print();
        physicalPerson.put(100);
        physicalPerson.print();
        physicalPerson.take(5000);
        LegalPerson legalPerson = new LegalPerson();
        legalPerson.print();
        legalPerson.take(500);
        legalPerson.print();
        IndividualBusinessman individualBusinessman = new IndividualBusinessman();
        individualBusinessman.print();
        individualBusinessman.put(2000);
        individualBusinessman.print();
        individualBusinessman.take(500);
        individualBusinessman.print();
    }
}
