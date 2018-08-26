package prog3060.jwong;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;

public class GeoDataBean {
	static final String PERSISTENCE_UNIT_NAME = "Assignment2JPAApplication";
	List<GeographicArea> geographicList;
	List<Age> popData;
	List<Household> numberOfHouseholds = new ArrayList<Household>();
	List<Age> ageGroupList;
	List<Household> householdIncome = new ArrayList<Household>();

	public List<GeographicArea> getGeographicList() {
		EntityManagerFactory tempEntityManagerFactory = null;
		EntityManager tempEntityManager = null;

		try {
			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			tempEntityManager = tempEntityManagerFactory.createEntityManager();

			tempEntityManager.getTransaction().begin();

			String query = "FROM GeographicArea";

			Query baseQuery = tempEntityManager.createQuery(query);

			this.geographicList = baseQuery.getResultList();

			tempEntityManager.getTransaction().rollback();

		} catch (Exception e) {

			if (tempEntityManager != null) {

				tempEntityManager.getTransaction().rollback();

			}

			e.printStackTrace();

		} finally {

			if (tempEntityManager != null) {

				tempEntityManager.close();

			}

			if (tempEntityManagerFactory != null) {

				tempEntityManagerFactory.close();

			}

		}
		return this.geographicList;
	}

	public List<Age> getPopData() {
		EntityManagerFactory tempEntityManagerFactory = null;
		EntityManager tempEntityManager = null;

		try {
			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			tempEntityManager = tempEntityManagerFactory.createEntityManager();

			tempEntityManager.getTransaction().begin();

			String query = "FROM Age WHERE ageGroup = 1";

			Query baseQuery = tempEntityManager.createQuery(query);

			this.popData = baseQuery.getResultList();

			tempEntityManager.getTransaction().rollback();

		} catch (Exception e) {

			if (tempEntityManager != null) {

				tempEntityManager.getTransaction().rollback();

			}

			e.printStackTrace();

		} finally {

			if (tempEntityManager != null) {

				tempEntityManager.close();

			}

			if (tempEntityManagerFactory != null) {

				tempEntityManagerFactory.close();

			}

		}
		return this.popData;
	}

	public List<Household> getNumberOfHouseholds() {
		EntityManagerFactory tempEntityManagerFactory = null;
		EntityManager tempEntityManager = null;
		try {
			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			tempEntityManager = tempEntityManagerFactory.createEntityManager();

			tempEntityManager.getTransaction().begin();

			String query = "FROM Household hh " + "JOIN hh.geographicArea ga " + "JOIN hh.censusYear cy "
					+ "JOIN hh.householdType hht " + "JOIN hh.householdSize hhs " + "JOIN hh.householdsByAgeRange hhb "
					+ "JOIN hh.householdEarners hhe " + "JOIN hh.totalIncome ti " + "WHERE cy.censusYear= 2016"
					+ "AND hht.id=4" + "AND hhs.id=3" + "AND hhb.id=7 " + "AND hhe.id=3 " + "AND ti.id= 15";
			Query baseQuery = tempEntityManager.createQuery(query);
			List<Object[]> tempResultList = baseQuery.getResultList();

			for (Object[] a : tempResultList) {

				this.numberOfHouseholds.add((Household) a[0]);
			}

			tempEntityManager.getTransaction().rollback();

		} catch (Exception e) {

			if (tempEntityManager != null) {

				tempEntityManager.getTransaction().rollback();

			}

			e.printStackTrace();

		} finally {

			if (tempEntityManager != null) {

				tempEntityManager.close();

			}

			if (tempEntityManagerFactory != null) {

				tempEntityManagerFactory.close();

			}

		}
		return this.numberOfHouseholds;
	}

	public List<Age> getAgeGroup() {
		EntityManagerFactory tempEntityManagerFactory = null;
		EntityManager tempEntityManager = null;

		try {
			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			tempEntityManager = tempEntityManagerFactory.createEntityManager();

			tempEntityManager.getTransaction().begin();

			String query = "FROM Age "
					+ "WHERE ageGroup IN(3,9,15,22,28,34,40,46,52,58,64,70,76,83,89,95,101,108,114,120,126)"
					+ "AND geographicArea = 1";

			Query baseQuery = tempEntityManager.createQuery(query);

			this.ageGroupList = baseQuery.getResultList();

			tempEntityManager.getTransaction().rollback();

		} catch (Exception e) {

			if (tempEntityManager != null) {

				tempEntityManager.getTransaction().rollback();

			}

			e.printStackTrace();

		} finally {

			if (tempEntityManager != null) {

				tempEntityManager.close();

			}

			if (tempEntityManagerFactory != null) {

				tempEntityManagerFactory.close();

			}

		}
		return this.ageGroupList;
	}

	public List<Household> getHouseholdIncome() {
		EntityManagerFactory tempEntityManagerFactory = null;
		EntityManager tempEntityManager = null;

		try {
			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			tempEntityManager = tempEntityManagerFactory.createEntityManager();

			tempEntityManager.getTransaction().begin();

			String query = "FROM Household hh " + "JOIN hh.geographicArea ga " + "JOIN hh.censusYear cy "
					+ "JOIN hh.householdType hht " + "JOIN hh.householdSize hhs " + "JOIN hh.householdsByAgeRange hhb "
					+ "JOIN hh.householdEarners hhe " + "JOIN hh.totalIncome ti " + "WHERE cy.censusYear= 2016 "
					+ "AND ga.level= 1 " + "AND hht.id=4 " + "AND hhs.id=3 " + "AND hhb.id=9 " + "AND hhe.id=3 "
					+ "AND ti.id= 22";

			Query baseQuery = tempEntityManager.createQuery(query);
			List<Object[]> tempResultList = baseQuery.getResultList();

			for (Object[] a : tempResultList) {

				this.householdIncome.add((Household) a[0]);
			}

			tempEntityManager.getTransaction().rollback();

		} catch (Exception e) {

			if (tempEntityManager != null) {

				tempEntityManager.getTransaction().rollback();

			}

			e.printStackTrace();

		} finally {

			if (tempEntityManager != null) {

				tempEntityManager.close();

			}

			if (tempEntityManagerFactory != null) {

				tempEntityManagerFactory.close();

			}

		}
		return this.householdIncome;
	}
}
