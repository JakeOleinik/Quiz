package persistency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entities.Group;
import entities.Team;

public class TeamMapperTester {
	private Team team;

	@Before
	public void setUp() throws Exception {
		this.team = new Team("TestTeam", GroupMapper.INSTANCE.getGroupById(1));
	}
	
	@Test
	public void testCreateTeam() {
		int id = TeamMapper.INSTANCE.createTeam(this.team);
		Team createdTeam = TeamMapper.INSTANCE.getTeamById(id);
		assertEquals(id, createdTeam.getId());
		TeamMapper.INSTANCE.deleteTeam(createdTeam);
	}
	
	@Test
	public void testDeleteTeam() {
		int id = TeamMapper.INSTANCE.createTeam(this.team);
		Team createdTeam = TeamMapper.INSTANCE.getTeamById(id);
		assertEquals("Group not deleted",1 , TeamMapper.INSTANCE.deleteTeam(createdTeam));
	}
}
