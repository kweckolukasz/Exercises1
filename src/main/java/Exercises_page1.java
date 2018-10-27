import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Exercises_page1 {

    public int exercise1(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[i]==ints[j]&&i!=j) {
                    System.out.println("repeated number: " + ints[j] + " in index: " + i + " and index: " + j);
                    return ints[j];
                }
            }
        }
        System.out.println("no repeated numbers.");
        return -1;
    }

    public ArrayList<Integer> exercise2(int toDelete, int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        boolean modificationDone=true;
        boolean numToDeleteExists=true;
        System.out.println("arrayListGiven: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+", ");
        }
        System.out.println();

        while(modificationDone==true) {
            modificationDone=false;
            for (int i = arrayList.size()-1; i > 0; i--) {
                if (arrayList.get(i)<arrayList.get(i-1)){
                    int temp = arrayList.get(i-1);
                    arrayList.remove(i-1);
                    arrayList.add(i,temp);
                    modificationDone = true;
                }
            }

        }
        System.out.println("arrayListSorted without "+"number to be deleted: "+toDelete+": ");

        while(numToDeleteExists==true) {
            numToDeleteExists = false;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i)==toDelete){
                    arrayList.remove(i);
                    numToDeleteExists=true;
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+", ");
        }
        return arrayList;
    }

    public int exercise3(int[] arr){
        int sum=0;
        int zeroPalidrome = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack();


        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
            stack.push(arr[i]);
            sum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            zeroPalidrome = arr[i] - stack.pop();
        }
        System.out.println(zeroPalidrome);

        return zeroPalidrome;
    }

    public int exercise4(int k,int n){
        if (k==0||n==0) return 0;
        int modulo;
        if (k==n) return k;
        else if (k>n){
            modulo = k%n;
            if (modulo==0) return n;
            while (modulo!=0){
                if (modulo==0) return n;
                        int modulo2 = n % modulo;
                        if (n%modulo2==0) return modulo2;
                        modulo = modulo2;
            }
        }
        else if (n>k){
            modulo = n%k;
            if (modulo==0) return k;
            while (modulo!=0){
                if (modulo==0) return k;
                int modulo2 = k % modulo;
                if (k%modulo2==0) return modulo2;
                modulo = modulo2;
            }
        }
        return 0;
    }

    public int exercise5(int[] T){
        int[] TClone = T.clone();
        int[] L = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int numOfRepeats = 0;
            for (int j = 0; j < TClone.length; j++) {
                if (T[i]==TClone[j]){
                    numOfRepeats++;
                }
            }
            L[i] = numOfRepeats;
        }

        int dominantaValue = 0;
        int maxRepeats = 0;
        for (int i = 1; i < L.length; i++) {
            if (L[i]>=L[i-1]&&L[i]>=maxRepeats){
                maxRepeats = L[i];
                dominantaValue = T[i];
            }
        }
        System.out.println("dominanta: "+dominantaValue);
        return dominantaValue;
    }

    public int exercise6(Calendar date) {
        int day = date.get(Calendar.DAY_OF_MONTH);
        int year = date.get(Calendar.YEAR);
        int daysFromOderMonths = 0;
        switch (date.get(Calendar.MONTH)) {
            case 12: daysFromOderMonths = 334;
                break;
            case 11: daysFromOderMonths = 304;
                break;
            case 10: daysFromOderMonths = 273;
                break;
            case 9:daysFromOderMonths = 243;
                break;
            case 8:daysFromOderMonths = 212;
                break;
            case 7:daysFromOderMonths = 181;
                break;
            case 6:daysFromOderMonths = 151;
                break;
            case 5:daysFromOderMonths = 120;
                break;
            case 4:daysFromOderMonths = 90;
                break;
            case 3:daysFromOderMonths = 59;
                break;
            case 2: daysFromOderMonths = 31;
                break;
        }
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) daysFromOderMonths++;
        daysFromOderMonths += day;
        return daysFromOderMonths;
    }

    //TODO wysypie się gdy: instalmentAmount zmiennoprzecinkowa
    public BigDecimal exercise7(BigDecimal price, int instalmentAmount){

        if (price.intValue()<100 && price.intValue()>10000) {
            System.out.println("price must be between 100 PLN and 10 000 PLN");
            return null;
        }

        if (instalmentAmount<6&&instalmentAmount>48) {
            System.out.println("too short or too long duration of credit, must be from 6 monhs to 48 months");
            return null;
        }

        BigDecimal rateOfInterestPercentage;
            rateOfInterestPercentage = new BigDecimal(0);
        if (instalmentAmount>=6&&instalmentAmount<=12) {
            rateOfInterestPercentage = new BigDecimal("1.025");
        }
        else if (instalmentAmount>=13&&instalmentAmount<=24) {
            rateOfInterestPercentage = new BigDecimal("1.05");
        }
        else if (instalmentAmount>=13&&instalmentAmount<=24) {
            rateOfInterestPercentage = new BigDecimal("1.1");
        }
        BigDecimal instalmentAmountBig = new BigDecimal(instalmentAmount);

        BigDecimal rateValue = (price.multiply(rateOfInterestPercentage)).divide(instalmentAmountBig,2,RoundingMode.HALF_UP);

        return rateValue;


    }
}
