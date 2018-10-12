import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user1, user2, user3;

    @Before
    public void setUp() {
        this.user1 = new User("ali", "tabatabaei");
        this.user2 = new User("malikeh", "ehghaghi");
        this.user2 = new User("reza", "daemi");
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAddNullFriend() {
        user1.addFriend(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAddHimSelfAsFriend() {
        user1.addFriend(user1);
    }

    @Test  (expected = IllegalArgumentException.class)
    public void shouldNotAddDuplicateFriend() {
        user1.addFriend(user2);
        user1.addFriend(user2);
    }

    @Test
    public void shouldNotBeFriendWithRemovedFriend() {
        user1.friends.add(user2);
        user2.friends.add(user1);
        user1.removeFriend(user2);
        assertFalse(user1.friends.contains(user2));
    }

    @Test
    public void shouldNotHaveReverseFriendshipByRemovedFriend() {
        user1.friends.add(user2);
        user2.friends.add(user1);
        user1.removeFriend(user2);
        assertFalse(user2.friends.contains(user1));
    }

    @Test
    public void shouldBeFriendWithAddedFriend() {
        user1.addFriend(user2);
        assertTrue(user1.friends.contains(user2));
    }

    @Test
    public void shouldHaveReverseFriendshipByRemovedFriend() {
        user1.addFriend(user2);
        assertTrue(user2.friends.contains(user1));
    }

    @Test
    public void shouldNotBeFriendWithNullUser() {
        assertFalse(user1.isFriendsWith(null));
    }

    @Test
    public void shouldNotBeFriendWithHimself() {
        assertFalse(user1.isFriendsWith(user1));
    }

    @Test (expected = Exception.class)
    public void shouldThrowExceptionOnRemoveNotFoundFriend() {
        user1.friends.add(user2);
        user1.removeFriend(user3);
    }
}