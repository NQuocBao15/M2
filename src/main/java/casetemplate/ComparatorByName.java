package casetemplate;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getFullName().compareTo(o2.getFullName()) > 0) {
            return 1;
        } else if (o1.getFullName().compareTo(o2.getFullName()) == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}

//    public static void main(String[] args) {
//        // a, b, c, d
//        String a1 = "aQuang";
//        String a2 = "dQuang";
//        System.out.println(a1.compareTo(a2));       // -3
//
//        System.out.println(a2.compareTo(a1));       // 3
//    }
//}
