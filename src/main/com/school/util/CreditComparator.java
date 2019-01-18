package school.util;

import school.bean.Credit;

import java.util.Comparator;

public class CreditComparator implements Comparator<Credit> {
 
    public int compare(Credit c1, Credit c2) {
        //return bc1.para-bc2.para; //升序
        return c2.getCredit()-c1.getCredit(); //降序
    }
}
