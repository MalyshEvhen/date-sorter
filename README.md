# DateSorter

DateSorter is a Java class that provides a method to sort a list of LocalDate objects based on a specific sorting logic. The sorting logic is as follows:

1. Dates with an 'r' in the month name (e.g., October, March) are sorted in ascending order (earliest to latest).
2. Dates without an 'r' in the month name (e.g., May, June) are sorted in descending order (latest to earliest).

For example, if the input list is `(2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)`, the sorted output will be `(2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)`.

## Usage

To use the DateSorter class, follow these steps:

1. Create an instance of the `DateSorter` class.
2. Call the `sortDates` method with an unsorted list of `LocalDate` objects as input.
3. The method will return a sorted `Collection` of `LocalDate` objects based on the specified sorting logic.

Example:

```java
    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.List;

    public class Main {
        public static void main(String[] args) {
            var unsortedDates = new ArrayList<>();
            unsortedDates.add(LocalDate.of(2004, 7, 1));
            unsortedDates.add(LocalDate.of(2005, 1, 2));
            unsortedDates.add(LocalDate.of(2007, 1, 1));
            unsortedDates.add(LocalDate.of(2032, 5, 3));

            DateSorter dateSorter = new DateSorter();

            System.out.println(dateSorter.sortDates(unsortedDates));
        }
    }
```


Output:

`[ 2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01 ]`

## Implementation Details

The `sortDates` method uses the `stream` API to sort the input list of `LocalDate` objects based on a custom `Comparator` defined in the `dateComparator` method. The `dateComparator` method compares two `LocalDate` objects based on the sorting logic described above.

The `isMonthContainsR` method is a helper method that checks if the month name of a given `LocalDate` object contains the letter 'r' (case-insensitive).

## How to Run a Quck Test

To run the DateSorter application, switch to `test` branch and execute the CLI command:

 ```sh
    java DateSorter.java
 ```


This will run the main method in `DateSorter` class and execute a test code, which will demonstrate the usage of the `DateSorter` class.
