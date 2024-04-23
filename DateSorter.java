package sample;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution
 * rather than factors
 * such as speed of processing or other performance-based optimizations, which
 * are less
 * important.
 * <p>
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution
 * rather than factors
 * such as speed of processing or other performance-based optimizations, which
 * are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

  /**
   * The implementation of this method should sort dates.
   * The output should be in the following order:
   * Dates with an 'r' in the month,
   * sorted ascending (first to last),
   * then dates without an 'r' in the month,
   * sorted descending (last to first).
   * For example, October dates would come before May dates,
   * because October has an 'r' in it.
   * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
   * would sort to
   * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
   *
   * @param unsortedDates - an unsorted list of dates
   * @return the collection of dates now sorted as per the spec
   */
  public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
    var start = LocalTime.now();
    var sorted = unsortedDates.stream()
        .sorted(this.dateComparator())
        .toList();
    System.out.println("Stream sort: " + LocalTime.now().minusNanos(start.toNanoOfDay()).toNanoOfDay());
    return sorted;
  }

  private Comparator<LocalDate> dateComparator() {
    return (date1, date2) -> {
      if (isMonthContainsR(date1) && !isMonthContainsR(date2)) {
        return -1;
      } else if (!isMonthContainsR(date1) && !isMonthContainsR(date2)) {
        return date2.compareTo(date1);
      } else {
        return date1.compareTo(date2);
      }
    };
  }

  private boolean isMonthContainsR(LocalDate date) {
    return date.getMonth().toString().toLowerCase().contains("r");
  }
}
