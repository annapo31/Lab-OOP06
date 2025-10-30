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


    private Map<String, Set<U>> groups;


    /*
     * [CONSTRUCTORS]
     */
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
        super(name, surname, user, userAge);
        this.groups = new HashMap<>();
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        // Contains all the users in a specific group named 'circle'
        // we use Set in order to NOT have duplicates
        Set<U> circleUser = this.groups.get(circle);
        // If the group doesn't exit -> It creates a new group and it insert it in the map
        if(circleUser == null) {
            circleUser = new HashSet<>();
            this.groups.put(circle, circleUser);
            // In questo momento il gruppo è vuoto
        }
        return circleUser.add(user);
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        final Collection<U> usersInGroup = this.groups.get(groupName);
        if(usersInGroup == null) {
            return Collections.emptyList();
        }

        return usersInGroup;
    }

    @Override
    public List<U> getFollowedUsers() {
        // With Set -> No repetitions
        Set<U> followedUser = new HashSet<>();

        for(Set<U> users: groups.values()) {
            followedUser.addAll(users);
        }
        return new ArrayList<>(followedUser);
    }
}
