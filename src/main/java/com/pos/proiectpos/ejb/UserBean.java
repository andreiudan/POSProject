package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.UserDto;
import com.pos.proiectpos.entities.Product;
import com.pos.proiectpos.entities.User;
import com.pos.proiectpos.entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class UserBean
{
    @Inject
    PasswordBean passwordBean;
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers() {
        LOG.info("findAllUsers");

        try {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();

            return copyUsersToDto(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<User> users) {
        LOG.info("copyUsersToDto");

        List<UserDto> userDto;
        userDto = users
                .stream()
                .map(x -> new UserDto(x.getId(),x.getUsername(), x.getFirstName(), x.getLastName(), x.getPosition())).collect(Collectors.toList());

        return userDto;
    }

    public void createUser(String username, String password, String firstName, String lastName, Collection<String> groups) {
        LOG.info("createUser");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordBean.convertToSha256(password));
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        entityManager.persist(newUser);
        assignGroupsToUser(username, groups);
    }
    public void updateUser(Long userId, String username,String password, String firstName,String lastName,String position) {
        LOG.info("updateUser");

        User user=entityManager.find(User.class,userId);
        user.setId(userId);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPosition(position);
    }

    public void deleteUsersByIds(Collection<Long> userIds) {
        LOG.info("deleteUserssByIds");

        for(Long userId:userIds)
        {
            User user=entityManager.find(User.class,userId);
            entityManager.remove(user);
        }
    }
    private void assignGroupsToUser(String username, Collection<String> groups) {
        LOG.info("assignGroupsToUser");
        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUserGroup(group);
            entityManager.persist(userGroup);
        }
    }
    public Collection<String> findUsernamesByUserIds(Collection<Long> userIds){
        List<String> username=
                entityManager.createQuery("Select u.username FROM User u WHERE u.id IN :userIds",String.class)
                        .setParameter("userIds",userIds)
                        .getResultList();
        return username;
    }
}
