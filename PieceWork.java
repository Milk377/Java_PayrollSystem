
public class PieceWork extends Employee{

    private double piece;
    private double wage;

    public PieceWork( Boolean _covid19, String first, String last, String ssn, int month, int day, int year, int workYear, double _piece , double _wage)
    {
        super(_covid19, first, last, ssn, month, day, year, workYear);

        setWage(_wage);
        setPiece(_piece);

    }

    public void setWage(double _wage) { wage = _wage; }
    public double getWage() { return wage; }


    public void setPiece(double _piece) { piece = _piece; }
    public double getPiece() { return piece; }

    @Override
    public double earnings()
    {
        return getPiece() * getWage();
    } // end method earnings

    // return String representation of HourlyEmployee object
    @Override
    public String toString()
    {
        return String.format( "%s %s\n%s: $%,.2f; %s: %,.2f",
                "Piece Work ",super.toString(), "PieceWork wage", getWage(),
                "Pieces ", getPiece() );
    } // end method toString



}

