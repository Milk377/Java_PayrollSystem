// Exercise 10.8 Solution: HourlyEmployee.java
// HourlyEmployee class derived from Employee.


public class HourlyEmployee extends Employee 
{
   private double wage; // wage per hour
   private double hours; // hours worked for week

   // eight-argument constructor
   public HourlyEmployee(boolean _covid19, String first, String last, String ssn,
      int month, int day, int year, int workYear ,
      double hourlyWage, double hoursWorked )
   {
      super(_covid19, first, last, ssn, month, day, year ,workYear);
      setWage( hourlyWage );
      setHours( hoursWorked );
   } // end eight-argument HourlyEmployee constructor

   // set wage
   public void setWage( double hourlyWage )
   {
      wage = hourlyWage < 0.0 ? 0.0 : hourlyWage;
   } // end method setWage

   // return wage
   public double getWage()
   {
      return wage;
   } // end method getWage

   // set hours worked
   public void setHours( double hoursWorked )
   {
      hours = ( ( hoursWorked >= 0.0 ) && ( hoursWorked <= 168.0 ) ) ?
         hoursWorked : 0.0;
   } // end method setHours

   // return hours worked
   public double getHours()
   {
      return hours;
   } // end method getHours

   // calculate earnings; override abstract method earnings in Employee
   @Override
   public double earnings()
   {
      if ( getHours() <= 40 ) // no overtime
         return getWage() * getHours();
      else
         return 40 * getWage() + ( getHours() - 40 ) * getWage() * 1.5;
   } // end method earnings

   // return String representation of HourlyEmployee object
   @Override
   public String toString()
   {
      return String.format( "hourly employee: %s\n%s: $%,.2f; %s: %,.2f", 
         super.toString(), "hourly wage", getWage(), 
         "hours worked", getHours() );
   } // end method toString
} // end class HourlyEmployee
