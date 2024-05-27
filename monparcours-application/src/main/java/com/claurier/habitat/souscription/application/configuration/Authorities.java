package com.claurier.habitat.souscription.application.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service("authorities")
public class Authorities
{
    public boolean hasViewPrivileges(Authentication auth)
    {
        return hasPrivileges(auth, listView());
    }

    public boolean hasManagePrivileges(Authentication auth)
    {
        return hasPrivileges(auth, listManage());
    }

    /**
     * Indique si l'objet {@link Authentication} passé en paramètre
     * contient au moins l'un des privilèges de la Liste {@code desiredPrivileges}.
     */
    private boolean hasPrivileges(Authentication auth, List<String> desiredPrivileges)
    {
        return getAuthoritiesStream(auth).anyMatch(desiredPrivileges::contains);
    }

    /**
     * getter  null safe
     */
    private Stream<String> getAuthoritiesStream(Authentication auth)
    {
        return Optional.ofNullable(auth)
                       .map(Authentication::getAuthorities)
                       .map(Collection::stream)
                       .orElseGet(Stream::empty)
                       .map(GrantedAuthority::getAuthority);
    }

    /**
     * Create here list of roles
     * that can perform type of actions
     */
    private List<String> listView()
    {
        return Arrays.asList(Roles.CAN_READ, Roles.CAN_CREATE, Roles.CAN_UPDATE, Roles.CAN_DELETE);
    }

    private List<String> listManage()
    {
        return Arrays.asList(Roles.CAN_CREATE, Roles.CAN_UPDATE, Roles.CAN_DELETE);
    }

    public class Roles
    {
        private Roles()
        {
        }

        /**
         * Put here your applicative roles
         */
        public static final String CAN_READ = "ROLE_CAN_READ";
        public static final String CAN_CREATE = "ROLE_CAN_CREATE";
        public static final String CAN_UPDATE = "ROLE_CAN_UPDATE";
        public static final String CAN_DELETE = "ROLE_CAN_DELETE";

    }

}