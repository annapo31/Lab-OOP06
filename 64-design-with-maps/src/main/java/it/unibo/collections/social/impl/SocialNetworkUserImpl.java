/**
 *
 */

package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 *
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    private Map<String, Set<U>> groups = new HashMap<>();


    /*
     * [CONSTRUCTORS]
     *
     */
    public SocialNetworkUserImpl(
        final String firstName, 
        final String lastName,
        final String userName,
        final Integer age,
        ) {
            super(firstName, lastName, userName, age);
            // We do not need control because UserImpl does that

            // At the beginning the map is empty
            this.group = new HashMap<>();
    }

    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(null, null, null, 0);
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        return false;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        return null;
    }

    @Override
    public List<U> getFollowedUsers() {
        return null;
    }
}
