package xyz.ioc.access;

import io.github.mcroteau.resources.access.Accessor;

import java.sql.Statement;
import java.util.Set;

public class JdbcAccessor implements Accessor {

    @Override
    public String getPassword(String username) {
        return null;
    }

    @Override
    public Set<String> getRoles(String username) {

        return null;
    }

    @Override
    public Set<String> getPermissions(String username) {
        return null;
    }
}
