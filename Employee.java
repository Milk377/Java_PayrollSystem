// Exercise 10.8 Solution: Employee.java
// Employee abstract superclass.

public abstract class Employee 
{
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;
   private Date birthDate;
   private Date confirmCovidDate;

   private boolean Covid19;

   // workYear 추가
   private int workYear;

   // six-argument constructor
   // work year 추가
   public Employee( boolean _covid19, String first, String last, String ssn,
      int month, int day, int year , int _workYear)
   {
      // 확진 여부만 알 수 있게 설정 가능함.
      Covid19 = _covid19;
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
      birthDate = new Date( month, day, year );
      workYear = _workYear;

   } // end seven-argument Employee constructor

   // 날짜까지 추가하고 싶다면 이렇게
   public void SetConFirmCovid(boolean _covid19,int _month, int _day, int _year) {
      Covid19 = _covid19;
      confirmCovidDate = new Date(_month,_day,_year);
   }

   public Date getConfirmCovidDate() { return confirmCovidDate;}
   public boolean getCovidConfirmData() { return Covid19;}


   public int getWorkYear() { return workYear ;}
   public boolean work_10_years(int _workYear) { if(_workYear >= 10) return true; else return false; }


   // set first name
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // return last name
   public String getLastName()
   {
      return lastName;
   } // end method getLastName

   // set social security number
   public void setSocialSecurityNumber( String ssn )
   {
      socialSecurityNumber = ssn;  // should validate
   } // end method setSocialSecurityNumber

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } // end method getSocialSecurityNumber

   // set birth date
   public void setBirthDate( int month, int day, int year )
   {
      birthDate = new Date( month, day, year );
   } // end method setBirthDate

   // return birth date
   public Date getBirthDate()
   {
      return birthDate;
   } // end method getBirthDate

   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format( "%s %s\n%s: %s\n%s: %s", 
         getFirstName(), getLastName(), 
         "social security number", getSocialSecurityNumber(), 
         "birth date", getBirthDate() );
   } // end method toString

   // abstract method overridden by subclasses
   public abstract double earnings();
} // end abstract class Employee
