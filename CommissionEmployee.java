// Exercise 10.8 Solution: CommissionEmployee.java
// CommissionEmployee class derived from Employee.

public class CommissionEmployee extends Employee 
{
   private double grossSales; // gross weekly sales
   private double commissionRate; // commission percentage

   // eight-argument constructor
   public CommissionEmployee(boolean _covid19, String first, String last, String ssn,
      int month, int day, int year, int workYear, double sales, double rate )
   {
      super(_covid19, first, last, ssn, month, day, year, workYear );
      setGrossSales( sales );
      setCommissionRate( rate );
   } // end eight-argument CommissionEmployee constructor

   // set commission rate
   public void setCommissionRate( double rate )
   {
      commissionRate = ( rate > 0.0 && rate < 1.0 ) ? rate : 0.0;
   } // end method setCommissionRate

   // return commission rate
   public double getCommissionRate()
   {
      return commissionRate;
   } // end method getCommissionRate

   // set gross sales amount
   public void setGrossSales( double sales )
   {
      grossSales = sales < 0.0 ? 0.0 : sales;
   } // end method setGrossSales

   // return gross sales amount
   public double getGrossSales()
   {
      return grossSales;
   } // end method getGrossSales

   // calculate earnings; override abstract method earnings in Employee
   @Override
   public double earnings()
   {
      return getCommissionRate() * getGrossSales();
   } // end method earnings

   // return String representation of CommissionEmployee object
   @Override
   public String toString()
   {
      return String.format( "%s: %s\n%s: $%,.2f; %s: %.2f", 
         "commission employee", super.toString(), 
         "gross sales", getGrossSales(), 
         "commission rate", getCommissionRate() );
   } // end method toString   
} // end class CommissionEmployee
