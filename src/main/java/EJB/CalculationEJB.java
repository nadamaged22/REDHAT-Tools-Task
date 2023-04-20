package EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import databasemodel.Calculation;

@Stateless
public class CalculationEJB {
	 @PersistenceContext
	 private EntityManager entityManager;
	 CalculationEJB(){}
	 
	 public void InsertCalculation(Calculation calc) {
		 entityManager.persist(calc);
		 
	 }
	 public List<Calculation> Retreive(){
		 TypedQuery<Calculation> query = entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class);
		 return query.getResultList();
	 }

}
