 /* 
 * This is a program that produces output of a policy owner's full name, who is insured, what type of policy
 * they have, and the amount of the premium of the policy. 
 */

public abstract class Policy implements BookValue {
  
  private String owner;     // policy owners full, legal name
  private String insured;       // full, legal name of names insured on policy 
  private String polNbr;           // unique identifier for specific policy 
  private double polPrem;                    // annual premium amount for policy 
  
  /*
   * CONSTRUCTORS
   */
  
  public Policy( String own,
                String insd, 
                String nbr,
                double prem)
  { 
    setOwner( own );
    setInsured( insd );
    setPolNbr( nbr );
    setPolPrem( prem );
  } //end full constructor 
  
  public Policy( )
  {
    // This is intended to be empty 
  }  //end null constuctor
  /*
   * SET METHODS
   */ 
  public final void setOwner(String own) {
    owner = own;
  }  // end setOwner
  
  public final void setInsured(String insd) {
    insured = insd;
  }  //end setInsured
  
  public final void setPolNbr(String nbr) {
    polNbr = nbr;
  } // end setPolNbr
  
  public final void setPolPrem(double prem) {
    polPrem = prem;
  } // end setPolPrem
  /*
   * GET METHODS
   */
  public final String getOwner() {
    return owner;
  } // end getOwner
  
  
  public final String getInsured() {
    return insured;
  }  // end getInsured
  
  
  
  public final String getPolNbr() {
    return polNbr;
  } //end getPolNbr
  
  
  
  public final double getPolPrem() {
    return polPrem;
  } // end getPolPrem
  
  /*
   * OTHER METHODS AS NEEDED
   */
  
  public String identifyContract() {
    return polNbr;
  } //end identifyContract
  
  public String toString() 
  {
     // Return a verbose description of the Policy Object. 
    return String.format( "%s owns Policy %s, insuring %s, with a premium of $%,.2f.%n",
                         getOwner( ),
                         getPolNbr( ),
                         getOwner( ),
                         getPolPrem( ) );
  }  //end toString
  
} //end abstract class Policy implements BookValue