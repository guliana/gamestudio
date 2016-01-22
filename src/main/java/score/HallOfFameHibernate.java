package score;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class HallOfFameHibernate extends HallOfFame {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public void addScore(String name, String game, int time) throws Exception {
		// TODO Auto-generated method stub
		entityManager.persist(new UserScore(name, game, time));

	}

	@Override
	public List<UserScore> loadScore() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select s from UserScore", UserScore.class).getResultList();
	}

	public List<UserScore> loadScore(String game) throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select s from UserScore s where game= :game", UserScore.class)
				.setParameter("game", game).getResultList();
	}

	public void setRating(String game, String name, int rating) throws Exception {

	}
}
