package kodluyoruz.librarysystem.core.utilities.Business;

import kodluyoruz.librarysystem.core.utilities.Results.Result;

public class BusinessRules {
  public static Result Run(Result... logics) {
	  for(Result logic:logics) {
		  if(!logic.isSuccess()) {
			  return logic;
		  }
	  }
	  return null;
  }
}
