package com.samuelbeck.codilitytests;

import org.junit.Test;

import java.util.*;

/*
 * Created by samueljbeck on 4/11/19.
 */
public class HackerRankTest {
//Given an unsorted array of elements, find if the element k is present in the array or not

    @Test
    public void searchTest() {
        /*System.out.println(findNumber(Arrays.asList(5,3,4,5), 2));

        System.out.println(findNumber(Arrays.asList(5,3,4,5), 5));

        System.out.println(oddNumbers(3,9));*/

        ArrayList<List<String>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList("5"));
        inputs.add(Arrays.asList("5"));
        inputs.add(Arrays.asList("1", "FTE", "George", "75000", "X"));
        inputs.add(Arrays.asList("2", "FTE", "Stephan", "50000", "X"));
        inputs.add(Arrays.asList("3", "Manager", "Veronica", "2,4", "X5"));
        inputs.add(Arrays.asList("4", "Manager", "Christopher", "1,5", "X"));
        inputs.add(Arrays.asList("5", "FTE", "Mary", "100000", "X"));


        System.out.println(newSortedListOfSalariesManager(inputs));


    }

    private String findNumber(List<Integer> arr, int k) {
        return arr.contains(k) ? "YES": "NO";

    }

    private List<Integer> oddNumbers (int l, int r) {
        List<Integer> numbers = new ArrayList<Integer>();

        for (; l <= r ; l++) {
            if (l % 2 != 0)
                numbers.add(l);
        }

        return numbers;
    }

    private List<Integer> sortedListOfSalaries(List<List<String>> workers) {
        List<Integer> salaries = new ArrayList<Integer>();

        for (List<String> worker :workers) {
            if (worker.get(1).equals("Contractor")) {
                salaries.add(Integer.valueOf(worker.get(3)) * Integer.valueOf(worker.get(4)) * 52);
            } else {
                salaries.add(Integer.valueOf(worker.get(3)));
            }
        }
        Collections.sort(salaries);
        
        return salaries;
    }

    private List<Integer> sortedListOfSalariesManager(List<List<String>> workers) {
        HashMap<String, Integer> salaries = new HashMap<>();

        boolean rerun = false;
        do {
            rerun = false;
            for (List<String> worker : workers) {
                try {
                    if (worker.get(1).equals("Contractor")) {
                        salaries.put(worker.get(0), Integer.valueOf(worker.get(3)) * Integer.valueOf(worker.get(4)) * 52);
                    } else if (worker.get(1).equals("FTE")) {
                        salaries.put(worker.get(0), Integer.valueOf(worker.get(3)));
                    } else {
                        Integer managerSalary = 0;
                        Boolean calculated = true;
                        String[] reports = worker.get(3).split(",");
                        for (String report : reports) {
                            if (salaries.containsKey(report) && salaries.get(report) > 0) {
                                managerSalary = managerSalary + salaries.get(report);
                            } else {
                                managerSalary = 0;
                                rerun = true;
                                break;
                            }
                        }
                            salaries.put(worker.get(0), managerSalary);

                    }
                } catch (Exception err) {

                }
            }
        } while (rerun);
        List<Integer> salaryReturn = new ArrayList<>(salaries.values());
        Collections.sort(salaryReturn);
        return salaryReturn;
    }

    private List<Integer> newSortedListOfSalariesManager(List<List<String>> workers) {
        HashMap<String, Integer> salaries = new HashMap<>();
        ArrayList<List<String>> managerRexamine = new ArrayList<>();

        for (List<String> worker : workers) {
            if (worker.size() < 2) {
                continue;
            }
            switch (worker.get(1)) {
                case "Contractor":
                    salaries.put(worker.get(0), Integer.valueOf(worker.get(3)) * Integer.valueOf(worker.get(4)) * 52);
                    break;
                case "FTE":
                    salaries.put(worker.get(0), Integer.valueOf(worker.get(3)));
                    break;
                default:
                    Integer managerSalary = 0;
                    String[] reports = worker.get(3).split(",");
                    for (String report : reports) {
                        if (salaries.containsKey(report) && salaries.get(report) > 0) {
                            managerSalary = managerSalary + salaries.get(report);
                        } else {
                            ArrayList<String> rexamine = new ArrayList<>(worker);
                            rexamine.add(report);
                            managerRexamine.add(rexamine);
                        }
                    }
                    salaries.put(worker.get(0), managerSalary);
                    break;

            }
        }

        for (List<String> worker : managerRexamine) {
            Integer managerSalary = salaries.get(worker.get(0));
            String report = worker.get(5);
            if (salaries.containsKey(report) && salaries.get(report) > 0) {
                managerSalary = managerSalary + salaries.get(report);
            }
            salaries.put(worker.get(0), managerSalary);
        }

        List<Integer> salaryReturn = new ArrayList<>(salaries.values());
        Collections.sort(salaryReturn);
        return salaryReturn;
    }




}
