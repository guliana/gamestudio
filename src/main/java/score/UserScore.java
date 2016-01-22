package score;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserScore implements Serializable, Comparable<UserScore> {
	private static final long serialVersionUID = 1L;
	
	
	
	public UserScore() {
		super();
	}

	@Id
	@GeneratedValue
	private long id; 
	
	private String name;
 	
	private String game;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public void setTime(int time) {
		this.time = time;
	}

	private int time;
	
	public UserScore(String name, String game, int time) {
		this.name = name;
		this.game = game;
		this.time = time;
	}

	public String getGame() {
		return game;
	}


	public String getName() {
		return name;
	}
	
	public int getTime() {
		return time;
	}

	@Override
	public int compareTo(UserScore o) {		
		return time - o.time;
//		if(time < o.time)
//			return -1;
//		else if(time > o.time)
//			return 1;
//		return 0;
	}
}
