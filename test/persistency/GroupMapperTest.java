package persistency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entities.Group;

public class GroupMapperTest {
	private Group myGroup;

	@Before
	public void setUp() throws Exception {
		this.myGroup = new Group("just a group");	// group is a prerequesite for a person
	}
	
	@Test
	public void testCreateGroup() {
		int id = GroupMapper.INSTANCE.createGroup(this.myGroup);
		Group createdGroup = GroupMapper.INSTANCE.getGroupById(id);
		assertEquals("No consistent ID's when creating a group", id,
				createdGroup.getId());
		GroupMapper.INSTANCE.deleteGroup(createdGroup);
	}
	
	@Test
	public void testDeleteGroup() {
		int id = GroupMapper.INSTANCE.createGroup(this.myGroup);
		Group createdGroup = GroupMapper.INSTANCE.getGroupById(id);
		assertEquals("Group not deleted",1 , GroupMapper.INSTANCE.deleteGroup(createdGroup));
	}
}
