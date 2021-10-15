public class BasePlusPieceWork extends PieceWork {

   // private double piece;
   // private double wage;
    private double salary;


    public BasePlusPieceWork(boolean _covid19, String first, String last, String ssn, int month, int day, int year, int workYear, double _piece , double _wage, double _salary)
    {
        super(_covid19, first, last, ssn, month, day, year, workYear,_piece,_wage);

        //setWage(_wage);
        //setPiece(_piece);

        setSalary(_salary);


    }
    // public void setWage(double _wage) { wage = _wage; }
    // public double getWage() { return wage; }
    public void setSalary(double _salary) { salary = _salary;}
    public double getSalary() { return salary; }
    //public void setPiece(double _piece) { piece = _piece; }
    //public double getPiece() { return piece; }

    @Override
    public double earnings()
    {
        return super.earnings() + getSalary();
    } // end method earnings

    // return String representation of HourlyEmployee object
    @Override
    public String toString()
    {
        return String.format( "%s %s\n%s: $%,.2f; %s: %,.2f",
                "BasePlus",super.toString(), "BasePlusPieceWork Salary", getSalary(), "wage" , getWage(),
                "Pieces ", getPiece() );
    } // end method toString


}
