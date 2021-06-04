import java.util.Calendar;

public class PrintCalendar {
    /**
     * Main method
     */
    public static void main(String[] args) {


        int year = 2018;

        int month = 3;

        // Print calendar for the month of the year
        printMonth(year, month);
        /**March 2018
         -----------------------------
         Sun Mon Tue Wed Thu Fri Sat
         1   2   3
         4   5   6   7   8   9  10
         11  12  13  14  15  16  17
         18  19  20  21  22  23  24
         25  26  27  28  29  30  31r**/
    }

    /**
     * Print the calendar for a month in a year
     */
    public static void printMonth(int year, int month) {
        // Print the headings of the calendar
        printMonthTitle(year, month);

        // Print the body of the calendar
        printMonthBody(year, month);
    }

    /**
     * Print the month title, e.g., March 2012
     */
    public static void printMonthTitle(int year, int month) {
        System.out.println(" " + getMonthName(month)
                + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * Get the English name for the month
     */
    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
        }

        return monthName;
    }

    /**
     * Print month body
     */


    public static void printMonthBody(int year, int month) {
        // Get start day of the week for the first date in the month
        int startDay = getStartDay(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay; i++)
            System.out.print("\t");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0)
                System.out.println();
        }

        System.out.println();
    }

    /**
     * Get the start day of month/1/year
     */
    public static int getStartDay(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH,month-1);
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.DATE,0);
        return cal.get(Calendar.DAY_OF_WEEK)%7;



    }



    /**
     * Get the number of days in a month
     */
    public static int getNumberOfDaysInMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH,month-1);
        cal.set(Calendar.YEAR,year);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    }


}
